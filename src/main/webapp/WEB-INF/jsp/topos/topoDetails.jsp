<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="topos">
	<h2>Site details</h2>
	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<td><b><c:out value="${topo.name} " /></b></td>
		</tr>
		<tr>
			<th>Available</th>
			<td><c:out value="${topo.available}" /></td>
		</tr>
		<tr>
			<th>Description</th>
			<td><c:out value="${topo.description}" /></td>
		</tr>
	</table>
</escalade:layout>
