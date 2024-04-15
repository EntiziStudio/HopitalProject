async function logout(){
    localStorage.removeItem("token");
    window.location.replace("login.html")
}
async function loadmenu(){
    var accounts = '<li class="nav-item"><a href="login.html" class="nav-link btn-signUp" style="color: white">Đăng Nhập</a></li>'
    var token = localStorage.getItem("token");
    if(token != null){
        accounts =  '<li class="nav-item dropdown">'+
                    '<a class="nav-link dropdown-toggle" href="department.html" id="dropdown02" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tài Khoản<i class="icofont-thin-down"></i></a>'+
                    '<ul class="dropdown-menu" aria-labelledby="dropdown02">'+
                        '<li><a class="dropdown-item" href="updateaccount.html">Cập Nhật Tài Khoản</a></li>'+
                        '<li><a class="dropdown-item" href="profile.html">Lịch hẹn</a></li>'+
                        '<li><a class="dropdown-item" style="cursor: pointer;" onclick="logout()">Đăng xuất</a></li>'+
                    '</ul>'+
                '</li>'
    }

    var menu = '<div class="header-top-bar">'+
    '<div class="container">'+
        '<div class="row align-items-center">'+
            '<div class="col-lg-6">'+
                '<ul class="top-bar-info list-inline-item pl-0 mb-0">'+
                    '<li class="list-inline-item"><a href="mailto:support@gmail.com"><i class="icofont-support-faq mr-2"></i>support@medisure.com</a></li>'+
                    '<li class="list-inline-item"><i class="icofont-location-pin mr-2"></i>Hồ Chí Minh , Viet Nam</li>'+
                '</ul>'+
            '</div>'+
            '<div class="col-lg-6">'+
                '<div class="text-lg-right top-right-bar mt-2 mt-lg-0">'+
                    '<a href="" >'+
                        '<span>Call Now : </span>'+
                        '<span class="h4">0385976084 - 0385987135</span>'+
                    '</a>'+
                '</div>'+
            '</div>'+
        '</div>'+
    '</div>'+
'</div>'+
'<nav class="navbar navbar-expand-lg navigation" id="navbar">'+
    '<div class="container">'+
          '<a class="navbar-brand" href="index.html">'+
              '<img src="images/logo.png" alt="" class="img-fluid">'+
          '</a>'+

          '<button class="navbar-toggler collapsed" type="button" data-toggle="collapse" data-target="#navbarmain" aria-controls="navbarmain" aria-expanded="false" aria-label="Toggle navigation">'+
        '<span class="icofont-navigation-menu"></span>'+
      '</button>'+
  
      '<div class="collapse navbar-collapse" id="navbarmain">'+
        '<ul class="navbar-nav ml-auto">'+
              '<li class="nav-item active"><a class="nav-link" href="index.html">Trang Chủ</a></li>'+
               '<li class="nav-item"><a class="nav-link" href="about.html">Về Chúng Tôi</a></li>'+
            '<li class="nav-item"><a class="nav-link" href="service.html">Dịch Vụ</a></li>'+
            '<li class="nav-item"><a class="nav-link" href="appoinment.html">Lịch Hẹn</a></li>'+

              '<li class="nav-item dropdown">'+
                '<a class="nav-link dropdown-toggle" href="doctor.html" id="dropdown03" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Bác Sĩ <i class="icofont-thin-down"></i></a>'+
                '<ul class="dropdown-menu" aria-labelledby="dropdown03">'+
                    '<li><a class="dropdown-item" href="doctor.html">Bác Sĩ</a></li>'+
                '</ul>'+
              '</li>'+

               '<li class="nav-item dropdown">'+
                '<a class="nav-link dropdown-toggle" href="blog-sidebar.html" id="dropdown05" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tin Tức <i class="icofont-thin-down"></i></a>'+
                '<ul class="dropdown-menu" aria-labelledby="dropdown05">'+
                    '<li><a class="dropdown-item" href="blog-sidebar.html">Tin tức y tế</a></li>'+
                '</ul>'+
              '</li>'+
            '<li class="nav-item"><a class="nav-link" href="contact.html">Liên Hệ</a></li>'+
            ''+accounts+''+
        '</ul>'+
      '</div>'+
    '</div>'+
'</nav>'
document.getElementById("menu").innerHTML = menu


var footer = '<div class="container">'+
'<div class="row">'+
    '<div class="col-lg-4 mr-auto col-sm-6">'+
        '<div class="widget mb-5 mb-lg-0">'+
            '<div class="logo mb-4">'+
                '<img src="images/logo.png" alt="" class="img-fluid">'+
            '</div>'+

            '<ul class="list-inline footer-socials mt-4">'+
                '<li class="list-inline-item"><a href="https://www.facebook.com/congdatDEV"><i class="icofont-facebook"></i></a></li>'+
                '<li class="list-inline-item"><a href="https://www.facebook.com/nguyenvuducminh2201"><i class="icofont-twitter"></i></a></li>'+
                '<li class="list-inline-item"><a href="https://www.facebook.com/A.tien.1303"><i class="icofont-linkedin"></i></a></li>'+
                '<li class="list-inline-item"><a href="https://www.facebook.com/profile.php?id=100009590499751"><i class="icofont-instagram"></i></a></li>'+

            '</ul>'+
        '</div>'+
    '</div>'+

    '<div class="col-lg-2 col-md-6 col-sm-6">'+
        '<div class="widget mb-5 mb-lg-0">'+
            '<h4 class="text-capitalize mb-3">Department</h4>'+
            '<div class="divider mb-4"></div>'+

            '<ul class="list-unstyled footer-menu lh-35">'+
                '<li><a href="#">Surgery </a></li>'+
                '<li><a href="#">Wome Health</a></li>'+
                '<li><a href="#">Radiology</a></li>'+

            '</ul>'+
        '</div>'+
    '</div>'+

    '<div class="col-lg-2 col-md-6 col-sm-6">'+
        '<div class="widget mb-5 mb-lg-0">'+
            '<h4 class="text-capitalize mb-3">Support</h4>'+
            '<div class="divider mb-4"></div>'+

            '<ul class="list-unstyled footer-menu lh-35">'+
                '<li><a href="#">Terms & Conditions</a></li>'+
                '<li><a href="#">Privacy Policy</a></li>'+
                '<li><a href="#">Company Support </a></li>'+

            '</ul>'+
        '</div>'+
    '</div>'+

    '<div class="col-lg-3 col-md-6 col-sm-6">'+
        '<div class="widget widget-contact mb-5 mb-lg-0">'+
            '<h4 class="text-capitalize mb-3">Get in Touch</h4>'+
            '<div class="divider mb-4"></div>'+

            '<div class="footer-contact-block mb-4">'+
                '<div class="icon d-flex align-items-center">'+
                    '<i class="icofont-email mr-3"></i>'+
                    '<span class="h6 mb-0">Support Available for 24/7</span>'+
                '</div>'+
                '<h4 class="mt-2"><a href="">Support@email.com</a></h4>'+
            '</div>'+

            '<div class="footer-contact-block">'+
                '<div class="icon d-flex align-items-center">'+
                    '<i class="icofont-support mr-3"></i>'+
                    '<span class="h6 mb-0">Mon to Fri : 08:30 - 18:00</span>'+
                '</div>'+
            '</div>'+
        '</div>'+
    '</div>'+
'</div>'+
'</div>'
document.getElementById("footer").innerHTML = footer
}

async function checkRoleUser(){
    var url = 'http://localhost:8080/api/user/checkroleUser';
    const response = await fetch(url, {
        method: 'GET',
        headers: new Headers({
            'Authorization': 'Bearer ' + token
        })
    });
    if(response.status > 300){
        alert("please login")
        window.location.replace('login.html')
    }
}