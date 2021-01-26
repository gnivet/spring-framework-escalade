<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="points">
<h2>Find points</h2>
    <!-- Research sites by points -->
    <spring:url value="/points" var="formUrl"/>
    <form:form modelAttribute="point" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-point-form">
        <div class="form-group">
            <div class="control-group" id="postalcode">
                <label class="col-sm-2 control-label">Code point </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="name" size="50" maxlength="50"/>                    
                    <span class="help-inline"><form:errors path="*"/></span>
                </div> 
        </div> </div>  
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find point</button>
            </div>
        </div>
    </form:form>
    <h2>points</h2>
    <table id="pointsTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="point">
            <tr>
                <td>
                    <spring:url value="/points/{pointId}" var="pointUrl">
                        <spring:param name="pointId" value="${point.id} "/>                       
                    </spring:url>
                    <a href="${fn:escapeXml(pointUrl)}"><c:out value="${point.name}"/></a>
                </td>                
                 <td>            
                    <c:forEach var="point" items="${point.length}">
                        <c:out value="${length.name} "/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>        
        </tbody>
    </table>
</escalade:layout>