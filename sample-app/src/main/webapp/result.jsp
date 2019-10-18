
<%@ page import ="java.util.*" %>
<!DOCTYPE html>
<html>
<body>
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
