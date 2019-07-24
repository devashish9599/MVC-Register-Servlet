<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form  method="POST" action="<%=getServletContext().getContextPath()%>/SignUpController">
			<label>User Name</label><input type="text" name="username">
			<label>Password</label><input type="text" name="password">
			<input type="submit" name="" value="Click Me">
		</form>
<% List errorMsg = (List) request.getAttribute("ErrorMessage"); %>

<%
			
			if (errorMsg != null) {
		%>
				<span style="color: red;">  <%=errorMsg.toString() %> </span>
		<%
			}
		%>
		
			
</body>
</html>