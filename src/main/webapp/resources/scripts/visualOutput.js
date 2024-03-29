"use strict";
function beautifyProduct(object)
{
	let outputString = "";
	if(object.length>0)
	{
	for(let i =0; i<object.length;i++)
		{
		outputString += '<div>'+
		"Product Id:   "+JSON.stringify(object[i].productId)+'<br>'+
  		"Product Name: "+JSON.stringify(object[i].productName)+'<br>'+
  		"Description:  "+JSON.stringify(object[i].description)+'<br>'+
  		"Product Line: "+JSON.stringify(object[i].productLine)+'<br>'+
  		"Price:        "+JSON.stringify(object[i].price)+'<br>'+
  		"MSRP:         "+JSON.stringify(object[i].mSRP)+'</div>';
		}
	return outputString;
	}
	else{
		outputString = '<div>'+
		"Product Id:   "+JSON.stringify(object.productId)+'<br>'+
  		"Product Name: "+JSON.stringify(object.productName)+'<br>'+
  		"Description:  "+JSON.stringify(object.description)+'<br>'+
  		"Product Line: "+JSON.stringify(object.productLine)+'<br>'+
  		"Price:        "+JSON.stringify(object.price)+'<br>'+
  		"MSRP:         "+JSON.stringify(object.mSRP)+'</div>';
  		return outputString;
	}
}
function beautifyStock(object)
{
	let outputString = "";
	if(object.length>0)
	{
	for(let i =0; i<object.length;i++)
		{
		outputString += '<div>'+
		"Stock Id:          "+JSON.stringify(object[i].stockId)+'<br>'+
  		"Supplier:          "+JSON.stringify(object[i].supplier)+'<br>'+
  		"Warehouse:         "+JSON.stringify(object[i].warehouse)+'<br>'+
  		"Location:          "+JSON.stringify(object[i].location)+'<br>'+
  		"Amount:            "+JSON.stringify(object[i].amount)+'<br>'+
  		"Last Delivery Date:"+JSON.stringify(object[i].lastDeliveryDate)+'<br>'+
  		"Next Delivery Date:"+JSON.stringify(object[i].nextDeliveryDate)+'</div>';
		}
	return outputString;
	}
	else{
		outputString += '<div>'+
		"Stock Id:          "+JSON.stringify(object.stockId)+'<br>'+
		"Supplier:          "+JSON.stringify(object.supplier)+'<br>'+
		"Warehouse:         "+JSON.stringify(object.warehouse)+'<br>'+
		"Location:          "+JSON.stringify(object.location)+'<br>'+
		"Amount:            "+JSON.stringify(object.amount)+'<br>'+
		"Last Delivery Date:"+JSON.stringify(object.lastDeliveryDate)+'<br>'+
		"Next Delivery Date:"+JSON.stringify(object.nextDeliveryDate)+'</div>';
	return outputString;
	}
}

function showOptions(tagName) {
	if (tagName === "findStock") {
		let stockSelect = document.getElementById('stockSelect');

		if (stockSelect.style.display === "block")
			stockSelect.style.display = "none";
		else {
			stockSelect.style.display = "block";
		}
	} else if (tagName === "findProduct") {
		let prodSelect = document.getElementById('productSelect');

		if (prodSelect.style.display === "block")
			prodSelect.style.display = "none";
		else {
			prodSelect.style.display = "block";
		}
	} else if (tagName === "deleteProduct") {
		let prodDel = document.getElementById('productDelete');

		if (prodDel.style.display === "block")
			prodDel.style.display = "none";
		else {
			prodDel.style.display = "block";
		}
	} else if (tagName === "deleteStock") {
		let stockDel = document.getElementById('stockDelete');

		if (stockDel.style.display === "block")
			stockDel.style.display = "none";
		else {
			stockDel.style.display = "block";
		}
	} else if (tagName === "updateProduct") {
		let prodUpdate = document.getElementById('productUpdate');

		if (prodUpdate.style.display === "block")
			prodUpdate.style.display = "none";
		else {
			prodUpdate.style.display = "block";
		}
	} else if (tagName === "updateStock") {
		let stockUpdate = document.getElementById('stockUpdate');

		if (stockUpdate.style.display === "block")
			stockUpdate.style.display = "none";
		else {
			stockUpdate.style.display = "block";
		}
	}else if (tagName === "createProduct") {
		let prodCreate = document.getElementById('productCreate');

		if (prodCreate.style.display === "block")
			prodCreate.style.display = "none";
		else {
			prodCreate.style.display = "block";
		}
	}else if (tagName === "createStock") {
		let stockUpdate = document.getElementById('stockCreate');

		if (stockUpdate.style.display === "block")
			stockUpdate.style.display = "none";
		else {
			stockUpdate.style.display = "block";
		}
	}
}
