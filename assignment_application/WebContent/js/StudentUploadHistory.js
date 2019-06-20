function getUploadHistory() {

	var url = "http://localhost:8080/assignment_application/getUploadedList/";
	var http = new XMLHttpRequest();
	http.onreadystatechange = function() {

		if (http.readyState == 4 && http.status == 200) {
			console.log(http.responseText);
			var data = JSON.parse(http.responseText);
			console.log(http.responseText);
			insertIntoTable(data);
		}
	}
	http.open("GET", url, true);
	http.send();
}

function insertIntoTable(data) {
	var table = document.getElementsByTagName('table')[0];
	var newRow = table.insertRow(table.rows.length);

	for (var i = 0; i < data.length; i++) {
		var newRow = table.insertRow(table.rows.length);
		var cell1 = newRow.insertCell(0);
		var cell2 = newRow.insertCell(1);
		var cell3 = newRow.insertCell(2);
		var cell4 = newRow.insertCell(3);
		var cell5 = newRow.insertCell(4);
		cell1.innerHTML = data[i].pin;
		cell2.innerHTML = data[i].emailId;
		cell3.innerHTML = data[i].date;
		cell4.innerHTML = data[i].gitUrl;
		// cell5.innerHTML = data[i].uploadFilePath;

	}
}