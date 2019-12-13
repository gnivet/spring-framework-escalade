<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>

<escalade:layout pageName="users">
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
            <!-- <c:if test="${topo['new']}">New </c:if> -->
        </h2>
        <form:form modelAttribute="topo" class="form-horizontal">
            <input type="hidden" name="id" value="${topo.id}" />
            <div class="form-group has-feedback">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Topo</label>
                    <div class="col-sm-10">
                       <!-- <c:out value="${topo.user.firstName} ${topo.user.lastName}"/> -->
                       <c:out value="${topo.name}" /> 
                    </div>
                </div>
                	<escalade:inputField label="Name" name="name" />
                	<escalade:inputField label="Birth Date"
					name="birthDate" />
                		<input type="hidden" name="id" value="${zone.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Zone"
						name="zone.name" />
                   		 </div>
                    	<input type="hidden" name="id" value="${way.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Way"
						name="way.name" />
                   		 </div>
                   		<input type="hidden" name="id" value="${part.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Part"
						name="part.name" />
                   		 </div>
                   	 	<input type="hidden" name="id"
					value="${length.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Length"
						name="length.name" />
                   		 </div>	
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Cotation"
						name="length.cotation" />
                   		 </div>	
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Under Cotation"
						name="length.under_cotation" />
                   		 </div> 
                   		  <div class="col-sm-10">
                        	<escalade:inputField label="Comment"
						name="length.comment" />
                   		 </div> 
                   		 <div class="col-sm-10">   
        				<form:radiobutton name= "length.length_status" path="length_status" value="true" label="length_status"/>						
                   		 </div>	                  		 
                   		 <input type="hidden" name="id" value="${point.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Point"
						name="point.name" />
                   		 </div>
                   		 <input type="hidden" name="id" value="${area.id}" />                	
                    	<div class="col-sm-10">
                        	<escalade:inputField label="Area"
						name="area.name" />
                   		 </div>
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="GPS Coordinate"
						name="area.gpscoordinate" />
                   		 </div> 
                   		  <div class="col-sm-10">
                        	<escalade:inputField label="Street"
						name="area.street" />
                   		 </div> 
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="Postal Code"
						name="area.postalcode" />
                   		 </div>       
                   		 <div class="col-sm-10">
                        	<escalade:inputField label="City"
						name="area.city" />
                   		 </div>
                   		  <div class="col-sm-10">
                        	<escalade:inputField label="Country"
						name="area.country" />
                   		 </div> 
                   		  <div class="col-sm-10">   
        				<form:radiobutton name= "topo.valid" path="valid" value="true" label="Valid"/>						
                   		 </div>	         		 	                 		 		 	 	 
               		 	<div class="control-group">
                    		<escalade:selectField name="type" label="Type"
							names="${types}" size="5" />
                		</div>  
            	</div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${topo['new']}">
                            <button class="btn btn-default"
								type="submit">Add topo</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default"
								type="submit">Update topo</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
   <!--       <c:if test="${!topo['new']}"> 
        </c:if> -->
    </jsp:body>
</escalade:layout>
