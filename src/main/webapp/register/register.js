function back(){
    alert("You have successfully registered!")
    window.location.href= "../login/login.html";
}
//reset parameters
function reset(){
    document.getElementById("userName").value = "";
    document.getElementById("password").value = "";
    document.getElementById("confirm").value = "";
    document.getElementById("userType").value = "0";
    document.getElementById("birthday").value = "";
    document.getElementById("email").value = "";
    document.getElementById("phone").value = "";
}
// check password
function checkPassword(){
    var password = document.getElementById("password").value;
    var confirm = document.getElementById("confirm").value;
    var test = document.getElementById("test");
    if(password != confirm){
        // alert("Password does not match!");
        test.innerHTML = "Password does not match!";
        return false;
    }else{
        test.innerHTML = "";
        return true;
    }
}