// function login(){
//     var cus = document.getElementById("cus");
//     var pro = document.getElementById("pro");
//     var identity;
//     if (cus.checked){
//         identity = cus.value;
//         window.open("../customer/customer.html",target="_self");
//
//     } else if(pro.checked){
//         identity = pro.value;
//         window.open("../professional/professional.html",target="_self");
//     }
// }
function getCookie(cname) {
    var name = cname + "=";
    var ca   = document.cookie.split(';');
    for (var i = 0; i < ca.length; i++) {
        var c = ca[i].trim();
        if (c.indexOf(name) == 0) return c.substring(name.length, c.length);
    }
    return "";
}

function setCookie_username() {
    var username    = document.getElementById("username").value;
    document.cookie = "username=" + username;
}

function setCookie_pwd() {
    var pwd         = document.getElementById("password").value;
    document.cookie = "pwd=" + pwd;
}


function setType1() {
    var type        = document.getElementById("cus").value;
    document.cookie = "type=" + type;
}

function setType2() {
    var type        = document.getElementById("pro").value;
    document.cookie = "type=" + type;
}

function login1() {
    var cus      = document.getElementById("cus");
    var pro      = document.getElementById("pro");
    const req    = new XMLHttpRequest();
    var userName = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    if (cus.checked) {
        var usertype = cus.value;
    } else if (pro.checked) {
        var usertype = pro.value;
    }
    var jsonObj = {
        userName: userName,
        password: password,
        type: usertype
    };
    // jsonObj.userName = userName;
    // jsonObj.password  = password;
    // jsonObj.type     = usertype;
    console.log(jsonObj);
    req.open("POST", "Login", true);
    req.setRequestHeader('Content-Type', 'application/json');
    req.send(JSON.stringify(
        jsonObj
    ));
    req.onreadystatechange = function () {
        if (req.readyState === 4) {
            console.log(req.response);
            const json      = JSON.parse(req.response);
            document.cookie = "uid=" + json.uid;
            if (cus.checked) {
                window.location.href = "./customer/customer.html";
            } else if (pro.checked) {
                window.open("./professional/professional.html", target = "_self");
            }
        }
    }
};
