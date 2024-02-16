<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
	
<escalade:layout pageName="dashboard">
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="/webapp/resources/css/escalade.css" />
<title><c:out value="${title}" /></title>
	</head>
	<h2>Dashboard</h2>	
	<h3 class="mycolor">Topos and sites</h3>
	<div>
		<img src="/resources/images/sites.png" class="rounded float-left"
			class="rounded mx-auto d-block" alt="cascadeDuRougetLandscape"
			width="152" height="118">
	</div>
	<div class="container-fluid">
		<div class="table-responsive">
			<div>
				<table class="table table-sm table-dark">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Caption</th>
							<!-- <th scope="col"></th>-->
							<th scope="col">All Topos borrowed:</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th scope="row">1</th>
							<td>My topos:</td>
							<td><a href="/topolist"><button class="btn-link"></button>topo
									list available </a></td>
						</tr>
						<tr>
							<th scope="row">2</th>
							<td>My borrowed topo list:</td>
							<td><a href="/topoBkgs"><button class="btn-link"></button>borrowed
									topo list </a></td>
						</tr>	
							<tr>
							<th scope="row">3</th>
							<td>My ways list:</td>
							<td><a href="/ways"><button class="btn-link"></button>way
									list </a></td>
						</tr>						
						<tr>
							<th scope="row">4</th>
							<td>My site list:</td>
							<td><a href="/sites"><button class="btn-link"></button>Site
									list</a></td>
						</tr>						
					</tbody>
				</table>
			</div>
		</div>


		<!--  -->
		<h3 class="mycolor">Activities</h3>
		<hr>
		<div class="table-responsive">
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">Caption</th>
						<th scope="col">My results</th>						
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row">1</th>
						<td>Commentary numbers:</td>
						<td><c:if test="${ !empty strcNb }">
								<p>
									<c:out value="${strcNb}" />
								</p>
							</c:if></td>

					</tr>					
					<tr>
						<th scope="row">2</th>
						<td>Number Site's owner:</td>
						<td><c:out value="${strsNb}" /></td>
					</tr>
					<tr>
						<th scope="row">3</th>
						<td>Number of borrowed topos:</td>
						<td><c:out value="${topoBorrowedNb}" /></td>
					</tr>
					<tr>
						<th scope="row">4</th>
						<td>My last commentaries:</td>
						<td><c:out value="${results}" /></td>
					</tr>
		
					<tr>
						<th scope="row">5</th>
						<td>Topo user's list</td>
						<td><c:out value="${topoListByuserName}" /></td>
						<c:if test="${not empty topoListByuserName}">
							<ul>
								<c:forEach var="listValue" items="${topoListByuserName}">
									<li>${listValue}</li>
								</c:forEach>
							</ul>

						</c:if>
					</tr>
					
					
					
					<tr>
						<th scope="row">6</th>
						<td>Booking user's list:</td>
						<td><c:out value="${topoBkgList}" /></td>
					</tr>
					<tr>
						<th scope="row">5</th>
						<td>Topo booking user's list</td>
						<td><c:out value="${topoBkgList}" /></td>
						<c:if test="${not empty topoBkgList}">
							<ul>
								<c:forEach var="listValue" items="${topoBkgList}">
									<li>${listValue}</li>
								</c:forEach>
							</ul>

						</c:if>
					</tr>
					<tr>
							<th scope="row">6</th>
							<td>My booking list:</td>
							<td><a href="/topoBkgs"><button class="btn-link"></button>Booking list</a></td>
						</tr>						
					
					
					<tr>
						<th scope="row">7</th>
						<td>Topo list</td>
						<td><c:out value="${topoListByName}" /></td>
						<c:if test="${not empty topoListByName}">
							<ul>
								<c:forEach var="listValue" items="${topoListByName}">
									<li>${listValue}</li>
								</c:forEach>
							</ul>

						</c:if>
					</tr>
					
					
					
					
				</tbody>




			</table>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
	<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
	</body>
</escalade:layout>