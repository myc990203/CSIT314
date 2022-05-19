function getCookie(cname) {
    var name = cname + "=";
    var ca   = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

function modify() {
    var proName = document.getElementById("username").value;
    var gender  = document.getElementById("gender").value;
    var dob     = document.getElementById("dob").value;
    var email   = document.getElementById("email").value;
    var phone   = document.getElementById("phone").value;
    var address = document.getElementById("address").value;
    var proPw   = document.getElementById("new_pwd").value;
    var uid     = getCookie("uid");
    var jsonObj = {
        proName: proName,
        gender: gender,
        proDOB: dob,
        email: email,
        phoneNum: phone,
        location: address,
        proPw: proPw,
        uid: uid
    };
    const req   = new XMLHttpRequest();
    req.open("POST", "UpdatePro", true);
    req.setRequestHeader('Content-Type', 'application/json');
    console.log(jsonObj);
    req.send(JSON.stringify(jsonObj));
    req.onreadystatechange = function () {
        if (req.readyState === 4) {
            console.log(req.response);
            alert("修改成功");
            window.open("../pro_user_info/pro_user_info.html", target = "_self");
        }
    }

    // window.open("../pro_user_info/pro_user_info.html",target="_self");
}

function back() {
    window.open("../pro_user_info/pro_user_info.html", target = "_self");
}

function openNav() {
    document.getElementById("nav").style.width            = "250px";
    document.getElementById("container").style.marginLeft = "250px";
}

function closeNav() {
    document.getElementById("nav").style.width            = "0";
    document.getElementById("container").style.marginLeft = "0";
}
