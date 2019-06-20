<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Header</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/header.css" />
<link rel="stylesheet" href="assets/header-second-bar.css">
<style>
.margin {
	width: 150px;
	margin-right: 3px;
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row header-background">
			<div class="col-md-3">
				<div class="site-logo">
					<img src="img/logo.png" width="250px" height="100px">
				</div>
			</div>
			<div class="col-md-5 float-right">
				<br></br> <a href="createAssignment" class="btn btn-success">Create
					Assignment</a> <a href="assignToAll" class="btn btn-success">Assign</a>
				<a href="serarchData" class="btn btn-success">Search</a> <a
					href="adminSettings" class="btn btn-success">Settings</a>

			</div>
			<div class="col-md-3">
				<a class=" float-right" style="color: white;">Last Sign In :
					${admin.lastLogin}</a><br></br>
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
</body>
</html>