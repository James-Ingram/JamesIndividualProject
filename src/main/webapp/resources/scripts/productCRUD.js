

function getAllProducts()
{
	var response = document.getElementById('productsOut')
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAllProducts");
    xhr.onload = () => {
    var returnJSON =JSON.parse(xhr.response);
    response.innerHTML = beautifyProduct(returnJSON);
    }
    xhr.send();
}

function createProduct()
{
	var responseText = document.getElementById('productsOut')
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/createProduct");
    xhr.onload = () => {
        var returnJSON =JSON.parse(xhr.response);
    	responseText.innerHTML=beautifyStock(returnJSON);
    }
    xhr.send();
}
