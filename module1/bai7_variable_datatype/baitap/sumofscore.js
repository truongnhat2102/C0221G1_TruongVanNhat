function sum(){
    let a=Number(document.getElementById('value1').value);
    let b=Number(document.getElementById('value2').value);
    let c=Number(document.getElementById('value3').value);
    let sum=a+b+c;
    document.write('sum='+sum)
    document.write('<br>')
    let average=sum / 3;
    document.write('average='+average);
}