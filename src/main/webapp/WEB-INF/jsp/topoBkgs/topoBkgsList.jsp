<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="topoBkgs">	
	<h2>topo bookings</h2>
	<table id="topoBkgsTable" class="table table-striped">
		<thead>
			<tr>
				<th style="width: 1px;">#</th>
				<th style="width: 250px;">Name</th>
				<th style="width: 200px;">Borrow date</th>
				<th style="width: 200px;">Borrow end date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${selections}" var="topoBkg">
				<tr>
				<td>
					<spring:url value="/topoBkgs/{topoBkgId}/" var="topoBkgUrl">
						<spring:param name="topoBkgId" value="${topoBkg.id} " />
					</spring:url>
					<a href="${fn:escapeXml(topoBkgUrl)}"><c:out value="${topoBkg.topo.name}"/></a>
				</td>
				<td>
					<c:out value="${topoBkg.topo.name}" />
				</td>
				<td>
					<c:out value="${topoBkg.borrowDate}" />
				</td>
				<td>
					<c:out value="${topoBkg.borrowEndDate}" />
				</td>
				<td>
					<c:if test="${topoBkg.accepted == true}">
						<a href="${fn:escapeXml(topoBkgUrl)}"><c:out
								value="${topoBkg.accepted} " /></a>
					</c:if>
				</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</escalade:layout>