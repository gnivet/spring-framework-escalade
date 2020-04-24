<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="ways">

<h2>Find sites</h2>
    <!-- Research sites by ways -->
    <spring:url value="/ways" var="formUrl"/>
    <form:form modelAttribute="way" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-way-form">
        <div class="form-group">
            <div class="control-group" id="postalcode">
                <label class="col-sm-2 control-label">Code way </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="name" size="50" maxlength="50"/>                    
                    <span class="help-inline"><form:errors path="*"/></span>
                </div> 
        </div> </div>  
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find way</button>
            </div>
        </div>
    </form:form>
    <h2>sites</h2>

    <table id="waysTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="way">
            <tr>
                <td>
                    <spring:url value="/ways/{wayId}" var="wayUrl">
                        <spring:param name="wayId" value="${way.id} "/>                       
                    </spring:url>
                    <a href="${fn:escapeXml(wayUrl)}"><c:out value="${way.name}"/></a>
                </td>   
                <!--              
                 <td>
                    <c:forEach var="way" items="${way.lengths}">
                        <c:out value="${length.name} "/>
                    </c:forEach>
                </td>
                --> 
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>