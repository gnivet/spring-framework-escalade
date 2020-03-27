<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="sites">

<h2>Find sites</h2>
    <!-- Research sites by sites -->
    <spring:url value="/sites" var="formUrl"/>
    <form:form modelAttribute="site" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-site-form">
        <div class="form-group">
            <div class="control-group" id="name">
                <label class="col-sm-2 control-label">Code site </label>
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

    <table id="sitesTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>
            <th style="width: 200px;">Birth date</th>
            <th style="width: 200px;">Valid</th>           
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="site">
            <tr>
                <td>
                    <spring:url value="/sites/{siteId}" var="siteUrl">
                        <spring:param name="siteId" value="${site.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(siteUrl)}"><c:out value="${site.name}"/></a>
                </td>
                <td>
                    <c:out value="${site.birth_date}"/>
                </td>
                 <td>
                    <c:out value="${site.valid}"/>
                </td>               
                <td>
                    <c:forEach var="site" items="${user.sites}">
                        <c:out value="${site.name} "/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>