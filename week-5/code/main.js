

// Function
function printSomething(){

    console.log("something")

}

printSomething();

// function expressions

const evenOrOdd = function(x) {

    if(x % 2 == 0){

        return "even";

    }

    return "odd";


}

console.log(evenOrOdd(2));



function outer(){

    let x = 10;

    function inner(){

        
        let y =5;

        console.log(x);

    }

    // error as y is declared in outer function
    //console.log(y);

    inner();
}

outer();

elements = ["Hydrogen", "Heleium", "Lithium", "Berelium"];


// arrow function
const demo = (arr) => {console.log(arr.length)};

demo(elements);


// self invoking function
(function() {

    console.log("something")

})();

demoArr = ["one", "two", "three"];


// default parameters
function printArrayElements(arr = elements){

    arr.forEach(element => {

        console.log(element)
        
    });



}

printArrayElements();


//  Rest
function printNums(...num){

    num.forEach(element => {

        console.log(element);
    });
}

printNums(1,3,5,6);


// Spread
const nums = [1,2,3,4,5,6,7,8,9,10];

// Hoisting
/*
function addNums (a,b){
    console.log(`${a} + ${b} = ${a+b}`);
}

*/

addNums(...nums);

function addNums (a,b){
    console.log(`${a} + ${b} = ${a+b}`);
}

console.log("Spread")

// addNums(...nums);

john = {

    name: "John",
    age: 30
}


class Person {

    constructor(name, age){
        this.name = name;
        this.age = age;
    }

    getName(){
        return this.name;
    }

    setName(name){
        this.name = name;
    }

    getAge(){
        return this.age;
    }


    setAge(age){
        this.age = age;
    }
}

const jane = new Person("Jane", 25);

console.log(`name: ${jane.name} age: ${jane.age}`);

class CustomError extends Error{

    constructor(message){

        super(message);
    }
}


try{

    throw new CustomError("custom error");


}

catch (error){

    console.log(error.message);

}

console.log(jane instanceof Person)
