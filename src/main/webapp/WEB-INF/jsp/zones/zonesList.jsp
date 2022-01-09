<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="zones">
<h2>Find zones</h2>
    <!-- Research sites by zones -->
    <spring:url value="/zones" var="formUrl"/>
    <form:form modelAttribute="zone" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-zone-form">
        <div class="form-group">
            <div class="control-group" id="name">
                <label class="col-sm-2 control-label">Code zone </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="name" size="5" maxlength="5"/>                    
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>
        </div> </div>  
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find zone</button>
            </div>
        </div>
    </form:form>
    <h2>zones</h2>
    <table id="zonesTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th> 
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="zone">
            <tr>
                <td>
                    <spring:url value="/sites{siteId}/zones/{zoneId}" var="zoneUrl">
                    	<spring:param name="siteId" value="${site.id}"/>
                        <spring:param name="zoneId" value="${zone.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(zoneUrl)}"><c:out value="${zone.name} "/></a>
                </td>                    
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>
