function modify(){
    window.open("../modify_user_info/modify_user_info.html",target="_self");
}

function back(){
    window.open("../customer/customer.html",target="_self");
    history.back(-1);
}

function openNav(){
    document.getElementById("nav").style.width="250px";
    document.getElementById("container").style.marginLeft="250px";
}

function closeNav(){
    document.getElementById("nav").style.width = "0";
    document.getElementById("container").style.marginLeft= "0";
}
