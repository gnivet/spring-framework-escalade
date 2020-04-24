<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="lengths">
    <h2>
        <c:if test="${length['new']}">New </c:if> length
    </h2>
    <form:form modelAttribute="length" class="form-horizontal" id="add-length-form">
        <div class="form-group has-feedback">
            <escalade:inputField label="Name" name="name"/>
            <escalade:inputField label="Comment" name="comment"/>
            <escalade:inputField label="Cotation" name="cotation"/>
            <escalade:inputField label="Length_status" name="length_status"/>
            <escalade:inputField label="Under Cotation" name="under_cotation"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${length['new']}">
                        <button class="btn btn-default" type="submit">Add length</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update length</button>
                        <a class="btn btn-default" href='<spring:url value="/lengths/${length.id}/points/new/" htmlEscape="true"/>'>Add point</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>        
    </form:form>
</escalade:layout>
