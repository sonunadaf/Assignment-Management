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
		<h5 align="center">Upload Assignment</h5>
		<form action="uploadAssignment">
			<div class="form-row">
				<div class="col-md-3"></div>

				<div class="col-md-5 mb-3">
					<label for="emailId">Email</label> <input type="email"
						class="form-control" id="emailId" name="emailId"
						placeholder="xxxxx@gmail.com" required="required">
					<div id="emailvalid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="pin">Assignment Pin</label> <input type="text"
						class="form-control" id="pin" name="pin" placeholder="xxxxxx" required="required">
					<div id="pinValid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="uri">URI</label> <input type="url" class="form-control"
						id="uri" name="uri" placeholder="uri">
					<div id="uriValid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-5"></div>
				<div class="col-md-3 mb-3">OR</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-5 mb-3">
					<label for="file">File</label> <input type="file"
						class="form-control" id="file" name="file"
						placeholder="upload zip file only">
					<div id="fileValid" style="color: red;"></div>
				</div>
			</div>
			<div class="form-row">
				<div class="col-md-3"></div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-dark btn-lg btn-block"
						value="Upload"></input>
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