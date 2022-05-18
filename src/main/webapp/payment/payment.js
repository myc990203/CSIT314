function back(){
    window.open("../customer/customer.html",target="_self");
}

// function comment(){
//     window.open("../comment/comment.html",target="_self");
// }

//reset parameters
function reset(){
    document.getElementById("select_bank").value = "0";
    document.getElementById("b_num").value = "";
    document.getElementById("card_month").value = "0";
    document.getElementById("card_year").value = "0";
    document.getElementById("l_name").value = "";
    document.getElementById("f_name").value = "";
    document.getElementById("city").value = "";
    document.getElementById("z_code").value = "";
    document.getElementById("bill_post1").value = "";
    document.getElementById("bill_post2").value = "";
}
function words_deal(){
    var x=document.getElementById("TextArea1");
    var text = x.value;
    var tcount = text.split(" ").length;
    if (tcount>=140){
        alert("Sorry, The maximum number of words is 140!")
    }
    document.getElementById("textCount").innerHTML = 140-tcount;
}
var x=document.getElementById("TextArea1");
x.onkeyup = function (){
}