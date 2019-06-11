var searchList;
function getAllAssignment() {
	console.log("invoked getAllAssignment");

	var url = "http://localhost:8080/assignment_application/searchAll";
	var http = new XMLHttpRequest();
	console.log("created request ");
	http.onreadystatechange = function() {
		if (http.readyState == 4) {
			if (http.status == 200) {
				console.log("invoked status ");
				console.log(http.responseText);
				searchList = JSON.parse(http.responseText);

			}
		}
	}
	http.open("GET", url, true);
	http.send();

}

function insertData() {

	// alert("Helo world ");
	var table = document.getElementsByTagName('table')[0];
	console.log("access table : " + table);
	var newRow = table.insertRow(table.rows.length);

	// cell1.innerHTML='A';
	for (var i = 0; i < searchList.length; i++) {
		var newRow = table.insertRow(table.rows.length);
		var cell1 = newRow.insertCell(0);
		var cell2 = newRow.insertCell(1);
		var cell3 = newRow.insertCell(2);
		var cell4 = newRow.insertCell(3);
		var cell5 = newRow.insertCell(4);
		var cell6 = newRow.insertCell(5);
		var cell7 = newRow.insertCell(6);
		cell1.innerHTML = searchList[i].assignmentId;
		cell2.innerHTML = searchList[i].courseName;
		cell3.innerHTML = searchList[i].topicName;
		cell4.innerHTML = searchList[i].description;
		cell5.innerHTML = searchList[i].lastDate;
		cell6.innerHTML = searchList[i].uploadType;
		cell7.innerHTML = searchList[i].solvedStudentCount;

	}

}