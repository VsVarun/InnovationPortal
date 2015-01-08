
    function CheckCookie() {
        $(document).ready(function () {
            
            //if ($.cookie('UserLogin') == null) {
            //    alert('Session Expired');
            //    window.location.href = 'Login.html';
            //}


            //var hours = 1; // Reset when storage is more than 24hours
            //var now = new Date().getTime();
            //var setupTime = localStorage.getItem('setupTime');
            //if (setupTime == null) {
            //    localStorage.setItem('setupTime', now)
            //} else {
            //    if (now - setupTime > hours * 60 * 60 * 1000) {
            //        localStorage.clear()
            //        localStorage.setItem('setupTime', now);
            //    }
            //}

           // var object = JSON.parse(sessionStorage.getItem("UserInfomation")), dateString = object.timestamp, now = new Date().getTime().toString()
            //alert(object);

            
            var obj1 = JSON.parse(sessionStorage.getItem("key"));
            alert(obj1[1]);

           
        });

               
    }
