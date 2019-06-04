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