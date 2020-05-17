<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="topos">
	<h2>Find topos</h2>
	<!-- Research topos -->
	<spring:url value="/topos" var="formUrl" />
	<form:form modelAttribute="topo" action="${fn:escapeXml(formUrl)}"
		method="get" class="form-horizontal" id="search-topo-form">
		<div class="form-group">
			<div class="control-group" id="name">
				<label class="col-sm-2 control-label">Code topo </label>
				<div class="col-sm-10">
					<form:input class="form-control" path="name" size="50"
						maxlength="50" />
					<span class="help-inline"><form:errors path="*" /></span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Find topo</button>
			</div>
		</div>
	</form:form>
	<h2>topo list: </h2>
	<h3>A topo with the mention true is available</h3>
	<table id="toposTable" class="table table-striped">
		<thead>
			<tr>
				<th style="width: 150px;">#</th>
				<th style="width: 200px;">Name</th>
				<th style="width: 200px;">True / False</th>
				<th style="width: 200px;">Description</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${selections}" var="topo">
				<tr>
					
					<td><spring:url value="/topos/{topoId}/topoBkgs" var="topoUrl">
							<spring:param name="topoId" value="${topo.id} " />
						</spring:url>
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