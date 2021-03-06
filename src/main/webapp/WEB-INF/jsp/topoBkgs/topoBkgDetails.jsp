<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="topo_bkgs">
	<h2>Topo booking details</h2>
	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<td><c:out value="${topoBkg.topo.name}" /></td>
		</tr>

		<tr>
			<th>Borrow date</th>
			<td><c:out value="${topoBkg.borrowDate}" /></td>
		</tr>
		<tr>
			<th>Borrow end date</th>
			<td><c:out value="${topoBkg.borrowEndDate}" /></td>
		</tr>
		
		<tr>
		<th>Accepted</th>
			<td><c:out value="${topoBkg.accepted}" /></td>
		</tr>
				
	</table>
	
	<spring:url value="/topoBkgs/{topoBkgId}" var="editUrl">	
		<spring:param name="topoBkgId" value="${topoBkg.id}" />
	</spring:url>
	<a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit
		topo booking</a>	
		
</escalade:layout>
