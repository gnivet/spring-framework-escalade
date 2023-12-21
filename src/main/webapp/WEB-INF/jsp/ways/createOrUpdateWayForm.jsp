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
		way
	</h2>
	<form:form modelAttribute="way" class="form-horizontal"
		id="add-way-form">
		<div class="form-group has-feedback">
			<escalade:inputField label="Name" name="name" />			
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${way['new']}">
						<button class="btn btn-default" type="submit">Add way</button>						
					</c:when>
					<c:otherwise>
						<button class="btn btn-default" type="submit">Update way</button>						
						 <a class="btn btn-default" href='<spring:url value="/ways/${way.id}/lengths/new/" htmlEscape="true"/>'>Add length</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>		
	</form:form>
</escalade:layout>