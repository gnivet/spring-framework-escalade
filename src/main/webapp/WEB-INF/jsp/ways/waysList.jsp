<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="ways">
    <h2>ways</h2>
    <table id="waysTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>          
            <th>Ways</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="way">
            <tr>
                <td>
                    <spring:url value="/ways/{wayId}.html" var="wayUrl">
                        <spring:param name="wayId" value="${way.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(wayUrl)}"><c:out value="${way.name} "/></a>
                </td>                               
                <td>
                    <c:forEach var="way" items="${way.ways}">
                        <c:out value="${way.name} "/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>
