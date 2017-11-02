<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<%if (request.getAttribute("errormsg")!=null){ %>
<script>
	alert("${errormsg}");
</script>
<%} %>
<div class="panel panel-default" style="width:20%;margin:auto;">
	<div class="panel-heading" ><h4><strong>Login Here</strong></h4></div>
	<div class="panel-body">
		<form method="post" action="login">
		<input type="text" class="form-control" name="username" placeholder="Username..."><br>
		<input type="password" class="form-control" name="password" placeholder="Password..."><br>
		<button type="submit" class="btn btn-success">Login</button>
		</form>
	</div>
</div>
</body>
</html>