<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="red">
<center>
	<h2> Error!</h2>
  <%= session.getAttribute("message")  
  %>
</center>
  
  
</body>
</html>