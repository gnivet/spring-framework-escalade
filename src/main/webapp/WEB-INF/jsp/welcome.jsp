<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<escalade:layout pageName="home">
	<div class="row">
		<div class="glyphicon">
			<spring:url value="/resources/images/sites.png" htmlEscape="true"
				var="sitesImage" />
			<img class="img-responsive" src="${sitesImage}" />
		</div>
	</div>
	<head>	
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/webapp/resources/css/escalade.css" />
<title><c:out value="${title}" /></title>
	</head>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<body>
		<div class="form-group mb-2">
			<div class="col-sm-10">
				<h2>Welcome ${pageContext.request.userPrincipal.name}</h2>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
					<form id="logoutForm" method="POST">
						<sec:authorize access="isAuthenticated()">
							<escalade:menuItem active="${name eq 'logout'}"
								url="/users/logout" title="logoutSuccessfulPage page">
								<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
								<aside>
									<span class="mylogout">Logout</span>
								</aside>
							</escalade:menuItem>
						</sec:authorize>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form>
					<!-- | <a
						onclick="document.forms['logoutForm'].submit()">Logout</a>  -->
				</c:if>
			</div>
		</div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</escalade:layout>