
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
<form action="/login" method="post">
	<input type="hidden" name="logout">
	<input type="submit" value="logout">
	</form>
<center>
<h1>
    We have
</h1>
<%
List<String> result= (List<String>) request.getAttribute("type");
 Iterator<String> it = result.iterator(); 
 while(it.hasNext()){
out.println(it.next()+"<br>");
} 
%>
</body>
</html>
