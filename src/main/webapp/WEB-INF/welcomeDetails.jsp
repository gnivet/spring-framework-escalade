<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="appUser">
	<h2>Login Information</h2>
	<table class="table table-striped">
		<tr>
			<th>Welcome Details</th>
			<td><b><c:out value="${title} ${message}}" /></b></td>
			<td><b><c:out value="${appUser.email} ${appUser.password}" /></b></td>
		</tr>
	</table>
</escalade:layout>