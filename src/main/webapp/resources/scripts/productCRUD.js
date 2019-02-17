"use strict";
function getAllProducts()
{
	var response = document.getElementById('productsOut');
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
	var nameInput = document.getElementById('productNameInput').value;
	var descInput = document.getElementById('productDescInput').value;
	var lineInput = document.getElementById('productLineInput').value;
	var priceInput = document.getElementById('produtPriceInput').value;
	var mSRPInput = document.getElementById('productMSRPInput').value;

	var concatString ="{\"productName\":" +"\""+nameInput+"\""+   
	",\"description\":" +"\""+descInput+"\""+ 
	",\"productLine\":" +"\""+lineInput+"\""+ 
	",\"price\":"+priceInput+
	",\"mSRP\":"+mSRPInput+ "}";
	var responseText = document.getElementById('productsOut');
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("POST", "http://localhost:8080/JamesIndividualProject/api/product/createProduct/");
    xhr.onload = () => {
        var returnJSON =JSON.parse(concatString);
        console.log(concatString);
    	responseText.innerHTML=beautifyProduct(returnJSON);
    }
    xhr.send(concatString);
}
function findProduct(variation)
{
	if(variation !== 0)
		{
		var responseText = document.getElementById('productsOut');
		var userInput = document.getElementById('productFindInput').defaultValue="1";
		let xhr = new XMLHttpRequest();
		xhr.withcredentials=true;
	    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAProduct/"+userInput);
	    xhr.onload = () => {
	        	var returnJSON=JSON.parse(xhr.response);
	        	responseText.innerHTML=beautifyProduct(returnJSON);
	        }
	    xhr.send();
		}
	else
		{
			var responseText = document.getElementById('productsOut');
			var userInput = document.getElementById('productFindInput').defaultValue="1";
			let xhr = new XMLHttpRequest();
			xhr.withcredentials=true;
		    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAProduct/"+userInput);
		    xhr.onload = () => {
		        	var returnJSON=JSON.parse(xhr.response);
		        	responseText.innerHTML=beautifyProduct(returnJSON);
		        }
		    xhr.send();
		}
	
}
function deleteProduct()
{
	var responseText = document.getElementById('productsOut');
	var userInput = document.getElementById('productFindInput').defaultValue="1";
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("DELETE", "http://localhost:8080/JamesIndividualProject/api/product/deleteProduct/"+userInput);
    xhr.onload = () => {
        	var returnJSON=JSON.parse(xhr.response);
        	responseText.innerHTML=beautifyProduct(returnJSON);
        }
    xhr.send();
}