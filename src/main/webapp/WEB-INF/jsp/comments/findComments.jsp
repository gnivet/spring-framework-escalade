<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
	
<escalade:layout pageName="comments">

    <h2>Find Sites</h2>
    <!-- Research topos by comments -->
    <spring:url value="/comments" var="formUrl"/>
    <form:form modelAttribute="comment" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-comment-form">
        <div class="form-group">
            <div class="control-group" id="postalcode">
                <label class="col-sm-2 control-label">Code comment </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="name" size="50" maxlength="50"/>                    
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>               
             
        </div> </div>  
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find site</button>
            </div>            
        </div>

    </form:form>

    
     <a class="btn btn-default" href='<spring:url value="/comments/new/" htmlEscape="true"/>'>Add comment</a> 
    
</escalade:layout>