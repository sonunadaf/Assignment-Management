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
		<h5 align="center">Search Assignment</h5>
		<form action="assignToAll" method="post">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4 mb-3">
					<a style="color: green;">${msg}</a><br></br> <label for="pin">Pin</label><input
						type="text" class="form-control" id="pin" name="pin"
						placeholder="enter pin"> <a id="validate"
						style="color: red;"></a> <label for="assign">Assign</label>
					<textarea rows="3" cols="40" class="form-control" id="assign"
						name="assign" placeholder="enter coma saperated valid email id"></textarea>
					<a id="textarea" style="color: red;">${err}</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-success btn-lg btn-block"
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