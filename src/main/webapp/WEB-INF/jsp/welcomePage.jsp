<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="home">
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/webapp/resources/css/escalade.css" />
<title><c:out value="${title}" /></title>
	</head>
	<body>
		<div class="jumbotron text-center" style="margin-bottom: 0">
			<h1>Climbing website</h1>
			<p></p>
		</div>
		<h2>
			<!--<fmt:message key="welcome" /> -->
			<span> <c:out value="${message}" /></span>
		</h2>
		<div class="container" style="margin-top: 30px">
			<div class="row">
				<div class="col-sm-4">
					<h2>About Me</h2>
					<h5>Photo of me:</h5>
					<spring:url value="/resources/images/topos.png" htmlEscape="true"
						var="toposImage" />
					<img class="img-responsive" src="${toposImage}" />
					<p>Some text about me in culpa qui officia deserunt mollit
						anim..</p>
					<h3>Some Links</h3>
					<p>Lorem ipsum dolor sit ame.</p>
					 
					<ul class="nav nav-pills flex-column">
						<li class="nav-item"><a class="nav-link active" href="/login">login</a></li>						
					</ul>
					
					
					
					<hr class="d-sm-none">
				</div>
				<!--    
				<div class="col-sm-8">
					<h2>Le Grand Toit.</h2>
					<h5>Bloc falaise, Hauteur 10 à 18 m, 400 voies</h5>
					<spring:url value="/resources/images/Les_Eaux_Claires_bis.jpg"
						htmlEscape="true" var="toposImage" />
					<img class="img-responsive" src="${toposImage}" />
					<p>Les Eaux Claires</p>
					<p>PuyMoyen</p> -->
					<!--
					<br>
					<h2>Bloc de la Brioche</h2>
					<h5>Bloc falaise, Hauteur 10 à 18 m, 400 voies</h5>
					<spring:url value="/resources/images/Les_Eaux_Claires.jpg"
						htmlEscape="true" var="toposImage" />
					<img class="img-responsive" src="${toposImage}" />
					<p>Les Eaux Claires</p>
					<p>PuyMoyen</p>
					-->
				</div>
				
			</div>
		</div>
		<div class="jumbotron text-center" style="margin-bottom: 0">
			<p></p>
		</div>
	</body>
	</html>
</escalade:layout>

