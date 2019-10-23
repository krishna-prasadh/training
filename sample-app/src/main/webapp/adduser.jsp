<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">


<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
	integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
	integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
	crossorigin="anonymous"></script>

<script src="/validations.js" type="text/javascript"></script>

<title>Insert title here</title>
</head>


<body>
	<center class="w-100">
		<form id="add_form" method="post" action="/app/adduser">
			<label>Email:</label> <input type="email" id="email" name="username"
				onfocusout="valiadteEmail()" onkeyup="removeValiadtion('email')"
				required>
			<p id="email_validation" class="validation">please provide a
				valid email</p>
			<br> <label>Password:</label> <input type="password"
				onfocusout=validatePassword() onkeyup="removeValiadtion('password')"
				id="password" name="password" required>
			<p id="password_validation" class="validation">Must contain at
				least one number and one uppercase or lowercase letter, and at least
				8 or more characters</p>
			<br> <input type="button" value="submit" onclick="form_submit()">
		</form>
	</center>

</body>
</html>
<style>
.validation {
	display: none;
	margin: 0;
	color: red;
}
}
</style>

