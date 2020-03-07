<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="SiteTypes">

	<h2>Site details</h2>

	<table class="table table-striped">
		<tr>
			<th>Type</th>
			<td><b><c:out value="${sitetypes.name} " /></b></td>
		</tr>
	</table>
</escalade:layout>
