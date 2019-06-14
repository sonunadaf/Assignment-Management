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
<title>Search</title>

</head>
<body>
	<%@include file="AdminHeader.jsp"%>
	<div class="container  middle-section">
		<h5 align="center">Assign Assignment</h5>
		<form action="assignToAll" method="post">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-3 mb-3">
					<a style="color: green;">${msg}</a> <a id="textarea"
						style="color: red;">${err}</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6 mb-3">
					<label for="pin">Pin</label><input type="number"
						class="form-control" id="pin" name="pin" placeholder="enter pin"
						required> <a id="validate" style="color: red;"></a> <label
						for="assign">Assign</label>
					<textarea rows="4" cols="80" class="form-control" id="assign"
						name="assign" placeholder="enter coma saperated valid email id"
						required="S"></textarea>

				</div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-dark btn-lg btn-block"
						value="Assign"></input>
				</div>
				<div class="col-md-2">
					<a class="btn btn-danger btn-lg btn-block"
						href="CreateAssignment.jsp" role="button">Cancel</a>
				</div>
			</div>
		</form>
	</div>
	<%@include file="Footer.jsp"%>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/inputvalidation.js"></script>
	<script src="js/werservices.js"></script>

</body>
</html>