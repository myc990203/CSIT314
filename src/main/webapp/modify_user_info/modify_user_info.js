function getCookie(cname)
{
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i=0; i<ca.length; i++)
    {
        var c = ca[i].trim();
        if (c.indexOf(name)==0) return c.substring(name.length,c.length);
    }
    return "";
}

function modify(){
    var cusName = document.getElementById("username").value;
    var gender = document.getElementById("gender").value;
    var dob = document.getElementById("dob").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var model = document.getElementById("model").value;
    var plateNum = document.getElementById("plateNum").value;
    var cusPw = document.getElementById("new_pwd").value;
    var uid = getCookie("uid");
    var jsonObj      = {
        cusName : cusName,
        gender: gender,
        dob: dob,
        email:email,
        phone:phone,
        model:model,
        plateNum:plateNum,
        cusPw:cusPw,
        uid:uid
    };
    const req = new XMLHttpRequest();
    req.open("POST", "UpdateCus", true);
    req.setRequestHeader('Content-Type', 'application/json');
    req.send(JSON.stringify(jsonObj));

    alert("修改成功");
    window.open("../user_info/user_info.html",target="_self");
}

function back(){
    window.open("../user_info/user_info.html",target="_self");
}

function openNav(){
    document.getElementById("nav").style.width="250px";
    document.getElementById("container").style.marginLeft="250px";
}

function closeNav(){
    document.getElementById("nav").style.width = "0";
    document.getElementById("container").style.marginLeft= "0";
}
