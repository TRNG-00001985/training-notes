
//promise
function getPromise(){

    return new Promise((resolve, reject) => {

        fetch('http://localhost:3000/products')
        .then((response) => {

            if(response.ok){
                return response.json();
            }
            else{
                reject();
            }

    })
    .then(data => resolve(data))
    .catch(error => reject(error))
    .finally(() => console.log('Promise has been resolved'))
})
}



function getAllProducts(){


    return fetch('http://localhost:3000/products');

}

function getProductById(id){


    return fetch(`http://localhost:3000/products/${id}`);

}

getAllProducts()
.then((response) => {

            if(response.ok){
                return response.json();
            }
            else{
                reject();
            }

    })
.then(data => {console.log(data)})
.catch(error => {console.log(error)})
.finally(() => console.log('Promise has been resolved'))

getProductById(1)
.then((response) => {

    if(response.ok){
        return response.json();
    }
    else{
        reject();
    }

})
.then(data => {console.log(data)})
.catch(error => {console.log(error)})
.finally(() => console.log('Promise has been resolved'))

getPromise()
.then(data => console.log('Data:', data))
.catch(() => console.log("unable to fetch data"));


getPromise()
.then(() => {console.log("resolved")})
.catch(() => {console.log("rejected")})
.finally(() => {console.log("filfilled")})


//Async Await

async function printProductById(id){

    let product = await fetch(`http://localhost:3000/products/${id}`);
    console.log(product);
   

}


printProductById(1);

