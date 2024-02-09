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
    <form:form modelAttribute="site"  class="form-horizontal"
			id="add-site-form">				
	
         
        <div class="form-group has-feedback">
			<escalade:inputField label="Name" name="name" />
			<escalade:inputField label="Birthdate" name="birthDate" />
			<%--<escalade:inputField label="Site type" name="type" /> --%>
			
			
		</div>	
		<p>
        <label for="sitetypes">Type de site</label><br>
        <select name="sitetypes" id="sitetypes">
            <option value="Roche" selected>Roches</option>
            <option value="Falaise">Falaise</option>            
        </select>
    	</p>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${site['new']}">
                        <button class="btn btn-default" type="submit">Add Site</button>
                    </c:when>
                    <c:otherwise>
                        <!-- <button class="btn btn-default" type="submit">Update Site</button> -->
                         <a class="btn btn-default"
								href='<spring:url value="/sites/${site.id}/zones/new" htmlEscape="true"/>'>Add zone</a>
                          <a class="btn btn-default"
								href='<spring:url value="/sites/${site.id}/comments/new/" htmlEscape="true"/>'>Add comment</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>      
    </form:form>
 </jsp:body>
</escalade:layout>