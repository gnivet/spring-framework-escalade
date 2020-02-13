<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="sitetypes">
    <h2>
        <c:if test="${sitetype['new']}">New </c:if> Type site
    </h2>
    <form:form modelAttribute="sitetype" class="form-horizontal" id="add-sitetype-form">
        <div class="form-group has-feedback">
            <escalade:inputField label="Name" name="name"/>            
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${sitetype['new']}">
                        <button class="btn btn-default" type="submit">Add Type</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Type</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</escalade:layout>
