<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<%@ attribute name="name" required="true" rtexprvalue="true"
              description="Name of the active menu: home, users, topos, areas or error" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>              

<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="<spring:url value="/" htmlEscape="true" />"><span></span></a>
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#main-navbar">
                <span class="sr-only"><os-p>Toggle navigation</os-p></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
                   
        </div>
        <div class="navbar-collapse collapse" id="main-navbar">
            <ul class="nav navbar-nav navbar-right">
				
										
                <escalade:menuItem active="${name eq 'home'}" url="/" title="home page">
                    <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    <span>Home Info</span>
                </escalade:menuItem>
                 
                <escalade:menuItem active="${name eq 'users'}" url="/users/userInfo" title="user page">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    <span>User</span>
                </escalade:menuItem>                
                <sec:authorize access="isAuthenticated() == false">
                <escalade:menuItem active="${name eq 'users'}"  url="/users/register" title="register">
                    <span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>
                    <span>Register</span>
                </escalade:menuItem></sec:authorize>
                                             
                <escalade:menuItem active="${name eq 'admin'}"  url="/users/admin" title="admin page">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                    <span>Admin</span>
                </escalade:menuItem>
                
				<escalade:menuItem active="${name eq 'areas'}" url="/areas" title="topos">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    <span>Topos</span>
                </escalade:menuItem>               
                				
                <escalade:menuItem active="${name eq 'users'}" url="/users/find" title="find users">
                    <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                    <span>Find users</span>
                </escalade:menuItem>
                
                <escalade:menuItem active="${name eq 'users'}" url="/users" title="users">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                    <span>Users</span>
                </escalade:menuItem>

                <escalade:menuItem active="${name eq 'error'}" url="/oups"
                            title="trigger a RuntimeException to see how it is handled">
                    <span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
                    <span>Error</span>
                </escalade:menuItem>
                
                <escalade:menuItem active="${name eq 'logout'}" url="/users/logout" title="logoutSuccessfulPage page">
                    <span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
                    <span>Logout</span>
                </escalade:menuItem> 

            </ul>
        </div>
    </div>
</nav>
