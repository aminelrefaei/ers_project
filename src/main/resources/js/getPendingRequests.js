windon.onload = newPendingRequest();

function newPendingRequest() {
	var xhttp = new XMLHttpRequest;
	
	xhhtp.onReadyStateChange = function () {
		
		// if we're ready to send a response and trhe request is good
		if (xhttp.readyState == 4 && xhht.status == 200) {
			var ajaxObject = JSON.parse(xhht.responseText);
			
			var table = "<table class='table table-bordered'> + 
					'<thead>' +
			'<tr>' +
				'<th>Ticket ID</th>' +
				'<th>Employee ID</th>' +
				'<th>Total</th>' +
				'<th>Description</th>' +
				'<th>Status</th>'+
				'<th>Resolved By</th>' +
			'</tr>' +
		'</thead>' +

		'<tbody>' 
			for (ticket in ajaxObject) {
				table += '<tr>' +
				'<td>' +ajaxObject[ticket].ticketId +'</td>' +
				'<td>' +ajaxObject[ticket].employeeId +'</td>' +
				'<td>' +ajaxObject[ticket].total +'</td>' +
				'<td>' +ajaxObject[ticket].description +'</td>' +
				'<td>' +ajaxObject[ticket].status +'</td>' +
				'<td>' +ajaxObject[ticket].resolvedBy +'</td>' +
				
			'</tr>' +
			}
	
			
		table += '</tbody>' +
	'</table>'
			
		document.getElementById("tableDiv").innerHTML=table;	
		}
		xhttp.open('post', 'http://localhost:8080/ers_project/newPendingRequest.ajax',true);
		
		xhttp.send();
		
	}
}