<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="Sites">

	<h2>Site details</h2>

	<table class="table table-striped">
		<tr>
			<th>Site</th>
			<td><b><c:out value="${sites.name} " /></b></td>
			<th>Site</th>			
			<th> User</th>
			<td><c:out value="${users.userId}" /></td>		
			<td><b><c:out value="${users.username} " /></b></td>
			<th>Birth date</th>	
			<th><escalade:localDate date="${sites.birth_date}" pattern="yyyy/MM/dd"/></th>		
		</tr>		
	</table>
</escalade:layout>
