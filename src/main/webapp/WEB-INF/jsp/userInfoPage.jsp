<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="userInfoPage">
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/webapp/resources/css/escalade.css" />
<link rel="stylesheet" href="/resources/css/escalade.css" />
<title><c:out value="${title}" /></title>
	</head>
	<body>
		<h2>User Info Page</h2>
		<h3>
			<c:out value="${userPrincipal.name}"></c:out>
		</h3>
		<b>This is protected page!</b>
		<br />
		<br />
		<div>
			<!-- 
			<c:set var="test" value="Mateo21" scope="page" />  -->
			<c:if test="${userInfo != null }">
				<p>
					<c:out value="${ userInfo }"></c:out>
				</p>
			</c:if>
		</div>
	</html>
</escalade:layout>


