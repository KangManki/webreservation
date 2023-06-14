 document.addEventListener('DOMContentLoaded', (evt) =>	{
	var displayId = getDisplayId();
	
	getDisplayDetail(displayId);
});

function copyFunction(displayId)	{
	let oReq = new XMLHttpRequest();
	let params = "/api/products/" + displayId;
	
	if (oReq.readyState === XMLHttpRequest.DONE && oReq.status === 200) {
		let detailInfo = JSON.parse(oReq.responseText);
	}	
	
	oReq.open("GET", params);
	oReq.send();
}


function getDisplayDetail(displayId)	{
	let params = "./api/products/" + displayId;
	
	let oReq = new XMLHttpRequest();
	oReq.addEventListener("load", function()	{
		let detailInfo = JSON.parse(this.responseText);
		
		
	});
	
	oReq.open("GET", params);
	oReq.send();
}

function getDisplayId()	{
	return extractPathVariable.getParameter("id");
}
