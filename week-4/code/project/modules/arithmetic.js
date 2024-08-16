

export default function addNums(a,b){
    "use strict";
    var c = a+b;
    if(a<0 || b<0){
        let def = 0;
        return def;
    }
    return c;
}

console.log(def);
console.log(c);

function subtractNums(a,b){
    return a-b;
}

function multiplyNums(a,b){
    return a*b;
}

function divideNums(a,b){
    if (b === 0) {
        throw new Error('Cannot divide by zero');
    }
    return a/b;
}

//export default {addNums, subtractNums, multiplyNums, divideNums};