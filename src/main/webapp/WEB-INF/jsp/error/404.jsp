<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="oupsPage">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" href="/webapp/resources/css/escalade.css" />
		<title><c:out value="${title}" /></title>
			
	</head>
	<body>
	<spring:url value="/resources/images/sites.png" var="sitesImage"/>
    <img src="${sitesImage}"/>
		<table class="table table-striped">
			<tr>
				<th><h1>handle HTTP 404 Not Found error</h1></th>
			</tr>			
		</table>
	<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>	
	</body>
	</html>
</escalade:layout>