<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="topoBkgs">
	<h2>Find topo booking</h2>
	<!-- Research sites by topoBkgs -->
	<spring:url value="/topoBkgs" var="formUrl" />
	<form:form modelAttribute="topoBkg" action="${fn:escapeXml(formUrl)}"
		method="get" class="form-horizontal" id="search-topoBkg-form">
		<div class="form-group">
			<div class="control-group" id="name">
				<label class="col-sm-2 control-label">Code topo Booking </label>
				<div class="col-sm-10">
					<form:input class="form-control" path="name" size="50"
						maxlength="50" />
					<span class="help-inline"><form:errors path="*" /></span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Find site</button>
			</div>
		</div>
	</form:form>
	<h2>topo bookings</h2>
	<table id="topoBkgsTable" class="table table-striped">
		<thead>
			<tr>
				<th style="width: 150px;">#</th>
				<th style="width: 250px;">Name</th>	
				<th style="width: 200px;">accepted</th>							
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${selections}" var="topoBkg">
				<tr>
					
					<td><spring:url value="/topoBkgs/{topoBkgId}/" var="topoBkgUrl">
							<spring:param name="topoBkgId" value="${topoBkg.id} " />
						</spring:url>
						<td><a href="${fn:escapeXml(topoBkgUrl)}"><c:out value="${topoBkg.name}"/></a> </td>
						
					<td><spring:url value="/topoBkgs/{topoBkgId}" var="topoBkgUrl">
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