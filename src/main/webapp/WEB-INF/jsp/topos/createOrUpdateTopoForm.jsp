<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="topos">
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
        <c:if test="${topo['new']}">New </c:if> Topo
    </h2>
    <p>Current User: ${firstName} ${blanck}  ${lastName}</p>  
    <form:form modelAttribute="topo" class="form-horizontal"
			id="add-topo-form">			 
        <div class="form-group has-feedback">
            				<escalade:inputField label="Name" name="name" />                    	   	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Description" name="description" />												
                   		 </div>                   		      
                   		<div class="col-sm-10" class="form-horizontal"> 
                   		  <p>Below you can enabled/disabled available status:</p>
					<br />
						
        					<input type="radio" name="available" value="false"
						id="false" checked /><label for="false">disabled</label><br />
        					<input type="radio" name="available" value="true" id="true" /><label
						for="true">enabled</label><br />
                   		 </div>
          <div class="col-sm-10" class="form-horizontal" topo ="hidden">
       							<p>Please choose your topo type:</p>
					<br />
      							 <input type="radio" name="type.name" value="cliff"
						id="cliff" /> <label for="cliff">cliff</label><br />
      							 <input type="radio" name="type.name" value="block"
						id="block" /> <label for="block">block</label><br />       
   		</div>  		  
      	</div>
   <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${topo['new']}">
                        <button class="btn btn-default" type="submit">Add Topo</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update Topo</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>
 </jsp:body>
</escalade:layout>