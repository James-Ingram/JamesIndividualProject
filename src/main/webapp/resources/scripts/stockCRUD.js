"use strict";
function getAllStock()
{
	var response = document.getElementById('stockOut');
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/stock/getAllStock");
    xhr.onload = () => {
    	var returnJSON =JSON.parse(xhr.response);
    	response.innerHTML = beautifyStock(returnJSON);
    }
    xhr.send();
} 

function validateCreate(val1,val2,val3,val4,val5,val6)
{
	if (val1==null || val1=="" || 
		val2==null || val2=="" ||
		val3==null || val3=="" ||
		val4==null || val4=="" || 
		val5==null || val5=="" ||
		val6==null || val5==""){
		return true;
	}
	else{
		return false;
	}
}

function createStock()
{
	var supplierInput = document.getElementById('stockSupplierInput').value;
	var warehouseInput = document.getElementById('stockWarehouseInput').value;
	var locationInput = document.getElementById('stockLocationInput').value;
	var amountInput = document.getElementById('stockAmountInput').value;
	var lastDateInput = document.getElementById('stockLastDateInput').value;
	var nextDateInput = document.getElementById('stockNextDateInput').value;
	
	let check = validateCreate(supplierInput, warehouseInput, locationInput, amountInput, lastDateInput,nextDateInput);
 	if (check)
        {
            alert("Please Fill All Required Fields");
            return false;
        }
	var concatString ="{\"supplier\":" +"\""+supplierInput+"\""+   
	",\"warehouse\":" +"\""+warehouseInput+"\""+ 
	",\"location\":" +"\""+locationInput+"\""+ 
	",\"amount\":"+amountInput+
	",\"lastDeliveryDate\":"+"\""+lastDateInput+"\""+ 
	",\"nextDeliveryDate\":"+"\""+nextDateInput+"\""+ "}";
	var responseText = document.getElementById('stockOut');
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("POST", "http://localhost:8080/JamesIndividualProject/api/stock/createStock/");
    xhr.onload = () => {
        var returnJSON =JSON.parse(concatString);
        console.log(concatString);
    	responseText.innerHTML=beautifyStock(returnJSON);
    }
    xhr.send(concatString);
}
function findStock()
{
	var responseText = document.getElementById('stockOut');
	var userInput = document.getElementById('stockFindInput').defaultValue="1";
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/stock/getAStock/"+userInput);
    xhr.onload = () => {
        	var returnJSON=JSON.parse(xhr.response);
        	responseText.innerHTML=beautifyStock(returnJSON);
        }
    xhr.send();
}
function deleteStock()
{
	var responseText = document.getElementById('stockOut');
	var userInput = document.getElementById('stockFindInput').defaultValue="1";
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("DELETE", "http://localhost:8080/JamesIndividualProject/api/stock/deleteStock/"+userInput);
    xhr.onload = () => {
        	var returnJSON=JSON.parse(xhr.response);
        	responseText.innerHTML=beautifyStock(returnJSON);
        }
    xhr.send();
}