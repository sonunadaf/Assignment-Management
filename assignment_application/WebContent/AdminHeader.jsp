<!DOCTYPE html>
<html>

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Home</title>

<link rel="stylesheet" href="assets/header-second-bar.css">
<link href='http://fonts.googleapis.com/css?family=Cookie'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">

</head>

<body>

	<header class="header-two-bars">

		<div class="header-first-bar">

			<div class="header-limiter">
				<img src="assets/logo.png" class="rounded float-left" width="250px"
					height="100px"></img>

				<nav>
					<a href="#" class="selected">Create Assignment</a> <a href="#"
						class="selected">Assign</a> <a href="#" class="selected">Search</a>
					<a href="#" class="selected">Settings</a>
				</nav>
				<a href="SignIn.jsp" class="logout-button">Logout</a> <a href="#"
					class="logout-button">${admin.firstName} ${admin.lastName}</a>
			</div>

		</div>
	</header>
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

</body>

</html>
