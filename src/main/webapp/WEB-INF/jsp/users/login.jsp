<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
	</head>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	
	<body>
	<c:out value="${error}" />  
		<div class="form-group">
			<form:form method="POST" modelAttribute="user"
				class="form-signin">

				<div class="row">

					<div class="col-md-2 col-lg-push-5">
						<!-- <h2 class="form-signin-heading">Create your account</h2> -->
						<h2 class="form-signin-heading">Login</h2>
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
						<button class="btn btn-default" type="submit">Submit</button>
					</div>
				</div>
			</form:form>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</escalade:layout>