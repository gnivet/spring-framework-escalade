<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

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
    <form:form modelAttribute="topo" class="form-horizontal" id="add-topo-form">
        <div class="form-group has-feedback">
            			<escalade:inputField label="Name" name="name"/>
            			<escalade:inputField label="Birth Date" name="birthDate"/>           
                                    
                		<input type="hidden" name="id" value="${zone.id}" />                	
                    	<div class="col-sm-10">                        
                        	<escalade:inputField label="Zone" name="zone.name" />							
                   		 </div>                   		 
                   		 
                    	<input type="hidden" name="id" value="${way.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Way" name="way.name" />						
                   		 </div>
                   		 
                   		<input type="hidden" name="id" value="${part.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Part" name="part.name" />						
                   		 </div>
                   		 
                   	 	<input type="hidden" name="id" value="${length.id}" />					              	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Length" name="length.name" />						
                   		 </div>	
                   		 
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Cotation" name="length.cotation" />						
                   		 </div>	
                   		 
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Under Cotation" name="length.under_cotation" />
						 </div> 
						 
                   		  <div class="col-sm-10">
                        	<escalade:inputField label="Comment" name="length.comment" />
                   		 </div> 
                   		 <!-- 
                   		 <div class="col-sm-10">   
        				<form:radiobutton name= "length.length_status" path="length_status" value="false"  class="form-horizontal" label="length_status"/>						
                   		 </div>	     
                   		  -->          
                   		<div class="col-sm-10" class="form-horizontal"> 
                   		  <p>Below you can enabled/disabled length_status:</p><br />
        					<input type="radio" name= "length.length_status" value="false" id= "false" checked/><label for="false">disabled</label><br />
        					<input type="radio" name= "length.length_status" value="true" id="true" /><label for="true">enabled</label><br />
                   		 </div>	             
                   		           
                   		              		 
                   		 <input type="hidden" name="id" value="${point.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Point" name="point.name" />
                   		 </div>
                   		 
                   		 <input type="hidden" name="id" value="${area.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Area" name="area.name" />						
                   		 </div>
                   		 
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="GPS Coordinate" name="area.gpscoordinate" />
                   		 </div> 
                   		 
                   		  <div class="col-sm-10">
                        	<escalade:inputField label="Street" name="area.street" />						
                   		 </div> 
                   		 
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Postal Code" name="area.postalcode" />
						 </div>      
						  
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="City" name="area.city" />
                   		 </div>
                   		 
                   		  <div class="col-sm-10">
                        	<escalade:inputField label="Country" name="area.country" />
                   		 </div> 
                   		 
                   		 <!-- 
                   		  <input type="hidden" name="id" value="${topotype.id}" />    
                   		 	<div class="control-group">
                    			<escalade:selectField name="type" label="Type"
								names="${sitetypes}" size="5" />
                			</div>  
                   		 
                   		 	                 		 		 	 	 
               		 			<div class="control-group">
                    			<escalade:selectField name="type" label="Type"
								names="${types}" size="5" />
                			</div>  
                   		 	
                   		 	
                   		 	<label for="type">Type</label> : <input type="text" name="type" id="type" />
                   		   -->	
                   		 	<input type="hidden" name="id" value="${sitetype.id}" />  
                   		 	<div class="col-sm-10" class="form-horizontal">
       							<p>Please choose your topo type:</p><br />
      							 <input type="radio" name="type.name" value="cliff" id="cliff" /> <label for="cliff">cliff</label><br />
      							 <input type="radio" name="type.name" value="block" id="block" /> <label for="block">block</label><br />       
   							</div>
                   		 	
                   		 	
                   		   	<!--                		 		 	 	 
               		 		<div class="control-group">
                    			<escalade:selectField name="type" label="Type"
								names="${types}" size="5" />
                			</div>  
                   		 	 -->  
                   		 
                   		 <!-- 
                   		 
                   		  <div class="form-group">
        						<label class="col-sm-2 control-label">Type</label>
								<div class="col-sm-10">
          							<select id="type" name="type">
            							<option value="cliff">cliff</option>
            							<option value="block">block</option>            
          							</select>
         					 			<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>          
        						</div>
      					 </div>
        					
                   		  -->
                   		  <div class="col-sm-10"> 
                   		  <p>Below you can activate/cancel your topo:</p><br />  
        				<!--<form:radiobutton name= "topo.valid" path="valid" value="false" label="Valid"  class="form-horizontal"/>		-->
        					<input type="radio" name= "topo.valid" value="false" id= "false" checked/><label for="false">Not valid</label><br />
        					<input type="radio" name= "topo.valid" value="true" id="true" />		  <label for="true">valid</label><br />			
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