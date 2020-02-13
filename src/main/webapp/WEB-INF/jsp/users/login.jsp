<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="home">
	<div class="row">
		<div class="col-md-12">
			<spring:url value="/resources/images/sites.png" htmlEscape="true"
				var="sitesImage" />
			<img class="img-responsive" src="${sitesImage}" />
		</div>
	</div>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="/spring-framework-escalade/src/main/webapp/resources/css/escalade.css" />
<title><c:out value="${title}" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title>Log in with your account</title>

<link href="${contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	</head>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<body>
		<div class="form-group">
			<form:form method="POST" modelAttribute="userForm"
				class="form-signin">
				<h2 class="form-signin-heading">Login</h2>
				<div class="row">
					
					<div class="col-md-2 col-lg-push-1">
						<!-- <h2 class="form-signin-heading">Create your account</h2> -->
						<spring:bind path="username">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="text" path="username" class="form-control"
									placeholder="Username" autofocus="true"></form:input>
								<form:errors path="username"></form:errors>
							</div>
						</spring:bind>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-lg-push-1">
						<spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="password" path="password" class="form-control"
									placeholder="Password"></form:input>
								<form:errors path="password"></form:errors>
							</div>
						</spring:bind>
						<button class="btn btn-lg btn-danger btn-block" type="submit">Submit</button>
					</div>
				</div>
			</form:form>
		</div>
		<!-- /container -->
		
	</body>
</escalade:layout>