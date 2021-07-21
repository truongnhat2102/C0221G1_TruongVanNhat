let array = new Array();
array[0] = 1;
array[1] = 1;
let sum = array[0] + array[1];
for (let i = 2; i < 10; i++) {
    array[i] = array[i - 1] + array[i - 2];
    sum += array[i];
}
array.map(element => element = 2);
console.log(array);
console.log(sum);
//# sourceMappingURL=main.js.map