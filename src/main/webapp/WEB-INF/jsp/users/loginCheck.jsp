<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="users">
	<!DOCTYPE html>
	<html lang="en">
<head>
<meta charset="utf-8">
<title>Log in with your account</title>
</head>
<body>
	<%
		String username = request.getParameter("username");
			String password = request.getParameter("password");

			if (username.equals("admin") && (password.equals("admin"))) {
				response.sendRedirect("index1.jsp");

			} else {
				response.sendRedirect("index2.jsp");
			}
	%>

</body>
	</html>
</escalade:layout>