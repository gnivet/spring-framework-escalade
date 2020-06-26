<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="site_types"> 
  	<h2>
		<c:if test="${siteType['new']}">New </c:if>
		site's type
	</h2>
    <form:form modelAttribute="siteType" class="form-horizontal" id="add-sitetype-form">
        <div class="form-group has-feedback">
            <escalade:inputField label="Name" name="name"/>                       
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${siteType['new']}">
                        <button class="btn btn-default" type="submit">Add Site Type</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Type</button>
                         <a class="btn btn-default" href='<spring:url value="/site_types/${siteType.id}/Site_types/new/" htmlEscape="true"/>'>Add site type</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</escalade:layout>
