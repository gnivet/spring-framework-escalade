<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="lengths">
    <h2>    
        <c:if test="${length['new']}">New </c:if> length       
    </h2>
    <form:form modelAttribute="length" class="form-horizontal" id="add-length-form">
        <div class="form-group has-feedback">
            			<escalade:inputField label="Name" name="name"/> 
                		<input type="hidden" name="id" value="${length.id}" />                	
                    	<div class="col-sm-10">                        
                        	<escalade:inputField label="Length" name="length.name" />							
                   		 </div>   	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Comment" name="comment.name" />						
                   		 </div>
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Cotation" name="comment.cotation" />						
                   		 </div>
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Status" name="comment.length_status" />						
                   		 </div>
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Under cotation" name="comment.under_cotation" />						
                   		 </div>
                   		 <input type="hidden" name="id" value="${way.id}" /> 
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${length['new']}">
                        <button class="btn btn-default" type="submit">Add length</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update length</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
</escalade:layout>