<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="403Page">
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/webapp/resources/css/escalade.css" />
<link rel="stylesheet" href="/resources/css/escalade.css" />
<title>Access Denied</title>
	</head>
	<body>
		<h2>user Information</h2>
		<table class="table table-striped">
			<tr>
				<td><b><c:out value="${ message }" /></b></td>
			</tr>

		</table>
		<div>
			<c:out value="${ userInfo }"></c:out>
		</div>
	</body>
	</html>
</escalade:layout>

