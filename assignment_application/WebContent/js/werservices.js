function getEmailData() {
	var emailId = document.getElementById("emailId").value;
	var url = "http://localhost:8080/assignment_application/email/" + emailId
			+ "/";
	var http = new XMLHttpRequest();
	http.onreadystatechange = function() {

		if (http.readyState == 4 && http.status == 200) {
			console.log(http.responseText);
			var id = JSON.parse(http.responseText);
			if (id == true) {
				console.log('email already exist');
				document.getElementById("emailstatus").innerHTML = 'email id already exist';
				return false;
			}
			if (id == false) {
				document.getElementById("emailstatus").innerHTML = '';
			}
		}
	}
	http.open("GET", url, true);
	http.send();
}

function searchData() {
	console.log("onclick search invoked ");
	var pin = document.getElementById("search").value;
	if (pin.length == 0) {
		document.getElementById("validate").innerHTML = 'enter pin';
		return false;
	}
	// assignment

	var url = "http://localhost:8080/assignment_application/search/" + pin
			+ "/";
	var http = new XMLHttpRequest();
	http.onreadystatechange = function() {
		if (http.readyState == 4 && http.status == 200) {
			console.log(http.responseText);

			if (http.responseText != "") {
				var data = JSON.parse(http.responseText);
				var table = document.getElementsByTagName('table')[0];
				var newRow=table.insertRow(table.rows.length);
				var cell1=newRow.insertCell(0);
				var cell2=newRow.insertCell(1);
				var cell3=newRow.insertCell(2);
				var cell4=newRow.insertCell(3);
				var cell5=newRow.insertCell(4);
				var cell6=newRow.insertCell(5);
				var cell7=newRow.insertCell(6);
				cell1.innerHTML=data.assignmentId;
				cell2.innerHTML=data.courseName;
				cell3.innerHTML=data.topicName;
				cell4.innerHTML=data.description;
				cell5.innerHTML=data.lastDate;
				cell6.innerHTML=data.uploadType;
				cell7.innerHTML=data.solvedStudentCount;
				
			}else{
				document.getElementById("validate").innerHTML = 'enter a valid pin';
			}
		}
	}
	http.open("GET", url, true);
	http.send();

}