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
        document.getElementById("address").value = latitude+"#"+longitude;
    }

}
function showMap(){
    document.getElementById("map").style.display = "block";
    document.getElementById("map").innerHTML = "<iframe width=600 height=450 style=border:0 loading=lazy allowfullscreen referrerpolicy=no-referrer-when-downgrade src=https://www.google.com/maps/embed/v1/place?key=AIzaSyCD3IzyW0QXpfbqQequxGGx2CPVpVZsV1c&q="+latitude+","+longitude+"> </iframe>";

}
// function showCookie(){
//     var x = document.cookie;
//     document.getElementById("test").innerHTML = x;
//     document.getElementById("hello").innerHTML = "Hello World";
// }

function submit(){
    window.open("../current_order/current_order.html",target="_self");
}

function saveId(){
    // 需要取到返回的json
    var id = document.getElementById("id").value;
    document.cookie = "id="+id;
}
