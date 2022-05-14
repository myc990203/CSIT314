function modify(){
    document.modify_page.submit();
    window.open("../user_info/info.html",target="_self");
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
