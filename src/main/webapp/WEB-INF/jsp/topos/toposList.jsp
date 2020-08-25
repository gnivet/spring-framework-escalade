<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="topos">
	<h2>topo list: </h2>		
	<table id="toposTable" class="table table-striped">
		<thead>
			<tr>
				<th style="width: 1px;">#</th>				
				<th style="width: 200px;">Name</th>
				<th style="width: 200px;">Click on true to book </th>
				<th style="width: 200px;">Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${selections}" var="topo">
				<tr>
					
					<td><spring:url value="/topos/{topoId}/" var="topoUrl">
							<spring:param name="topoId" value="${topo.id} " />
						</spring:url>
						<input type="hidden" name="id" value="${user.id}" />     
					<td><a href="${fn:escapeXml(topoUrl)}"><c:out value="${topo.name}"/></a> </td>						
					<td><spring:url value="/topos/{topoId}/topoBkgs/new/" var="topoUrl">
							<spring:param name="topoId" value="${topo.id} " />
						</spring:url>							
						<c:if test="${topo.available == true}"><a href="${fn:escapeXml(topoUrl)}"><c:out value="${topo.available}" /></a></c:if>
						<c:if test="${topo.available == false}"><c:out value="${topo.available}" /></c:if>						
					<td><c:out value="${topo.description}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</escalade:layout>