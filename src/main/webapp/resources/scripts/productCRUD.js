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

function validateCreate(val1,val2,val3,val4,val5)
{
	if (val1==null || val1=="" || 
		val2==null || val2=="" ||
		val3==null || val3=="" ||
		val4==null || val4=="" || 
		val5==null || val5==""){
		return true;
	}
	else{
		return false;
	}
}

function createProduct()
{
	var nameInput = document.getElementById('productNameInput').value;
	var descInput = document.getElementById('productDescInput').value;
	var lineInput = document.getElementById('productLineInput').value;
	var priceInput = document.getElementById('produtPriceInput').value;
	var mSRPInput = document.getElementById('productMSRPInput').value;
	
	let check = validateCreate(nameInput, descInput, lineInput, priceInput, mSRPInput);
 	if (check)
        {
            alert("Please Fill All Required Fields");
            return false;
        }
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
		var userInput = document.getElementById('productFindInput').value;
		var responseText = document.getElementById('productsOut');
		if(userInput== null|| userInput=="")
			{
				alert("Please Enter A ProductId");
				return false;
			}
		let xhr = new XMLHttpRequest();
		xhr.withcredentials=true;
	    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAProduct/"+userInput);
	    xhr.onload = () => {
	        	var returnJSON=JSON.parse(xhr.response);
	        	responseText.innerHTML=beautifyProduct(returnJSON);
	        }
	    xhr.send();
}
function deleteProduct()
{
	var responseText = document.getElementById('productsOut');
	var userInput = document.getElementById('productDeleteInput').value;
	if(userInput==null||userInput=="")
		{
			alert("Please Fill In The Delete Field");
			return false;
		}
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("DELETE", "http://localhost:8080/JamesIndividualProject/api/product/deleteProduct/"+userInput);
    xhr.onload = () => {
        	responseText.innerHTML=xhr.response;
        }
    xhr.send();
}