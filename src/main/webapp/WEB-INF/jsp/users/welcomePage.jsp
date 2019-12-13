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
			<spring:url value="/resources/images/topos.png" htmlEscape="true"
				var="toposImage" />
			<img class="img-responsive" src="${toposImage}" />
		</div>
	</div>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet"
	href="/webapp/resources/css/escalade.css" />
   <link rel="stylesheet" href="/resources/css/escalade.css"/>  
<title><c:out value="${title}" /></title>
	</head>
	<body>

		<h2>
			<!--  Message
		<fmt:message key="welcome" />	 -->
			<span> <c:out value="${message}" /></span>
		</h2>
		<aside>
			<form method="post" action="users/userInfo">
				<fieldset>
					<legend>Login</legend>
					<label for="email">Email<span class="requis">*</span></label> <input
						type="text" id="email" name="email" value="" size="20"
						maxlength="60" /> <br /> <label for="password">Password
						<span class="requis">*</span>
					</label> <input type="password" id="password" name="password" value=""
						size="20" maxlength="20" /> <br /> <input type="submit"
						value="Send" class="sansLabel" /> <br />
				</fieldset>
			</form>
		</aside>
	</body>
	</html>
</escalade:layout>
