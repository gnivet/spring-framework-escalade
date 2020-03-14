<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="areas">

<h2>Find site's type</h2>
    <!-- Research sites by areas -->
    <spring:url value="/areas" var="formUrl"/>
    <form:form modelAttribute="area" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-site-form">
        <div class="form-group">
            <div class="control-group" id="name">
                <label class="col-sm-2 control-label">Name </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="name" size="5" maxlength="5"/>                    
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>               
             
        </div> </div>  
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find site</button>
            </div>
        </div>
    </form:form>
    <h2>sites</h2>

    <table id="sitetypesTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>
           
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="sitetype">
            <tr>
                <td>
                    <spring:url value="/sitetypes/{sitetypeId}" var="sitetypeUrl">
                        <spring:param name="sitetypeId" value="${sitetype.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(sitetypeUrl)}"><c:out value="${sitetype.name}"/></a>
                </td>
                <td>
                    <c:out value="${sitetype.name}"/>
                </td>
                
                <td>
                    <c:forEach var="sitetype" items="${site.sitetypes}">
                        <c:out value="${sitetype.name} "/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>