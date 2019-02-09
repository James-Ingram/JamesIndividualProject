function getAllProducts()
{
	var responseText = document.getElementById('productsOut')
	let xhr = new XMLHttpRequest();
	xhr.withcredentials=true;
    xhr.open("GET", "http://localhost:8080/JamesIndividualProject/api/product/getAllProducts");
    xhr.onload = () => {
    	responseText.innerHTML=beautify(JSON.stringify(xhr.responseText))+'<br>';
    }
    xhr.send();
}

function beautify(input)
{
	return input
	.replace(/\\/g,"  ")
	.replace("\"[{","<div class=\"ouptut\">")
	.replace("}]\"")
	.replace(/\"/g,"")
	.replace("undefined", "0")
	.replace(/:/g,": " +'<pre>')
	.replace(/}/g,"</div>")
	.replace(/{/g,'<div class=\"ouptut\">')
	.replace(/\./g, " . ")
	.replace(/,/g,'</pre>');
}



function createProduct()
{
	
}