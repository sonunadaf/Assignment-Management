<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/header.css" />

<title>Sign In</title>
</head>
<body>
	<%@include file="Header.jsp"%>
	<div class="container  middle-section">
		<h5 align="center">Admin Sign In</h5>
		<form action="memLogin" method="post">
			<div id="validate" style="color: red;">${message}</div>
			<div class="form-row">
				<div class="col-md-3"></div>

				<div class="col-md-5 mb-3">
					<label for="user">User Name</label> <input type="text"
						class="form-control" id="user" name="user"
						placeholder="User Name">
					<div id="emailvalid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="password">Password</label> <input type="password"
						class="form-control" id="password" name="password"
						placeholder="xxxxxxx">
					<div id="passvalid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-dark btn-lg btn-block"
						value="Sign In"></input>
				</div>
				<div class="col-md-2">
					<a class="btn btn-danger btn-lg btn-block" href="Index.jsp"
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