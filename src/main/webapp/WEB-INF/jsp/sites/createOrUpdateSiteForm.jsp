<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="sites">
	<jsp:attribute name="customScript">
        <script>
									$(function() {
										$("#birthDate").datepicker({
											dateFormat : 'yy/mm/dd'
										});
									});
								</script>
    </jsp:attribute>
	<jsp:body>
    <h2>    
        <c:if test="${site['new']}">New </c:if> Site        
    </h2>
    <form:form modelAttribute="site" class="form-horizontal"
			id="add-site-form">		
		<table>
		<tr>
			<th scope="col"> User</th>
			
			<td><input type= "text" name="name" value="${user.username}" disabled/></td>
		</tr>
		</table>
		<br>
        <div class="form-group has-feedback">
        <br>      				
            			<escalade:inputField label="Name" name="name" />
            			<escalade:inputField label="Birth Date" name="birthDate" /> 
            			  
            			<input type="hidden" name="id" value="${user.id}" />       
            			<input type="hidden" name="id" value="${site.id}" />            			     
            	            		  	                 	 
					<div class="col-sm-10"> 
                   		  <p>Area's site</p>
							<br />							 
						 	<input type= "text"  name="name" value = "${area.name}" disabled/>
             		</div> 
             		<div class="col-sm-10"> 
                   		  <p>Choose your site's type</p>
							<br />
						<!--  <input type="hidden" name="id" value="${sitetype.id}" />   -->				
						<select name='sitetype'>     
							<c:forEach items="${sitetypes}" var="sitetype"> 
							    <option value="${sitetype}">${sitetype.name}
								</option>
							</c:forEach>
						 </select> <br />                  		 
             		</div>             		
            <div class="col-sm-10"> 
                   		  <p>Below you can activate/cancel your site:</p>
					<br />					     									
        					<input type="radio" name="site.valid" value="false"
						id="false" checked /><label for="false">Not valid</label><br />
        					 <input type="radio" name="site.valid" value="true"
						id="true" />		  <label for="true">Valid</label><br />	
			</div>				
			 <br />
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${site['new']}">
                        <button class="btn btn-default" type="submit">Add Site</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Site</button>
                         <a class="btn btn-default"
								href='<spring:url value="/sites/${site.id}/zones/new/" htmlEscape="true"/>'>Add zone</a>
                          <a class="btn btn-default"
								href='<spring:url value="/sites/${site.id}/comments/new/" htmlEscape="true"/>'>Add comment</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>      
    </form:form>
 </jsp:body>
</escalade:layout>