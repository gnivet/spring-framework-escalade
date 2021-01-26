<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="areas">
<h2>Find areas</h2>
    <!-- Research sites by areas -->
    <spring:url value="/areas" var="formUrl"/>
    <form:form modelAttribute="area" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-site-form">
        <div class="form-group">
            <div class="control-group" id="postalcode">
                <label class="col-sm-2 control-label">Code area </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="postalcode" size="5" maxlength="5"/>                    
                    <span class="help-inline"><form:errors path="*"/></span>
                </div> 
        	</div> 
        </div>  
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find site</button>
            </div>
        </div>
    </form:form>
    <h2>areas</h2>
    <table id="areasTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>
            <th style="width: 200px;">Street</th>
            <th style="width: 200px;">Postal code</th>
            <th>City</th>
            <th>Country</th>
            <th style="width: 120px;">GPS Coordinate</th>           
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="area">
            <tr>
                <td>
                    <spring:url value="/areas/{areaId}" var="areaUrl">
                        <spring:param name="areaId" value="${area.id} "/>                       
                    </spring:url>
                    <a href="${fn:escapeXml(areaUrl)}"><c:out value="${area.name}"/></a>
                </td>
                <td>
                    <c:out value="${area.street}"/>
                </td>
                 <td>
                    <c:out value="${area.postalcode}"/>
                </td>
                <td>
                    <c:out value="${area.city}"/>
                </td>
                 <td>
                    <c:out value="${area.country}"/>
                </td>
                <td>
                    <c:out value="${area.gpscoordinate}"/>
                </td>
               
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>