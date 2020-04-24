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
			<input type="hidden" name="id" value="${point.id}" />
			<div class="col-sm-10">
				<escalade:inputField label="point" name="point.name" />
			</div>			
			<div class="col-sm-10">
				<escalade:inputField label="Under cotation"
					name="point.under_cotation" />
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<c:choose>
						<c:when test="${point['new']}">
							<button class="btn btn-default" type="submit">Add point</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-default" type="submit">Update point</button>								
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</form:form>
</escalade:layout>