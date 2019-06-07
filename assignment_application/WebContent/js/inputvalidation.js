function signInValidation() {
	var username = document.getElementById('userName').value;
	var userpassword = document.getElementById('password').value;
	console.log(username);
	console.log(userpassword);

	if (username.length == 0) {
		alert("enter user name");
		document.getElementById('emailvalid').innerHTML = 'enter user name';
		return false;
	} else {
		document.getElementById('emailvalid').innerHTML = '';
	}
	if (userpassword.length == 0) {
		alert("enter password");
		document.getElementById('passvalid').innerHTML = 'enter password';
		return false;
	} else {
		document.getElementById('passvalid').innerHTML = '';
	}

	var result = getMessage(username, userpassword);
	if (result == false) {
		// document.getElementById('validate').innerHTML = 'incorrect user name
		// or password';
	}

}
function getMessage(username, userpassword) {
	var url = "http://localhost:8080/assignment_application/userlogin/"
			+ username + "/";
	var result = false;
	var passresult = false;
	var http = new XMLHttpRequest();
	{
		http.onreadystatechange = function() {

			if (http.readyState == 4 && http.status == 200) {
				var admin = JSON.parse(http.responseText);
				console.log(admin);
				if (admin.user != null && admin.user == username) {
					console.log(admin.user);
					result = true;
				}
				if (admin.password != null && admin.password == userpassword) {
					console.log(admin.password);
					passresult = true;
				}

			}
		}
		http.open('GET', url, false);
		http.send();
	}
	if (result == true && passresult == true) {
		return true;

	} else {
		return false;
	}
}

function changePasswordValidation() {
	var oldPass = document.getElementById('oldPassword').value;
	if (oldPass.length == 0) {
		document.getElementById('oldPass').innerHTML = 'Enter Old Password';
		return false;
	} else if (oldPass.length < 8) {
		document.getElementById('oldPass').innerHTML = 'Password Length must be 8 or above';
		return false;
	} else {
		document.getElementById('oldPass').innerHTML = '';
	}
	var newPassword = document.getElementById('newPassword').value;
	var oldPass = document.getElementById('confirmPassword').value;
	if (newPassword.length == 0) {
		document.getElementById('newPassValid').innerHTML = 'Enter New Password';
		return false;
	} else if (newPassword.length < 8) {
		document.getElementById('newPassValid').innerHTML = 'Password Length must be 8 or above';
		return false;
	} else {
		document.getElementById('newPassValid').innerHTML = '';
	}

	if (oldPass.length == 0) {
		document.getElementById('conPassValid').innerHTML = 'Enter New Password';
		return false;
	} else if (oldPass.length < 8) {
		document.getElementById('conPassValid').innerHTML = 'Password Length must be 8 or above';
		return false;
	} else {
		document.getElementById('conPassValid').innerHTML = '';
	}
	if (oldPass != conPassValid) {
		document.getElementById('conPassValid').innerHTML = 'Password Not matched';
		return false;

	}

}
