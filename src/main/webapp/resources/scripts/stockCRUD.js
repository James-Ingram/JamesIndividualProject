function getAllStock()
{
	var responseText = document.getElementById('stockOut')
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/stock/getAllStock");
    xhr.onload = () => {
        var returnJSON =JSON.parse(xhr.response);
    	responseText.innerHTML=beautifyStock(returnJSON);
    }
    xhr.send();
}