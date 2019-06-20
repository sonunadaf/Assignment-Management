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
<title>Update Details</title>

</head>
<body>
	<%@include file="AdminHeader.jsp"%>
	<div class="container  middle-section">
		<h5 align="center">Change Settings</h5>
		<form action="adminSettings" method="post"
			onsubmit="return updateInformation()">
			<div class="form-row">
				<div class="col-md-3" id="updateMessage">${message}</div>

				<div class="col-md-5 mb-3">
					<label for="firstName">First Name</label> <input type="text"
						class="form-control" id="firstName" name="firstName"
						placeholder="First Name" value='${admin.firstName}'>
					<div id="fValid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>

				<div class="col-md-5 mb-3">
					<label for="lastName">Last Name</label> <input type="text"
						class="form-control" id="lastName" name="lastName"
						value='${admin.lastName}' placeholder="Last Name">
					<div id="lValid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="email">Email</label> <input type="text"
						class="form-control" id="email" name="email"
						value='${admin.emailId}' readonly>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>

				<div class="col-md-5 mb-3">
					<label for="phoneNUmber">Phone Number</label> <input type="text"
						class="form-control" id="phoneNUmber" name="phoneNUmber"
						value='${admin.contactNumber}' placeholder="96385XXXXX">
					<div id="pValid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-dark btn-lg btn-block"
						value="Change"></input>
				</div>
				<div class="col-md-2">
					<a class="btn btn-danger btn-lg btn-block" href="createAssignment"
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