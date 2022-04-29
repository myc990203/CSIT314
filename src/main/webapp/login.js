function login(){
    var cus = document.getElementById("cus");
    var pro = document.getElementById("pro");
    var identity;
    if (cus.checked){
        identity = cus.value;
        window.open("../customer/customer.html",target="_self");

    } else if(pro.checked){
        identity = pro.value;
        window.open("../professional/professional.html",target="_self");
    }
}