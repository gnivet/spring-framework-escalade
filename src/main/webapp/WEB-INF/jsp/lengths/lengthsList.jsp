<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="lengths">

<h2>Find lengths</h2>
    <!-- Research sites by lengths -->
    <spring:url value="/lengths" var="formUrl"/>
    <form:form modelAttribute="length" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-length-form">
        <div class="form-group">
            <div class="control-group" id="name">
                <label class="col-sm-2 control-label">Code length </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="name" size="50" maxlength="50"/>                    
                    <span class="help-inline"><form:errors path="*"/></span>
                </div> 
        </div> </div>  
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find length</button>
            </div>
        </div>
    </form:form>
    <h2>sites</h2>

    <table id="lengthsTable" class="table table-striped">
        <thead>
        <tr>
        	<th style="width: 150px;">Name</th>  
            <th style="width: 150px;">Comment</th>
            <th style="width: 150px;">Cotation</th>
            <th style="width: 150px;">Length status</th> 
            <th style="width: 150px;">Under cotation</th>            
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="length">
            <tr>
                <td>
                    <spring:url value="/lengths/{lengthId}" var="lengthUrl">
                        <spring:param name="lengthId" value="${length.id} "/>                       
                    </spring:url>
                    <a href="${fn:escapeXml(lengthUrl)}">
                    <c:out value="${length.name}"/></a>
                </td>  
                 <td>
                     <c:out value="${length.comment} "/>
                </td> 
                 <td>
                     <c:out value="${length.cotation} "/>
                </td>
                 <td>
                     <c:out value="${length.length_status} "/>
                </td>
                 <td>
                     <c:out value="${length.under_cotation} "/>
                </td>
                <!--               
                 <td>
                     <c:forEach var="point" items="${length.points}">
                        <c:out value="${point.name} "/>
                    </c:forEach>
                </td>
                 --> 
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>