<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="topoBkgs">
	<h2>Topo booking details</h2>
	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<td><b><c:out value="${topoBkg.name} " /></b></td>
		</tr>
		<tr>
			<th>Accepted</th>
			<td><c:out value="${topoBkg.accepted}" /></td>
		</tr>
		
		<tr>
			<th>Borrow date</th>
			<td><c:out value="${topoBkg.borrow_date}" /></td>
		</tr>
		<tr>
			<th>Borrow end date</th>
			<td><c:out value="${topoBkg.borrow_end_date}" /></td>
		</tr>
	
		<tr>
			<th>In progress</th>
			<td><c:out value="${topoBkg.in_progress}" /></td>
		</tr>					
	</table>
</escalade:layout>
