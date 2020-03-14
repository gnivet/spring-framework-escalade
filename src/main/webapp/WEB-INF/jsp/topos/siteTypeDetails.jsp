<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<escalade:layout pageName="SiteTypes">
	<h2>Site details</h2>
	<table class="table table-striped">
		<tr>
			<th>Type</th>
			<td><b><c:out value="${sitetypes.name} " /></b></td>
		</tr>
	</table>	
      <a class="btn btn-default" href='<spring:url value="/zones/new" htmlEscape="true"/>'>Add zone</a> 
</escalade:layout>
