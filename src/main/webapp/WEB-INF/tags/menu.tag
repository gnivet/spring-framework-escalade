<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<%@ attribute name="name" required="true" rtexprvalue="true" description="Name of the active menu: home, users, topos, areas or error"%>	
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>	


<nav class="navbar navbar-default" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<a class="navbar-brand"
				href="<spring:url value="/" htmlEscape="true" />"><span></span></a>
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#main-navbar">
				<span class="sr-only"><os-p>Toggle navigation</os-p></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
			</button>

		</div>
		<div class="navbar-collapse collapse" id="main-navbar">
			<ul class="nav navbar-nav navbar-right">


				<escalade:menuItem active="${name eq 'home'}" url="/"
					title="home page">
					<span class="glyphicon glyphicon-home" aria-hidden="true"></span>
					<span>Home Info</span>
				</escalade:menuItem>
				
				<sec:authorize access="isAuthenticated() == false">
				    <escalade:menuItem active="${name eq 'login'}" url="/users/login"
					title="login page">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span>
					<span>Login</span>
				</escalade:menuItem>
				</sec:authorize>
								
				<sec:authorize access="isAuthenticated() == false">
					<escalade:menuItem active="${name eq 'users'}"
						url="/users/registration" title="register">
						<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
						<span>Register</span>
					</escalade:menuItem>
				</sec:authorize>
				<sec:authorize access="isAuthenticated() == true">
				<escalade:menuItem active="${name eq 'dashboard'}" url="/dashboard/" title="dashboard">
                    <span class="glyphicon glyphicon-tasks" aria-hidden="true"></span>
                    <span>Dashboard</span>
                </escalade:menuItem>

				<escalade:menuItem active="${name eq 'sites'}" url="/sites" title="sites">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Sites</span>
                </escalade:menuItem>
                <escalade:menuItem active="${name eq 'sites'}" url="/areas/{areaId}/sites/new/"
					title="sites">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<span>Sites</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'areas'}" url="/sites/find/"
					title="sites">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Sites</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'areas'}" url="/areas/new/"
					title="areas">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<span>Areas</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'areas'}" url="/areas/find/"
					title="areas">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Areas</span>
				</escalade:menuItem>
				  <escalade:menuItem active="${name eq 'areas'}" url="/areas" title="areas">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Areas</span>
                </escalade:menuItem>         
				<escalade:menuItem active="${name eq 'sitetypes'}" url="/sitetypes/new/"
					title="sitetypes">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<span>Sites Type</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'areas'}" url="/sitetypes/find/"
					title="sitetypes">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Site types</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'zones'}" url="/sitetypes" title="sitetypes">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Site's type</span>
                </escalade:menuItem>
				<escalade:menuItem active="${name eq 'zones'}" url="/zones/find/"
					title="zones">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Zones</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'zones'}" url="/sites/{siteId}/zones/new/"
					title="zones">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<span>Zones</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'zones'}" url="/zones" title="zones">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Zones</span>
                </escalade:menuItem>
				<escalade:menuItem active="${name eq 'ways'}" url="/ways/find/"
					title="ways">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Ways</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'ways'}" url="/zones/{zoneId}/ways/new/"
					title="ways">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<span>Ways</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'ways'}" url="/ways" title="ways">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>ways</span>
                </escalade:menuItem>				
				<escalade:menuItem active="${name eq 'lengths'}" url="/ways/{wayId}/lengths/new/"
					title="lengths">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<span>Lengths</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'lengths'}" url="/lengths" title="lengths">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Lengths</span>
                </escalade:menuItem>
                <escalade:menuItem active="${name eq 'lengths'}" url="/lengths/find/"
					title="lengths">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Lengths</span>
				</escalade:menuItem>
				
				<escalade:menuItem active="${name eq 'points'}" url="/lengths/{lengthId}/points/new/"
					title="points">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<span>Points</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'points'}" url="/points/find/"
					title="points">
					<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
					<span>Points</span>
				</escalade:menuItem>
				<escalade:menuItem active="${name eq 'points'}" url="/points" title="points">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Points</span>
                </escalade:menuItem>	
                <escalade:menuItem active="${name eq 'comments'}" url="/comments/find/" title="find comments">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    <span>Find comments</span>
                </escalade:menuItem>
                <escalade:menuItem active="${name eq 'comments'}" url="/sites/{siteId}/comments/new/"
					title="comments">
					<span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>
					<span>Comments</span>
				</escalade:menuItem>  
                <escalade:menuItem active="${name eq 'comments'}" url="/comments" title="comments">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Comments</span>
                </escalade:menuItem>                
				<!-- == true -->
				<sec:authorize access="isAuthenticated()">
				<escalade:menuItem active="${name eq 'logout'}" url="/users/logout"
					title="logoutSuccessfulPage page">
					<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
					<span>Logout</span>
				</escalade:menuItem>
				</sec:authorize>
				<escalade:menuItem active="${name eq 'error'}" url="/oups"
					title="trigger a RuntimeException to see how it is handled">
					<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
					<span>Error</span>
				</escalade:menuItem>
				</sec:authorize>
			</ul>
		</div>
	</div>
</nav>
