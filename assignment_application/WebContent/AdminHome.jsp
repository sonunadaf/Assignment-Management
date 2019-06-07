<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create assignment</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/header.css" />

<%@include file="AdminHeader.jsp"%>
</head>

<body>
	<div class="container  admin-section">
		<h5 align="center">Create Assignment</h5>
		<form action="createAssignment" method="post">
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="courseName"><h5>Course</h5></label> <select
						name='courseName' class="form-control" id='courseName'>
						<option value=''>--select--</option>
						<option>Servlet</option>
						<option>Spring</option>
						<option>Hibernate</option>
						<option>WebServices</option>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="topicName"><h5>Topic</h5></label> <select
						name='topicName' class="form-control" id='topicName'>
						<option value=''>--select--</option>
						<option>Session</option>
						<option>Methods</option>
						<option>Session Factory</option>
						<option>Rest Controller</option>
						<option>Service</option>
						<option>Transaction</option>
						<option>Entity</option>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="description">Description</label>
					<textarea rows="4" cols="40" class="form-control"
						name="description" id="description"></textarea>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="lastDate">Deadline</label> <input type="Date"
						class="form-control" id="lastDate" name="lastDate">
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="uploadType">Upload Type</label> <select
						name='uploadType' class="form-control" id='uploadType'>
						<option value=''>--select--</option>
						<option>Git</option>
						<option>Zip</option>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-primary btn-lg btn-block"
						value="Create"></input>
				</div>
				<div class="col-md-2">
					<a class="btn btn-primary btn-lg btn-block" href="AdminHome.jsp"
						role="button">Cancel</a>
				</div>
			</div>
	</div>
	</form>
	<%@include file="Footer.jsp"%>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/input.js"></script>
	</div>

</body>

</html>