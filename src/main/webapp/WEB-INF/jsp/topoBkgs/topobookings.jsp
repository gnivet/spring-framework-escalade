<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="topobookings">
	<h2>topo bookings</h2>
	<table id="topoBkgsTable" class="table table-striped">
		<thead>
			<tr>
				<th style="width: 1px;">#</th>
				<th style="width: 250px;">Name</th>	
				<th style="width: 200px;">accepted</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${selections}" var="topoBkg">
				<tr>
					
					<td><spring:url value="/topoBkgs/{topoBkgId}/" var="topoBkgUrl">
							<spring:param name="topoId" value="${topo.id} " />
							<spring:param name="topoBkgId" value="${topoBkg.id} " />
						</spring:url>
						<td><a href="${fn:escapeXml(topoBkgUrl)}"><c:out value="${topoBkg.topo_id}"/></a> </td>
						
					<td><spring:url value="/topoBkgs/{topoBkgId}/" var="topoBkgUrl">
							<spring:param name="topoId" value="${topo.id} " />
							<spring:param name="topoBkgId" value="${topoBkg.id} " />
						</spring:url>							
						<c:if test="${topoBkg.accepted == true}"><a href="${fn:escapeXml(topoBkgUrl)}"><c:out value="${topoBkg.accepted}" /></a></c:if>
						<c:if test="${topoBkg.accepted == false}"><c:out value="${topoBkg.accepted}" /></c:if>	
					</td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
</escalade:layout>