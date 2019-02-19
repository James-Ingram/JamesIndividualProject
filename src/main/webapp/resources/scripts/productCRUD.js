'use strict';
function getAllProducts()
{
	let response = document.getElementById('productsOut');
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAllProducts");
    xhr.onload = () => {
    	let returnJSON =JSON.parse(xhr.response);
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
	let nameInput = document.getElementById('productNameInput').value;
	let descInput = document.getElementById('productDescInput').value;
	let lineInput = document.getElementById('productLineInput').value;
	let priceInput = document.getElementById('produtPriceInput').value;
	let mSRPInput = document.getElementById('productMSRPInput').value;
	
	let check = validateCreate(nameInput, descInput, lineInput, priceInput, mSRPInput);
 	if (check)
        {
            alert("Please Fill All Required Fields");
            return false;
        }
	let concatString ="{\"productName\":" +"\""+nameInput+"\""+   
	",\"description\":" +"\""+descInput+"\""+ 
	",\"productLine\":" +"\""+lineInput+"\""+ 
	",\"price\":"+priceInput+
	",\"mSRP\":"+mSRPInput+ "}";
	let responseText = document.getElementById('productsOut');
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("POST", "http://localhost:8080/JamesIndividualProject/api/product/createProduct/");
    xhr.onload = () => {
        let returnJSON =JSON.parse(concatString);
        console.log(concatString);
    	responseText.innerHTML=beautifyProduct(returnJSON);
    }
    xhr.send(concatString);
}
function findProduct(letiation)
{
		let userInput = document.getElementById('productFindInput').value;
		let responseText = document.getElementById('productsOut');
		if(userInput== null|| userInput=="")
			{
				alert("Please Enter A ProductId");
				return false;
			}
		let xhr = new XMLHttpRequest();
		xhr.withcredentials=true;
	    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAProduct/"+userInput);
	    xhr.onload = () => {
	        	let returnJSON=JSON.parse(xhr.response);
	        	responseText.innerHTML=beautifyProduct(returnJSON);
	        }
	    xhr.send();
}
function deleteProduct()
{
	let responseText = document.getElementById('productsOut');
	let userInput = document.getElementById('productDeleteInput').value;
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