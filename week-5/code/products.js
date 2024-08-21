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

