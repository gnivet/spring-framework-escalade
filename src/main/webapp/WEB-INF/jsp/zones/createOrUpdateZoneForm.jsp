<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="zones">
    <h2>
        <c:if test="${zone['new']}">New </c:if> zone
    </h2>
    <form:form modelAttribute="zone" class="form-horizontal" id="add-zone-form">
        <div class="form-group has-feedback">
            <escalade:inputField label="Name" name="name"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${zone['new']}">
                        <button class="btn btn-default" type="submit">Add zone</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update zone</button>
                        <a class="btn btn-default" href='<spring:url value="/zones/${zone.id}/ways/new/" htmlEscape="true"/>'>Add way</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        
    </form:form>
</escalade:layout>
