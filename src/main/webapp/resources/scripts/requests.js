function getAllProducts()
{
	var responseText = document.getElementById('productsOut')
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAllProducts");
    xhr.onload = (res) => {
    	console.log(res['target']['response']);
        responseText.innerHTML =res['target']['response'];
    }
    xhr.send();
}

function createProduct()
{
	
}