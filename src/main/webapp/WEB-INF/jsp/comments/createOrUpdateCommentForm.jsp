<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="comments">
	<h2>
		<c:if test="${comment['new']}">New </c:if>
		Comment
	</h2>
	<form:form modelAttribute="comment" class="form-horizontal"
		id="add-comment-form">
		<div class="form-group has-feedback">
			<escalade:inputField label="Name" name="name" />
			<escalade:inputField label="Date" name="date" />
			<escalade:inputField label="Comment" name="comment" />
			<input type="hidden" name="siteId" value="${site.id}"/>
			 <input	type="hidden" name="userId" value="${user.id}" /> 
				<c:out value="${comment.user.username} " />
		</div>	
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<c:choose>
					<c:when test="${comment['new']}">
						<button class="btn btn-default" type="submit">Add Comment</button>
					</c:when>
					<c:otherwise>
						<button class="btn btn-default" type="submit">Update
							Comment</button>
							<a class="btn btn-default" href='<spring:url value="/sites/{siteId}/comments/new" htmlEscape="true"/>'>Add comment</a>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</form:form>
</escalade:layout>