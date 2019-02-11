function beautifyProduct(object)
{
	let outputString = "";
	for(var i =0; i<object.length;i++)
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
function beautifyStock(object)
{
	let outputString = "";
	for(var i =0; i<object.length;i++)
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

function showOptions(tagName) {
	if(tagName.equals("findStock"))
		{
			document.getElementById('welcomeDiv').style.display = "block";
		}
	else if(tagName.equals("findProduct"))
		{
			document.getElementbyId()
		}
	}

