<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="register">
	<div class="row">
		<div class="col-md-12">
			<spring:url value="/resources/images/topos.png" htmlEscape="true"
				var="toposImage" />
			<img class="img-responsive" src="${toposImage}" />
		</div>
	</div>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/webapp/resources/css/escalade.css" />
<title><c:out value="${title}" /></title>
	</head>
	<body>
		<h2>
			<fmt:message key="welcome" />
			<span> <c:out value="${message}" /></span>			
		</h2>
		<aside>
			<form:form  method="POST" action="/register" modelAttribute = "userForm">
				<fieldset>
					<legend>User Name</legend>					
						<!--  <div class="form-group ${username.error ? 'has-error' : ''}"> -->
							<div class="form-group" >
							<form:label path="userName">User Name</form:label>
							<form:input path="userName" type="text" id="userName" />
							<form:errors path="userName" />
							</div>					
					<legend>Password</legend>					
						<!-- <div class="form-group ${password.error ? 'has-error' : ''}">  -->
							<div class="form-group" >
							<form:label path="password">Password</form:label>
							<form:input path="password" type="text" id="password" />
							<form:errors path="password" />
						</div>					
					<input type="submit" value="Submit" />
					<ul class="nav nav-pills flex-column">
						<li class="nav-item"><a class="nav-link active" href="@{/}">Cancel</a></li>
					</ul>
				</fieldset>
			</form:form>
		</aside>
	</body>
	</html>
</escalade:layout>