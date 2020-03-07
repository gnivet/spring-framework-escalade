<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="users">
	<h2>Users</h2>
	<table id="usersTable" class="table table-striped">
		<thead>
			<tr>
				<th style="width: 150px;">Name</th>
				<th style="width: 200px;">Email</th>				
				<th style="width: 200px;">Adress</th>
				<th style="width: 150px;">Postal code</th>
				<th style="width: 150px;">City</th>
				<th style="width: 150px;">Phone number</th>
				<th style="width: 150px;">User name</th>
				<th style="width: 100px;">Password</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${selections}" var="user">
				<tr>
					<td><spring:url value="/users/{userId}.html" var="userUrl">
							<spring:param name="userId" value="${user.id}" />
						</spring:url> <a href="${fn:escapeXml(userUrl)}"><c:out
								value="${user.firstName} ${user.lastName}" /></a>
					</td>
					<td><c:out value="${user.firstEmail}" /></td>				
					<td><c:out value="${user.address}" /></td>
					<td><c:out value="${user.postalcode}" /></td>
					<td><c:out value="${user.city}" /></td>
					<td><c:out value="${user.telephone}" /></td>
					<td><c:out value="${user.firstUsername}" /></td>
					<td><c:out value="${user.firstPassword}" /></td>					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<table class="table-buttons">
		<tr>
			<td>				
				 <a class="btn btn-default" href='<spring:url value="/users/new" htmlEscape="true"/>'>Add User</a>	
		</tr>
	</table>
</escalade:layout>
