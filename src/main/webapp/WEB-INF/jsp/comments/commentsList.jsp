<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="comments">

<h2>Find comments</h2>
    <!-- Research comments by comments -->
    <spring:url value="/comments" var="formUrl"/>
    <form:form modelAttribute="comment" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-comment-form">
        <div class="form-group">
            <div class="control-group" id="name">
                <label class="col-sm-2 control-label">Code comment </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="name" size="5" maxlength="5"/>                    
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>               
             
        </div> </div>  
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find comment</button>
            </div>
        </div>
    </form:form>
    <h2>comments</h2>

    <table id="commentsTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>  
            <th style="width: 150px;">Date</th>         
            <th style="width: 200px;">Comment</th>            
            <th style="width: 200px;">Site</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="comment">
            <tr>
                <td>
                    <spring:url value="/comments/{commentId}" var="commentUrl">
                        <spring:param name="commentId" value="${comment.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(commentUrl)}"><c:out value="${comment.name}"/></a>
                </td>
                <td>
                    <c:out value="${comment.date}"/>
                </td>               
                 <td>
                    <c:out value="${comment.comment}"/>
                </td>
                 <td>
                    <c:out value="${comment.site.name}"/>
                </td>
                
                <!--                
                <td>
                    <c:forEach var="comment" items="${user.comments}">
                        <c:out value="${comment.name} "/>
                    </c:forEach>
                </td> --> 
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>