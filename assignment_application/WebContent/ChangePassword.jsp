<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/header.css" />
<link rel="stylesheet" href="assets/header-second-bar.css">
<link href='http://fonts.googleapis.com/css?family=Cookie'
	rel='stylesheet' type='text/css'>
<title>Update Password</title>

</head>
<body>
	<div class="container-fluid">
		<div class="row header-background">
			<div class="col-md-3">
				<div class="site-logo">
					<img src="img/logo.png" width="250px" height="100px">
				</div>
			</div>
			<div class="col-md-6 float-right"></div>
			<div class="col-md-2">
				<br></br>
				<h4 style="color: white; text-align: right">${admin.firstName}
					${admin.lastName}</h4>
			</div>
			<div class="col-md-1" style="color: white;">
				<br></br>
				<form action="logOut">
					<input type="submit" class="btn btn-danger float-left"
						value="Logout"></input>
				</form>
			</div>

		</div>
	</div>
	<div class="container  middle-section">
		<h5 align="center">Update Password</h5>
		<h6 align="center" style="color: red">${updatemsg}</h6>
		<form action="changePassword" method="post"
			onsubmit="return changePasswordValidation()">
			<div id="validate" style="color: red;"></div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="userName">User Name</label> <input type="text"
						class="form-control" id="userName" name="userName"
						value='${admin.emailId}' readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>

				<div class="col-md-5 mb-3">
					<label for="oldPassword">Old Password</label> <input
						type="password" class="form-control" id="oldPassword"
						name="oldPassword" placeholder="Old Passwod">
					<div id="oldPass" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="newPassword">New Password</label> <input
						type="password" class="form-control" id="newPassword"
						name="newPassword" placeholder="New Password">
					<div id="newPassValid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="confirmPassword">Confirm Password</label> <input
						type="password" class="form-control" id="confirmPassword"
						name="confirmPassword" placeholder="Confirm Password">
					<div id="conPassValid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-dark btn-lg btn-block"
						value="Update"></input>
				</div>
				<div class="col-md-2">
					<a class="btn btn-primary btn-lg btn-block" href="logOut"
						role="button">Cancel</a>
				</div>
			</div>
	</div>
	</form>
	</div>
	<%@include file="Footer.jsp"%>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/inputvalidation.js"></script>

</body>
</html>