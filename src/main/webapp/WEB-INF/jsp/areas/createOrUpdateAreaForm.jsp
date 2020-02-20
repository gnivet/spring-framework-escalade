<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="areas">
    <h2>
        <c:if test="${area['new']}">New </c:if> Area
    </h2>
    <form:form modelAttribute="area" class="form-horizontal" id="add-area-form">
        <div class="form-group has-feedback">
            <escalade:inputField label="Name" name="name"/>
            <escalade:inputField label="Street" name="street"/>           
            <escalade:inputField label="Postal code" name="postalcode"/>
            <escalade:inputField label="City" name="city"/>
            <escalade:inputField label="GPS Coordinate" name="gpscoordinate"/>
            <escalade:inputField label="GPS Coordinate" name="gpscoordinate"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${area['new']}">
                        <button class="btn btn-default" type="submit">Add Area</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Area</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</escalade:layout>
