

// function getPromise(){

//     return new Promise((resolve, reject) => {

//         fetch('http://localhost:3000/products')
//         .then((response) => {

//             if(response.ok){
//                 return response.json();
//             }
//             else{
//                 reject();
//             }

//     })
//     .then(data => resolve(data))
//     .catch(error => reject(error))
//     .finally(() => console.log('Promise has been resolved'))
// })
// }

async function getPromise(){

    try {

        data = await fetch('http://localhost:3000/products');


    }


}

getPromise()
.then(data => console.log('Data:', data))
.catch(() => console.log("unable to fetch data"));


// getPromise()
// .then(() => {console.log("resolved")})
// .catch(() => {console.log("rejected")})
// .finally(() => {console.log("filfilled")})



