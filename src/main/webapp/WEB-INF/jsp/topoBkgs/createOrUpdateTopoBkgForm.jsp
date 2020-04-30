<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="topoBkgs">
	<jsp:attribute name="customScript">
        <script>
									$(function() {
										$("#borrowDate").datepicker({
											dateFormat : 'yy/mm/dd'
										});
									});
								</script>
		<script>
									$(function() {
										$("#borrowEndDate").datepicker({
											dateFormat : 'yy/mm/dd'
										});
									});
								</script>						
								
    </jsp:attribute>
	<jsp:body>
    <h2>    
        <c:if test="${topoBkg['new']}">New </c:if> topoBkg
    </h2>
    <form:form modelAttribute="topoBkg" class="form-horizontal"
			id="add-topoBkg-form">
        	<div class="form-group has-feedback">
            			<escalade:inputField label="Name" name="name" />   
            		 	                 		
                   		 <escalade:inputField label="Borrow Date"
					name="borrowDate" /> 	
                   		 <escalade:inputField label="Borrow End Date"
					name="borrowEndDate" /> 
                   		 <escalade:inputField label="In Progress"
					name="inProgress" />      
					
                   		  <p>Below you can enabled/disabled accepted status:</p>
							<br />
        					<input type="radio" name="accepted" value="false"
					id="false" checked />
							<label for="false">disabled</label><br />
        					<input type="radio" name="accepted" value="true" id="true" />
        					<label for="true">enabled</label><br />								
        	</div>           		
        	<div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${topoBkg['new']}">
                        <button class="btn btn-default" type="submit">Add topoBkg</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update topoBkg</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
 </jsp:body>
</escalade:layout>