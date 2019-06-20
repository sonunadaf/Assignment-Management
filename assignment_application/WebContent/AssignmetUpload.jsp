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
<title>Completed</title>

</head>
<body onload="getUploadHistory()">
	<%@include file="AdminHeader.jsp"%>
	<div class="container  middle-section">
		<h5 align="center">Student Assignment Solved History</h5>
		<form name="f1">
			<table class="table table-striped" name="t1">
				<tr name="r1">
					<th name="h1">PIN</th>
					<th name="h2">EMAIL</th>
					<th name="h3">UPLOAD DATE</th>
					<th name="h4">GIT URL</th>
					<th name="h5">UPLOAD FILE</th>
				</tr>
			</table>
		</form>
	</div>
	<%@include file="Footer.jsp"%>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/inputvalidation.js"></script>
	<script src="js/werservices.js"></script>
	<script src="js/StudentUploadHistory.js"></script>


</body>
</html>