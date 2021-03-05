function draw(){
    let w=document.getElementById("width").value;
    let l=document.getElementById("lenght").value;
    for (let i=0; i<w; i++){
        document.write("<br><br>");
        for (let j=0; j<l; j++){
            document.write("*");
        }
    }

}