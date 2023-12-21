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
        <c:if test="${topoBkg['new']}">New </c:if> Topo bookings
    </h2>   
    <form:form modelAttribute="topoBkg" class="form-horizontal"
			id="add-topoBkg-form">	
			      				
        	<div class="form-group has-feedback">            		 	          		 	 
                   		  <escalade:inputField label="Borrow Date"
					name="borrowDate" />
                   		 <escalade:inputField label="Borrow End Date"
					name="borrowEndDate" />
                   		 <escalade:inputField label="In Progress"
					name="inProgress" />					
					    <escalade:inputField label="Accepted"  
					name="accepted" /> 
					<!--  				
					<c:if test="${topoBkg.accepted == true}"><a href="${fn:escapeXml(topoBkgUrl)}"><c:out value="${topoBkg.accepted}" /></a></c:if>
						<c:if test="${topoBkg.accepted == false}"><c:out value="${topoBkg.accepted}" /></c:if>
					-->               		 
        	</div>        		
        	<div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${topoBkg['new']}">
                        <button class="btn btn-default" type="submit">Valid</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update topo booking</button>
                         <a class="btn btn-default" href='<spring:url value="/topoBkgs/${topoBkg.id}/" htmlEscape="true"/>'>Add site</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>       
    </form:form>
 </jsp:body>
</escalade:layout>