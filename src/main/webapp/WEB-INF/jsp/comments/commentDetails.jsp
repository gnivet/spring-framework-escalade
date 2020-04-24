<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="comments">
	<h2>Comment details</h2>
	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<td><b><c:out value="${comment.name} " /></b></td>
		</tr>
		<tr>
			<th>Comment date</th>
			<td><c:out value="${comment.date}" /></td>
		</tr>
		<tr>
			<th>Comment</th>
			<td><c:out value="${comment.comment}" /></td>
		</tr>
	</table>
</escalade:layout>
