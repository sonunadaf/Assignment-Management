<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>create assignment</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/header.css" />

</head>

<body>

	<%@include file="AdminHeader.jsp"%>
	<div class="container admin-section">
		<h5 align="center">Create Assignment</h5>
		<h3 align="center" style="color: green;'">${assignmentId}</h3>

		<form action="createAssignment" method="post"
			onsubmit="return createAssignmentValidation()">
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="courseName"><h5>Course</h5></label> <select
						name='courseName' class="form-control" id='courseName' required>
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
						name='topicName' class="form-control" id='topicName' required>
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
					<label for="description"><h5>Description</h5></label>
					<textarea rows="3" cols="40" class="form-control"
						name="description" id="description" required></textarea>
					<div name="desc" style="color: red"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="lastDate"><h5>Deadline</h5></label> <input type="Date"
						class="form-control" id="lastDate" name="lastDate" required>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="uploadType"><h5>Upload Type</h5></label> <select
						name='uploadType' class="form-control" id='uploadType' required>
						<option value=''>--select--</option>
						<option>Git</option>
						<option>Zip</option>
					</select>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-dark btn-lg btn-block"
						value="Create"></input>
				</div>
				<div class="col-md-2">
					<a class="btn btn-danger btn-lg btn-block"
						href="CreateAssignment.jsp" role="button">Cancel</a>
				</div>
			</div>
	</div>
	</form>
	</div>
	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/input.js"></script>
	<script src="js/inputvalidation.js"></script>
	<%@include file="Footer.jsp"%>
</body>

</html>