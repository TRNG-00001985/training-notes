async function getProductById(id){

    let product = await fetch(`http://localhost:3000/products/${id}`);
    let data = await product.json();

    const body = document.querySelector("body");
    
    const containerDiv = document.createElement('div');
    const name = document.createElement("h1");
    name.innerText = data["name"];
    const description = document.createElement('p');
    description.innerText = data["description"];

    containerDiv.appendChild(name);
    containerDiv.appendChild(description);
    body.appendChild(containerDiv);

}


const button = document.querySelector("input");
    
button.addEventListener("keydown", (event) => getProductById(event.key));

async function createProduct(){


    const form = document.querySelector("#addProduct");

    const submit = document.querySelector("#saveProduct");

    const formData = new FormData(form, submit);

    const product = {

        name: formData.get("name"),
        description: formData.get("desc"),
        price: formData.get("price"),
        category: formData.get("cat")
    };

    const url = 'http://localhost:3000/products/';
    
    const body = JSON.stringify(product)

    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: body
    });


    console.log(response.json());

    

}






