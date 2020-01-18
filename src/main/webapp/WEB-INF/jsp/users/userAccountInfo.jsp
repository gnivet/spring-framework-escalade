<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="user">

    <h2>User Information</h2>


    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${User.user_name}"/></b></td>
        </tr>
        
        <tr>
            <th>Password</th>
            <td><c:out value="${User.encryted_password}"/></td>
        </tr> 
        
    </table>

    <spring:url value="{user_id}/edit" var="editUrl">
        <spring:param name="userId" value="${User.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit user</a>
    
      
</escalade:layout>
