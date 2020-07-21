<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<escalade:layout pageName="users">

	<h2>User Information</h2>


	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<td><b><c:out value="${user.firstName} ${user.lastName}" /></b></td>
		</tr>
		<tr>
			<th>Email</th>
			<td><c:out value="${user.firstEmail}" /></td>
		</tr>		
		<tr>
			<th>Address</th>
			<td><c:out value="${user.address}" /></td>
		</tr>
		<tr>
			<th>Postal code</th>
			<td><c:out value="${user.postalcode}" /></td>
		</tr>
		<tr>
			<th>City</th>
			<td><c:out value="${user.city}" /></td>
		</tr>
		<tr>
			<th>Telephone</th>
			<td><c:out value="${user.telephone}" /></td>
		</tr>
		<tr>
			<th>User name</th>
			<td><c:out value="${user.firstuserName}" /></td>
		</tr>
		<tr>
			<th>Password</th>
			<td><c:out value="${user.firstPassword}" /></td>
		</tr>
		<tr>
			<th>Valid</th>		
			<td><c:out value="${user.valid}" /></td>
        <tr>
            
         </tr>    	
				
	</table>

	<spring:url value="{userId}/edit.html" var="editUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit
		User</a>

	<spring:url value="/users/{userId}/delete.html" var="delUrl">
		<spring:param name="userId" value="${user.id}" />
	</spring:url>
	<a href="${fn:escapeXml(delUrl)}" class="btn btn-default">Delete
		User</a>

	<br />
	<br />
	<br />

</escalade:layout>