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
<title><c:out value="${title}" /></title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<title>Create your account</title>
	</head>
	<body>
		<div class="form-group">

			<form:form method="POST" modelAttribute="user"
				class="form-signin">

				<div class="row">
					<div class="col-md-2 col-lg-push-5">
						<!-- <h1><spring:message code="greeting" text="default"/></h1> -->
						<h2 class="form-signin-heading">Create your account</h2>
						<spring:bind path="userName">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="text" path="userName" class="form-control"
									placeholder="userName" autofocus="true"></form:input>
								<form:errors path="userName"></form:errors>
							</div>
						</spring:bind>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-lg-push-5">
						<spring:bind path="password">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="password" path="password" class="form-control"
									placeholder="Password"></form:input>
								<form:errors path="password"></form:errors>
							</div>
						</spring:bind>
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-lg-push-5">
						<spring:bind path="passwordConfirm">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="password" path="passwordConfirm"
									class="form-control" placeholder="Confirm your password"></form:input>
								<form:errors path="passwordConfirm"></form:errors>
							</div>
						</spring:bind>						
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-lg-push-5">
						<spring:bind path="email">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="email" path="email"
									placeholder="Email" autofocus="true"></form:input>
								<form:errors path="email"></form:errors>
							</div>
						</spring:bind>						
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-lg-push-5">
						<spring:bind path="firstName">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="firstName" path="firstName"
									placeholder="FirstName" autofocus="true"></form:input>
								<form:errors path="firstName"></form:errors>
							</div>
						</spring:bind>						
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-lg-push-5">
						<spring:bind path="lastName">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="lastName" path="lastName"
									placeholder="LastName" autofocus="true"></form:input>
								<form:errors path="lastName"></form:errors>
							</div>
						</spring:bind>						
					</div>
				</div>
				<div class="row">
					<div class="col-md-2 col-lg-push-5">
						<spring:bind path="telephone">
							<div class="form-group ${status.error ? 'has-error' : ''}">
								<form:input type="telephone" path="telephone"
									placeholder="Telephone" autofocus="true"></form:input>
								<form:errors path="telephone"></form:errors>
							</div>
						</spring:bind>
						<button class="btn btn-default" type="submit">Submit</button>						
					</div>
				</div>
			</form:form>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
	</html>
</escalade:layout>