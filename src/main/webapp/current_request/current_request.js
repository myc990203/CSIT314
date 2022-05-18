function back(){
    window.open("../customer/customer.html",target="_self");
}
function finishOrder() {
    // var curorder_id = getCookie("requestID");
    const req = new XMLHttpRequest();
    req.open("POST", "FinishOrder", true);
    req.setRequestHeader('Content-Type', 'application/json');
    var jsonObj = new Object();
    var currequest_id = getCookie("requestID");
    jsonObj.requestID = currequest_id;
    jsonObj.pid = getCookie("uid");
    jsonObj.coordinates = getCookie("coordinates");
    jsonObj.status = "finished";
    console.log(currequest_id);
    req.send(JSON.stringify(jsonObj));
    window.open("../professional/professional.html",target="_self");
}
function payBtn(){
    window.open("../payment/payment.html")
}


