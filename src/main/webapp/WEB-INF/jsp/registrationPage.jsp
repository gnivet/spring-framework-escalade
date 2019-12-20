<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="app_user">
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
			<form name="${appUserForm}" method="post" action="/register">
				<fieldset>
					<legend>User Name</legend>
					<spring:bind path="username">
						<div class="form-group ${username.error ? 'has-error' : ''}">
							<label>User Name</label>
							<form:input path="username" type="text" id="name" />
							<form:errors path="username" />
						</div>
					</spring:bind>
					<legend>Password</legend>
					<spring:bind path="password">
						<div class="form-group ${password.error ? 'has-error' : ''}">
							<form:input path="password" type="text" id="password" />
							<form:errors path="password" />
						</div>
					</spring:bind>
					<input type="submit" value="Submit" />
					<ul class="nav nav-pills flex-column">
						<li class="nav-item"><a class="nav-link active" href="@{/}">Cancel</a></li>
					</ul>
				</fieldset>
			</form>
		</aside>
	</body>
	</html>
</escalade:layout>