function convert() {
    let amount=document.getElementById("v1").value;
    var from=document.getElementById("from").value;
    var to=document.getElementById("to").value;
    var result=0;
    if (from=="vn" && to=="usd"){
        result=amount/23000;
        document.write("result: "+result+"USD");
    }
    else if (from=="vn" && to=="vn"){
        result=amount;
        document.write("result: "+result+"VND");
    }
    else if (from=="usd" && to=="vn"){
        result=amount*23000;
        document.write("result: "+result+"VND");
    }
    else if (from=="usd" && to=="usd"){
        result=amount;
        document.write("result: "+result+"USD");
    }

}