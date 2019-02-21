'use strict';
function getAllStock()
{
	let response = document.getElementById('stockOut');
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/stock/getAllStock");
    xhr.onload = () => {
    	let returnJSON =JSON.parse(xhr.response);
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
		val6==null || val6==""){
		return true;
	}
	else{
		return false;
	}
}

function createStock()
{
	let supplierInput = document.getElementById('stockSupplierInput').value;
	let warehouseInput = document.getElementById('stockWarehouseInput').value;
	let locationInput = document.getElementById('stockLocationInput').value;
	let amountInput = document.getElementById('stockAmountInput').value;
	let lastDateInput = document.getElementById('stockLastDateInput').value;
	let nextDateInput = document.getElementById('stockNextDateInput').value;
	
	let check = validateCreate(supplierInput, warehouseInput, locationInput, amountInput, lastDateInput,nextDateInput);
 	if (check)
        {
            alert("Please Fill All Required Fields");
            return false;
        }
	let concatString ="{\"supplier\":" +"\""+supplierInput+"\""+   
	",\"warehouse\":" +"\""+warehouseInput+"\""+ 
	",\"location\":" +"\""+locationInput+"\""+ 
	",\"amount\":"+amountInput+
	",\"lastDeliveryDate\":"+"\""+lastDateInput+"\""+ 
	",\"nextDeliveryDate\":"+"\""+nextDateInput+"\""+ "}";
	let responseText = document.getElementById('stockOut');
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("POST", "http://localhost:8080/JamesIndividualProject/api/stock/createStock/");
    xhr.onload = () => {
        let returnJSON =JSON.parse(concatString);
        console.log(concatString);
    	responseText.innerHTML=beautifyStock(returnJSON);
    }
    xhr.send(concatString);
}
function findStock()
{
	let responseText = document.getElementById('stockOut');
	let userInput = document.getElementById('stockFindInput').value;
	if(userInput == null|| userInput=="")
	{
		alert("Please Enter A StockId");
		return false;
	}
	
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/stock/getAStock/"+userInput);
    xhr.onload = () => {
        	let returnJSON=JSON.parse(xhr.response);
        	responseText.innerHTML=beautifyStock(returnJSON);
        }
    xhr.send();
}
function deleteStock()
{
	let responseText = document.getElementById('stockOut');
	let userInput = document.getElementById('stockDeleteInput').value;
	if(userInput==null||userInput=="")
	{
		alert("Please Fill In The Delete Field");
		return false;
	}
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("DELETE", "http://localhost:8080/JamesIndividualProject/api/stock/deleteStock/"+userInput);
    xhr.onload = () => {
        	responseText.innerHTML=xhr.response;
        }
    xhr.send();
}