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
<body onload="getAllAssignment()">
	<%@include file="AdminHeader.jsp"%>
	<div class="container  middle-section">
		<h5 align="center">Search Assignment</h5>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 mb-3">
				<a id="validate" style="color: red; font-size: 25px;"></a> <label
					for="search"></label><input type="number" class="form-control"
					id="search" name="search">
			</div>
			<div class="col-md-2 mb-3"></div>
			<div class="col-md-2">
				<input type="button"
					class="btn btn-info float-right btn-lg btn-block" value="View All"
					onclick="insertData()"></input> <a href="AssignmetUpload.jsp"
					class="btn btn-info float-right btn-lg btn-block" value="Upload">Solved</a>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-2">
				<input type="button" class="btn btn-info btn-lg btn-block"
					value="Search" onclick="searchData()"></input>

			</div>
			<div class="col-md-2">
				<a class="btn btn-info btn-lg btn-block" href="CreateAssignment.jsp"
					role="button">Cancel</a>
			</div>
		</div>
		<br></br>
		<div class="row"></div>

		<form name="f1">
			<table class="table table-striped" name="t1">
				<tr name="r1">
					<th name="h1">ID</th>
					<th name="h2">COURSE NAME</th>
					<th name="h3">TOPIC NAME</th>
					<th name="h4">DESCRIPTION</th>
					<th name="h5">ASSIGNED DATE</th>
					<th name="h6">LAST DATE</th>
					<th name="h7">UPLOAD TYPE</th>
				</tr>
			</table>
		</form>
	</div>
	</div>
	<%@include file="Footer.jsp"%>

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/inputvalidation.js"></script>
	<script src="js/werservices.js"></script>
	<script src="js/getAllAssignment.js"></script>
</body>
</html>