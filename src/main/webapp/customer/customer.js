function logOut(){
    window.open("../login/login.html",target="_self");
}
function userInfo(){
    window.open("../user_info/user_info.html",target="_self");
}
function membership(){
    window.open("../membership/membership.html",target="_self");
}
function currentOrder(){
    window.open("../current_order/current_order.html",target="_self");
}
function payment(){
    window.open("../payment/payment.html",target="_self");
}
// current location

function getLocation()
{
    var x=document.getElementById("demo");
    var lat;
    var lng;
    if (navigator.geolocation)
    {
    navigator.geolocation.getCurrentPosition(showPosition);
    }
    else{x.innerHTML="Geolocation is not supported by this browser.";}
    function showPosition(position)
    {
        lng = position.coords.longitude;
        lat = position.coords.latitude;
        var site = lat.toFixed(6)+','+lng.toFixed(6);
        console.log(site)
        document.getElementById("demo").innerHTML = site;
    }
}
