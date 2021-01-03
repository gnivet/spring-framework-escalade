<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ attribute name="name" required="true" rtexprvalue="true"
	description="Name of the active menu: home, users, topos, areas or error"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>	
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/">Escalade</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><escalade:menuItem
						active="${name eq 'home'}" url="/" title="home page">
						<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
						<span>Home Info</span>
					</escalade:menuItem></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#">Login <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<sec:authorize access="isAuthenticated() == false">
							<li><escalade:menuItem active="${name eq 'login'}"
									url="/users/login" title="login page">
									<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
									<span>Login</span>
								</escalade:menuItem></li>
						</sec:authorize>
						<sec:authorize access="isAuthenticated() == false">
							<escalade:menuItem active="${name eq 'users'}"
								url="/users/registration" title="register">
								<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
								<span>Register</span>
							</escalade:menuItem>
						</sec:authorize>
					</ul></li>
				<sec:authorize access="isAuthenticated() == true">
					<li class="active"></li>
					<li><escalade:menuItem active="${name eq 'dashboard'}"
							url="/dashboards/dashboard/" title="dashboard">
							<span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
							<span>Dashboard</span>
						</escalade:menuItem></li>


					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Site <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><escalade:menuItem active="${name eq 'areas'}"
									url="/sites/find/" title="sites">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Sites</span>
								</escalade:menuItem></li>
							<li><escalade:menuItem active="${name eq 'sites'}"
									url="/areas/new/" title="sites">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Sites</span>
								</escalade:menuItem></li>
							<li><escalade:menuItem active="${name eq 'sites'}"
									url="/sites" title="sites">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Sites</span>
								</escalade:menuItem></li>
						</ul></li>



					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Area <span class="caret"></span></a>
						<ul class="dropdown-menu">

							<li><escalade:menuItem active="${name eq 'areas'}"
									url="/areas/find/" title="areas">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Areas</span>
								</escalade:menuItem></li>
							<escalade:menuItem active="${name eq 'areas'}" url="/areas/new/"
								title="areas">
								<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
								<span>Areas</span>
							</escalade:menuItem>
							<li><escalade:menuItem active="${name eq 'areas'}"
									url="/areas" title="areas">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Areas</span>
								</escalade:menuItem></li>
						</ul></li>


					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Site type <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li>
							<!-- <li><escalade:menuItem active="${name eq 'sitetypes'}"
									url="/sitetypes/find/" title="sitetypes">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Site types</span>
								</escalade:menuItem></li>
							<li><escalade:menuItem active="${name eq 'sitetypes'}"
									url="/sitetypes/new" title="sitetypes">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Sites Type</span>
								</escalade:menuItem></li> -->
							<li><escalade:menuItem active="${name eq 'sitetypes'}"
									url="/sitetypes" title="sitetypes">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Site's type</span>
								</escalade:menuItem></li>
						</ul></li>


					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Zone <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><escalade:menuItem active="${name eq 'zones'}"
									url="/zones/find/" title="zones">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Zones</span>
								</escalade:menuItem></li> <!-- 
							<li><escalade:menuItem active="${name eq 'zones'}"
									url="/sites/{siteId}/zones/new/" title="zones">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Zones</span>
								</escalade:menuItem></li>  -->
							<li><escalade:menuItem active="${name eq 'zones'}"
									url="/zones" title="zones">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Zones</span>
								</escalade:menuItem></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Way <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><escalade:menuItem active="${name eq 'ways'}"
									url="/ways/find/" title="ways">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Ways</span>
								</escalade:menuItem></li> <!--  
							<li><escalade:menuItem active="${name eq 'ways'}"
									url="/zones/{zoneId}/ways/new/" title="ways">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Ways</span>
								</escalade:menuItem></li> -->
							<li><escalade:menuItem active="${name eq 'ways'}"
									url="/ways" title="ways">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>ways</span>
								</escalade:menuItem></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Length <span class="caret"></span></a>
						<ul class="dropdown-menu">

							<li><escalade:menuItem active="${name eq 'lengths'}"
									url="/lengths/find/" title="lengths">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Lengths</span>
								</escalade:menuItem></li> <!--  
							<li><escalade:menuItem active="${name eq 'lengths'}"
									url="/ways/{wayId}/lengths/new/" title="lengths">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Lengths</span>
								</escalade:menuItem></li> -->
							<li><escalade:menuItem active="${name eq 'lengths'}"
									url="/lengths" title="lengths">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Lengths</span>
								</escalade:menuItem></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Point <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><escalade:menuItem active="${name eq 'points'}"
									url="/points/find/" title="points">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Points</span>
								</escalade:menuItem></li> <!--  
							<li><escalade:menuItem active="${name eq 'points'}"
									url="/lengths/{lengthId}/points/new/" title="points">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Points</span>
								</escalade:menuItem></li> -->
							<li><escalade:menuItem active="${name eq 'points'}"
									url="/points" title="points">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Points</span>
								</escalade:menuItem></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Comment <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><escalade:menuItem active="${name eq 'comments'}"
									url="/comments/find/" title="find comments">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Find comments</span>
								</escalade:menuItem></li>
								 
							<li><escalade:menuItem active="${name eq 'comments'}"
									url="/sites/{siteId}/comments/new" title="comments">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Comments</span> 
								</escalade:menuItem></li> 
							<li><escalade:menuItem active="${name eq 'comments'}"
									url="/comments" title="comments">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Comments</span>
								</escalade:menuItem></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Topo <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><escalade:menuItem active="${name eq 'topos'}"
									url="/topos/find/" title="find topos">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Find topos</span>
									  
								</escalade:menuItem></li>
								
							<li><escalade:menuItem active="${name eq 'topos'}"
									url="/topos/new/" title="topos">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Topos</span>
								</escalade:menuItem></li> 
							<li><escalade:menuItem active="${name eq 'topos'}"
									url="/topolist" title="topos">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Topos</span>
								</escalade:menuItem></li>
						</ul></li>

					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Topo booking<span
							class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><escalade:menuItem active="${name eq 'topoBkgs'}"
									url="/topos/find" title="find topos">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Find topo Booking</span>
								</escalade:menuItem></li>
							<li><escalade:menuItem active="${name eq 'topoBkgs'}"
									url="/findTopoBkgsByUserName" title="find topoBkgs by username ">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									<span>Find topo Booking by username</span>
								</escalade:menuItem></li>
								<!--  	
							<li><escalade:menuItem active="${name eq 'topoBkgs'}"
									url="/topoBkgs/new" title="topoBkgs">
									<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
									<span>Topo Bookings</span>
								</escalade:menuItem></li> -->
							<li><escalade:menuItem active="${name eq 'topoBkgs'}"
									url="/topoBkgs" title="topoBkgs">
									<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
									<span>Topo Bookings</span>
								</escalade:menuItem></li>
						</ul></li>


					<li><sec:authorize access="isAuthenticated()">
							<escalade:menuItem active="${name eq 'logout'}"
								url="/users/logout" title="logoutSuccessfulPage page">
								<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
								<span>Logout</span>
							</escalade:menuItem>
						</sec:authorize></li>
					<li><escalade:menuItem active="${name eq 'error'}"
							url="/error/oups"
							title="trigger a RuntimeException to see how it is handled">
							<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
							<span>Error</span>
						</escalade:menuItem></li>
				</sec:authorize>
			</ul>
			<!-- fin  container-fluid -->
		</div>
	</nav>
</body>
</html>


