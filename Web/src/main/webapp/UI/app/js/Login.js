
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
   //     postJSon("https://analytics.iriworldwide.com/iMAS/Configurator/Services/UserAuthentication/SignIn", buildPostData(userid, password), function (userInfo) {
         
                //alert(JSON.parse(response.data).UserloginStatus);
          //  if ((JSON.parse(userInfo.data).UserloginStatus) == "VALID_USER_NAME_PASSWORD") {
               // userObj = userInfo;
            var userObj = '{"statusCode":200,"statusDesc":"OK","data":"{\"Id\":673,\"Ticket\":\"cnAxlcaJuIqe0xFvPDeOhOccWdig8mSPwytgZLw/8/c=c2606f75-e8a9-4161-8d9d-81d9e3305c33\",\"AppLoginID\":\"dssmd\",\"FirstName\":\"Suman\",\"LastName\":\"\",\"LoginID\":\"dssmd\",\"CustomerLoginInfo\":[{\"CustomerName\":\"ABI_ASRT\",\"CustomerID\":95,\"Locale\":\"en-UK\",\"Active\":true,\"Region\":\"US\",\"Abbrevation\":\"ABIAS\",\"LogoPath\":\"\",\"ApplicationInfo\":[{\"ApplicationName\":\"ASSORTMENT\",\"ApplicationID\":8,\"DisplayName\":\"ASSORTMENT SOLUTION\",\"Description\":\"ASSORTMENT SOLUTION\",\"IsActive\":false,\"LastModifiedBy\":0,\"ModuleInformation\":[{\"ModuleID\":27,\"DisplayName\":\"Assortment Simulation\",\"IsActive\":false,\"ModuleName\":\"Assortment Simulation\",\"IsVisible\":true,\"ApplicationID\":0,\"ImagePath\":\"../images/PPA_Icon.png\",\"PagePath\":\"../PD/PD.SilverlightTestPage.aspx\",\"ShortcutName\":\"AS\",\"InvisibleimagePath\":\"../images/PHome_IconDim.gif\",\"features\":[{\"FeatureID\":70,\"IsActive\":false,\"FeatureType\":\"CUSTOMER\",\"ModuleID\":0,\"FeatureStatus\":\"ACTIVE\",\"FeatureKey\":\"US_USER\",\"FeatureStatusID\":0,\"FeatureDesc\":\"User belongs to Assortment US\",\"FeatureStatusKey\":0},{\"FeatureID\":72,\"IsActive\":false,\"FeatureType\":\"CUSTOMER\",\"ModuleID\":0,\"FeatureStatus\":\"ACTIVE\",\"FeatureKey\":\"RMA_PLAN\",\"FeatureStatusID\":0,\"FeatureDesc\":\"Regional Marketing Area Plan\",\"FeatureStatusKey\":0},{\"FeatureID\":76,\"IsActive\":false,\"FeatureType\":\"CUS...\":\"Waterfall Primay Table\",\"FeatureStatusKey\":0},{\"FeatureID\":66,\"IsActive\":false,\"FeatureType\":\"CUSTOMER\",\"ModuleID\":0,\"FeatureStatus\":\"ACTIVE\",\"FeatureKey\":\"Secondary Reports Filter\",\"FeatureStatusID\":0,\"FeatureDesc\":\"Secondary Reports Filter\",\"FeatureStatusKey\":0},{\"FeatureID\":67,\"IsActive\":false,\"FeatureType\":\"CUSTOMER\",\"ModuleID\":0,\"FeatureStatus\":\"ACTIVE\",\"FeatureKey\":\"Dimension Report Table\",\"FeatureStatusID\":0,\"FeatureDesc\":\"Dimension Report Table\",\"FeatureStatusKey\":0},{\"FeatureID\":68,\"IsActive\":false,\"FeatureType\":\"CUSTOMER\",\"ModuleID\":0,\"FeatureStatus\":\"ACTIVE\",\"FeatureKey\":\"Dimension Selector\",\"FeatureStatusID\":0,\"FeatureDesc\":\"Dimension Selector\",\"FeatureStatusKey\":0},{\"FeatureID\":69,\"IsActive\":false,\"FeatureType\":\"CUSTOMER\",\"ModuleID\":0,\"FeatureStatus\":\"ACTIVE\",\"FeatureKey\":\"Add New Report\",\"FeatureStatusID\":0,\"FeatureDesc\":\"Add New Report\",\"FeatureStatusKey\":0},{\"FeatureID\":63,\"IsActive\":false,\"FeatureType\":\"CUSTOMER\",\"ModuleID\":0,\"FeatureStatus\":\"ACTIVE\",\"FeatureKey\":\"Admin\",\"FeatureStatusID\":0,\"FeatureDesc\":\"Admin\",\"FeatureStatusKey\":0},{\"FeatureID\":80,\"IsActive\":false,\"FeatureType\":\"CUSTOMER\",\"ModuleID\":0,\"FeatureStatus\":\"ACTIVE\",\"FeatureKey\":\"Detailed PPG Report\",\"FeatureStatusID\":0,\"FeatureDesc\":\"Detailed PPG Report\",\"FeatureStatusKey\":0}]}]}]}],\"UserloginStatus\":\"VALID_USER_NAME_PASSWORD\"}"}';

                    //sessionStorage.UserLogin = JSON.stringify(userObj);
                    //$.cookie("UserLogin", JSON.stringify(userObj), { expires: 1000000 });

            //sessionStorage.UserLogin = userObj;
            //var date = new Date();
            //date.setTime(date.getTime() + (60 * 1000));

            ////var object = { value: "value", timestamp: date};
            ////sessionStorage.setItem("suman", JSON.stringify(object));

            //$.cookie("UserLogin", 'dssmd', { expires: date });


            var object = { Name: "Suman", timestamp: new Date().getTime() }
            sessionStorage.setItem("key", JSON.parse(object));


                    loginldapstatus = true;
                    window.location.href = 'Home.html';
        //        }
            //    else {
            //        swal("LDAP Authentication failed", "Please check user id and password...", "warning");
            //        loginldapstatus = false;
            //        event.preventDefault();
            //}

              $("#divLoading").hide();
    //    });

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