<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="userInfoPage">

   <head>
      <title>User Info</title>
   </head>
   <body>
      <!-- Include _menu.html -->
         
       
      <h2>User Info Page</h2>
      <h3><c:out value="${userPrincipal.name}"></c:out></h3>
      <b>This is protected page!</b>  
       
      <br/><br/>
       
      <div>
      	<c:if test="${userInfo != null }">
    	<p><c:out value="${ userInfo }"></c:out></p>
		</c:if>  
	</div>
	</html>
</escalade:layout>    
