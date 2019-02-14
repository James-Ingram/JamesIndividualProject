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
function findProduct()
{
	var responseText = document.getElementById('productsOut')
	var userInput = document.getElementById('productFindInput').defaultValue="1".value;
	var e = document.getElementById('productOptions');
	var strUser = e.options[e.selectedIndex].text;
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAProduct/"+strUser+"/"+userInput);
    xhr.onload = () => {
        var returnJSON="";
        if(xhr.repsponse "{\"Message\":\"InputEmpty\"}")
        {
        	returnJSON = "Input Invalid";
        }
        else
        {
        	returnJSON=JSON.parse(xhr.response);
        	console.log(returnJSON);
        	responseText.innerHTML=beautifyProduct(returnJSON);
        }
  
    }
    xhr.send();
}