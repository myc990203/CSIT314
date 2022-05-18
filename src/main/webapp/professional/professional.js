function logOut(){
    window.open("../index.jsp",target="_self");
}
function userInfo(){
    window.open("../pro_user_info/pro_user_info.html",target="_self");
}
function currentResuest(){
    window.open("../current_request/current_request.html",target="_self");
}
function commission(){
    window.open("../commission/commission.html",target="_self");
}
function serveHistory(){
    window.open("../order_history/order_history.html",target="_self");
}
// current location
var latitude;
var longitude;


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
        latitude = lat;
        longitude = lng;
        var site = lat.toFixed(6)+','+lng.toFixed(6);
        console.log(site)
        // document.getElementById("demo").innerHTML = site;
        showMap();
    }

}
function showMap(){
    // document.getElementById("map").style.display = "block";
    document.getElementById("map").innerHTML = "<iframe width=100% height=100% style=border:0 loading=lazy allowfullscreen referrerpolicy=no-referrer-when-downgrade src=https://www.google.com/maps/embed/v1/place?key=AIzaSyCD3IzyW0QXpfbqQequxGGx2CPVpVZsV1c&q="+latitude+","+longitude+"> </iframe>";
}

function confirmRequest(requestID){
    document.cookie="requestID="+requestID+"; path=/CSIT314_war_exploded";
    window.open("../current_request/current_request.html",target="_self");
}
