
(function ($) {
    $('.trigger').click(function () {
        $('#ajaxloader1, .outer, .inner, .barlittle, .pointcircle, .bar, #loadpulse div, #shadowloader span, .loadingtext span').toggleClass('stop');
    });
})(jQuery);

jQuery(document).ready(function ($) {
    var userObj;

    $("#loginform").submit(function (event) {
        userid = $("#input-username").val().trim();
        password = $("#input-password").val().trim();
        
        event.preventDefault();

        if (LoginFieldsValidation(userid, password) == true) {
            LoginLDAPValidation(userid, password);
        }
        
    });

    // Login Fields Validation
    function LoginFieldsValidation(userid, password) {
        var fieldsvalidationstatus = false;

        if (userid == '' || password == '') {
            fieldsvalidationstatus = false;
            swal("User ID and Password are missing", "Please enter user id and password...", "warning");
            event.preventDefault();
        }
        else {
            fieldsvalidationstatus = true;
        }
       
        return Boolean(fieldsvalidationstatus);
    }

    // Login LDAP Validation and Login URL Redirect
    function LoginLDAPValidation(userid, password) {

         $("#divLoading").show();
        // Check for the LDAP authentication here and return true 
        postJSon("https://analytics.iriworldwide.com/iMAS/Configurator/Services/UserAuthentication/SignIn", buildPostData(userid, password), function (userInfo) {
         
                //alert(JSON.parse(response.data).UserloginStatus);
            if ((JSON.parse(userInfo.data).UserloginStatus) == "VALID_USER_NAME_PASSWORD") {
                    userObj = userInfo;
                    //$.cookie("UserLogin", JSON.stringify(userObj), { expires: 1000000 });
                    loginldapstatus = true;
                    window.location.href = 'Home.html';
                }
                else {
                    swal("LDAP Authentication failed", "Please check user id and password...", "warning");
                    loginldapstatus = false;
                    event.preventDefault();
            }

              $("#divLoading").hide();
        });

    }

   
    // Building the Login Details
    function buildPostData(userid, password) {
        var userInfoPost = {
            UserName: userid,
            Password: utf8_to_b64(password)
        };
        return JSON.stringify(userInfoPost);
    }


    function utf8_to_b64(str) {
        return window.btoa(unescape(encodeURIComponent(str)));
    }

});