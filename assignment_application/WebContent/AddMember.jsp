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
<script type="text/javascript">
	function getAll() {
		var jsonListOfMember = ${jsonListOfMember};
		var memberColumn= document.getElementById("memberList");
		var i;
		for (i = 0; i < jsonListOfMember.length; i++) {
			memberColumn.options.add(new Option(jsonListOfMember[i].email));
		}

	}
</script>
<title>Add Member</title>

</head>
<body onload="getAll()">
	<div class="container-fluid">
		<div class="row header-background">
			<div class="col-md-3">
				<div class="site-logo">
					<img src="img/logo.png" width="250px" height="100px">
				</div>
			</div>
			<div class="col-md-5 float-right"></div>
			<div class="col-md-3">
				<br></br>
				<h4 style="color: white; text-align: right">${adminFromDb.firstName}
					${adminFromDb.lastName}</h4>
			</div>
			<div class="col-md-1" style="color: white;">
				<br></br>
				<form action="logOut">
					<input type="submit" class="btn btn-danger float-left"
						value="Logout"></input>
				</form>
			</div>

		</div>
		<div class="container  middle-section">
			<h5 align="center">Add Member</h5>
			<form action="addMember" method="get">
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-3 mb-3">
						<a style="color: green;">${msg}</a> <a style="color: red;">${err}</a>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4"></div>
					<div class="col-md-4 mb-3">
						<label for="newMember">Member Email</label><input type="email"
							class="form-control" id="newMember" name="newMember"
							placeholder="Enter Member Email" required> <a
							id="validate" style="color: red;"></a>
					</div>
					<div class="col-md-3 mb-3">
						<label for="memberList">Exist Member List</label>
						<select id="memberList" class="form-control">
						<option value=''>Member List</option>
						</select>
					</div>
				</div>
				<div class="row">
					<div class="col-md-5"></div>
					<div class="col-md-2">
						<input type="submit" class="btn btn-dark btn-lg btn-block"
							value="Add Member"></input>
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