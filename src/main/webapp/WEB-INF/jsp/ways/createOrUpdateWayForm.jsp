<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="ways">
	<h2>
		<c:if test="${way['new']}">New </c:if>
		Way
	</h2>
	<form:form modelAttribute="way" class="form-horizontal"
		id="add-way-form">
		<div class="form-group has-feedback">
			<escalade:inputField label="Name" name="name" />
			<spring:url value="/ways/{wayId}/edit" var="wayUrl">
				<spring:param name="wayId" value="${way.id}" />
			</spring:url>
			<a href="${fn:escapeXml(wayUrl)}">Edit Way</a> <input type="hidden"
				name="wayId" value="${way.id}" />
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${way['new']}">
						<button class="btn btn-default" type="submit">Add Way</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-default" type="submit">Update Way</button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
</escalade:layout>