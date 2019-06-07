<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/header.css" />
<style type="text/css">
.error {
	color: red;
}
</style>
<title>Sign Up</title>
</head>
<body onload="getCountryName()">
	<%@include file="Header.jsp"%>
	<div class="container  middle-section">
		<h5 align="center">Admin Sign Up</h5>
		<form action="adminSignUp" method="POST" modelAttribute="signup"
			onsubmit="return getEmailData()">

			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-3">
					<h5 style="color: red">${message}</h5>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>

				<div class="col-md-3 mb-3">
					<label for="firstName">First name</label> <input type="text"
						class="form-control" id="firstName" path="fname" name="firstName"
						placeholder="First name" required>
					<errors path="fname" cssClass="error" />
				</div>
				<div class="col-md-3 mb-3">
					<label for="lastName">Last name</label> <input type="text"
						class="form-control" id="lastName" name="lastName"
						placeholder="Last name">
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<label for="emailId">Email</label> <input type="email"
						class="form-control" id="emailId" name="emailId"
						onblur="getEmailData()" placeholder="XXXX@mail.com" required>
					<div id="emailstatus" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<label for="countryName">Country Name</label> <select
						class="form-control" id="countryName" name="countryName"
						onchange="getCountryCode()">
						<option value=null>--country--</option>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-1">
					<label for="countryCode">Code</label> <input type="input"
						class="form-control" id="countryCode" name="countryCode" readonly>
				</div>

				<div class="col-md-5">
					<label for="phoneNo">Phone Number</label> <input type="text"
						class="form-control" id="phoneNo" name="phoneNo"
						placeholder="98754XXXXX" min="10" required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-2">&nbsp</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-3">
					<input type="submit" class="btn btn-primary btn-lg btn-block"
						value="Sign Up"></input>
				</div>
				<div class="col-md-3">
					<a class="btn btn-primary btn-lg btn-block" href="Index.jsp"
						role="button">Cancel</a>
				</div>
			</div>
	</div>
	</form>
	</div>
	<%@include file="Footer.jsp"%>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/input.js"></script>
	<script src="js/countrycode.js"></script>
	<script src="js/werservices.js"></script>
	<script src="js/inputValidation.js"></script>
</body>
</html>