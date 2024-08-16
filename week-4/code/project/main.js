//import addNums from "./modules/arithmetic.js";

console.log("Hello World!");

// "use strict";

const a = 10;

// while (a!=0){
//     console.log(a);

// }

// console.log(a);

//console.log(addNums(10,20));

fruits = ["apple", "watermelon", "mango"];

fruits.push("peach");



const values = [1,3,4,67,89]

fruits.splice(2,2,"grapes");

fruits.forEach((fruit, index) => {

    console.log(`value at ${index} is ${fruit}`);
    
});

console.log(fruits.includes("grapes"))
console.log(values.find((element) => element > 10));


if (values.includes(3)){
    console.log("contains three");

}
else {
    console.log("doesnt contain 3");
}

i = 3;

switch(i){
    case 1: console.log("one"); 
    break;
    case 2: console.log("two");
    break;
    case 3: console.log("three");
     break;
    default: console.log("default");
}

for(let i = 0; i<10; i++){

    console.log(i);

}

while(i<10){

    console.log(i);
    i++;
}

do {
    console.log(i);
    i++;

}
while(i<10)






