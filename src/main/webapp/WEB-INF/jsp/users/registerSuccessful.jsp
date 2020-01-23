<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="user" >

	<h2>User details</h2>

	<table class="table table-striped" >
		<tr>
			<th>Name</th>
			<td><b><c:out value="${user.username} " /></b></td>
			<td><b><c:out value="${username}"/></b></td>
			
			
		</tr>
		<tr>
			<th>Password</th>
			<td><c:out value="${user.encryted_password}" /></td>
			<td><b><c:out value="${password}"/></b></td>
			<td><b><c:out value="${encryted_password}"/></b></td>
		</tr>
		
	</table>	
</escalade:layout>
