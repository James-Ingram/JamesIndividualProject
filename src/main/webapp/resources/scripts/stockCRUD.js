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

function createStock()
{
	var responseText = document.getElementById('stockOut');
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/stock/createStock");
    xhr.onload = () => {
        var returnJSON =JSON.parse(xhr.response);
    	responseText.innerHTML=beautifyStock(returnJSON);
    }
    xhr.send();
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