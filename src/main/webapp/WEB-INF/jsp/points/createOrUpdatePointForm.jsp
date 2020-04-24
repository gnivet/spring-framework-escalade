<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="points">
	<h2>
		<c:if test="${point['new']}">New </c:if>
		point
	</h2>
	<form:form modelAttribute="point" class="form-horizontal"
		id="add-point-form">
		<div class="form-group has-feedback">
			<escalade:inputField label="Name" name="name" />
			<!--
			<spring:url value="/points/{pointId}" var="pointUrl">
				<spring:param name="pointId" value="${point.id}" />
			</spring:url>
			<a href="${fn:escapeXml(pointUrl)}">Edit point</a> <input type="hidden"
				name="pointId" value="${point.id}" />
			-->	
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${point['new']}">
						<button class="btn btn-default" type="submit">Add point</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-default" type="submit">Update point</button>
						<a class="btn btn-default" href='<spring:url value="/lengths/${length.id}/points/new/" htmlEscape="true"/>'>Add point</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
</escalade:layout>