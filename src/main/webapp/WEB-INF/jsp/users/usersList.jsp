<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="users">
    <h2>users</h2>

    <table id="usersTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>
            <th style="width: 200px;">Email</th>
            <th style="width: 200px;">Address</th>
            <th style="width: 200px;">Postal code</th>
            <th>City</th>
            <th style="width: 120px">Telephone</th>
            <th style="width: 80px">User name</th>
            <th style="width: 80px">Password</th>            
            <th>Topos</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="user">
            <tr>
                <td>
                    <spring:url value="/users/{userId}" var="userUrl">
                        <spring:param name="userId" value="${user.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(userUrl)}"><c:out value="${user.firstName} ${user.lastName}"/></a>
                </td>
                <td>
                    <c:out value="${user.firstEmail}"/>
                </td>
                <td>
                    <c:out value="${user.address}"/>
                </td>
                <td>
                    <c:out value="${user.postalcode}"/>
                </td>
                <td>
                    <c:out value="${user.city}"/>
                </td>
                <td>
                    <c:out value="${user.telephone}"/>
                </td>
                 <td>
                    <c:out value="${user.firstusername}"/>
                </td>
                 <td>
                    <c:out value="${user.firstPassword}"/>
                </td>
                <td>
                    <c:forEach var="topo" items="${user.topos}">
                        <c:out value="${topo.name} "/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>
