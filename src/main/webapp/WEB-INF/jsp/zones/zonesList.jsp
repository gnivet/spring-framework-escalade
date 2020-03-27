<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="zones">
    <h2>zones</h2>
    <table id="zonesTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;">Name</th>          
            <th>Ways</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${selections}" var="zone">
            <tr>
                <td>
                    <spring:url value="/zones/{zoneId}.html" var="zoneUrl">
                        <spring:param name="zoneId" value="${zone.id}"/>
                    </spring:url>
                    <a href="${fn:escapeXml(zoneUrl)}"><c:out value="${zone.name} "/></a>
                </td>                               
                <td>
                    <c:forEach var="way" items="${zone.ways}">
                        <c:out value="${way.name} "/>
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</escalade:layout>
