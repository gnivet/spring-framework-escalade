<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="types">
	<h2>Site type details</h2>
	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<td><b><c:out value="${siteType.name} " /></b></td>
		</tr>		
	</table>             
     <td>               
	 <spring:url value="sitetypes/{siteTypeId}" var="editUrl">
        <spring:param name="siteTypeId" value="${siteType.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}"> <c:out value="${siteType.id}"/></a>
	</td>    
</escalade:layout>