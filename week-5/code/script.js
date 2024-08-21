
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


async function createProduct(){

    const url = 'http://localhost:3000/products/';

    const body = JSON.stringify(
        {
            name: "Bluetooth Speaker",
            description: "Portable Bluetooth speaker with 10-hour battery life and water resistance.",
            price: 45.99,
            category: "Audio",
            stock: 85,
            image: "https://example.com/images/bluetooth-speaker.jpg",
            rating: 4.7,
            reviews: [
              {
                id: 1,
                user: "Alice Brown",
                comment: "Fantastic sound quality for the size.",
                rating: 5
              },
              {
                id: 2,
                user: "Bob Johnson",
                comment: "Very durable and the battery lasts long.",
                rating: 4
              }
            ],
          }

    )

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: body
    });


    console.log(response.json());

    

}

createProduct();


async function deleteProduct() {

    const url = `http://localhost:3000/products/22`;
    const response = await fetch(url + new URLSearchParams({
        id: 22
    }) , {
        method: 'DELETE',
    });

    console.log(response);



    
}

deleteProduct();


