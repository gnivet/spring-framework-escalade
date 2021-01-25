<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="sites">

    <h2>Site Information</h2>


    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${site.name}"/></b></td>
        </tr>
        <tr>
            <th>Birth date</th>
            <td><c:out value="${site.birthDate}"/></td>
        </tr>        
    </table>

    <spring:url value="/areas/{areaId}" var="editUrl">
        <spring:param name="areaId" value="${area.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit Site</a>

    <spring:url value="{siteId}/zones/new" var="addUrl">
        <spring:param name="siteId" value="${site.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New Zone</a>

    <br/>
    <br/>
    <br/>
    <h2>Sites and Visits</h2>

    <table class="table table-striped">
        <c:forEach var="site" items="${user.sites}">

            <tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt>Name</dt>
                        <dd><c:out value="${site.name}"/></dd>
                        <dt>Birth Date</dt>
                        <dd><escalade:localDate date="${site.birthDate}" pattern="yyyy-MM-dd"/></dd>
                        <dt>Type</dt>
                        <dd><c:out value="${site.type.name}"/></dd>
                    </dl>
                </td>
                <td valign="top">
                    <table class="table-condensed">
                        <thead>
                        <tr>
                            <th>Visit Date</th>
                            <th>Description</th>
                        </tr>
                        </thead>
                        <c:forEach var="visit" items="${site.visits}">
                            <tr>
                                <td><escalade:localDate date="${visit.date}" pattern="yyyy-MM-dd"/></td>
                                <td><c:out value="${visit.description}"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>
                                <spring:url value="/users/{userId}/sites/{siteId}" var="siteUrl">
                                    <spring:param name="userId" value="${user.id}"/>
                                    <spring:param name="siteId" value="${site.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(petUrl)}">Edit Site</a>
                            </td>
                            <td>
                                <spring:url value="/users/{userId}/sites/{siteId}/visits/new" var="visitUrl">
                                    <spring:param name="userId" value="${user.id}"/>
                                    <spring:param name="siteId" value="${site.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(visitUrl)}">Add Visit</a>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

        </c:forEach>
    </table>

</escalade:layout>
