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
	} else {
		document.getElementById('oldPass').innerHTML = '';
	}
	var newPassword = document.getElementById('newPassword').value;
	var oldPass = document.getElementById('confirmPassword').value;
	if (newPassword.length == 0) {
		document.getElementById('newPassValid').innerHTML = 'Enter New Password';
		return false;
	}
	var up = 0;
	var sm = 0;
	var special = 0;
	var num = 0;
	var i = 0;

	for (i; i < newPassword.length; i++) {

		if (newPassword.charCodeAt(i) >= 65 && newPassword.charCodeAt(i) <= 90) {
			up++;
		} else if (newPassword.charCodeAt(i) >= 97
				&& newPassword.charCodeAt(i) <= 122) {
			sm++;
		} else if (newPassword.charCodeAt(i) >= 48
				&& newPassword.charCodeAt(i) <= 57) {
			num++;
		} else if (newPassword.charCodeAt(i) >= 32
				&& newPassword.charCodeAt(i) <= 47
				|| newPassword.charCodeAt(i) >= 58
				&& newPassword.charCodeAt(i) <= 64) {
			special++;
		}

	}
	if (up == 0) {
		document.getElementById('newPassValid').innerHTML = 'Enter atleast one upper case character';
		return false;
	}
	if (sm == 0) {
		document.getElementById('newPassValid').innerHTML = 'Enter atleast one small case character';
		return false;
	}
	if (num == 0) {
		document.getElementById('newPassValid').innerHTML = 'Enter atleast one num';
		return false;
	}
	if (special == 0) {
		document.getElementById('newPassValid').innerHTML = 'Enter atleast one Special character';
		return false;
	}
	if (newPassword.length < 8) {
		document.getElementById('newPassValid').innerHTML = 'Password Length must be 8 or above';
		return false;
	} else {
		document.getElementById('newPassValid').innerHTML = '';
	}

	var comp = newPassword.localeCompare(oldPass);
	if (oldPass.length == 0) {
		document.getElementById('conPassValid').innerHTML = 'Enter Confirm Password';
		return false;
	} else if (comp != 0) {
		document.getElementById('conPassValid').innerHTML = 'Password Not matched';
		console.log("password not matched");
		return false;
	} else {
		document.getElementById('conPassValid').innerHTML = '';
	}

	console.log("upper case is " + up);
	console.log("small case is " + sm);
	console.log("special case is " + special);
	console.log("num case is " + num);

}

function createAssignmentValidation() {
	var desc = document.getElementById('description').value;
	if (desc.length == 0) {
		document.getElementById('desc').innerHTML = 'Enter Description';
		return false;
	} else if (desc.length <= 10) {
		document.getElementById('desc').innerHTML = 'Enter atleast 10 char';
		return false;
	}
}

function searchValidation() {

	var search = document.getElementById('search').value;
	if (search.length == 0) {
		document.getElementById('validate').innerHTML = 'Enter pin';
		return false;
	}

}
