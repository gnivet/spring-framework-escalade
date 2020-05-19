<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="topoBkgs">
	<h2>Topo booking details</h2>
	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<td><b><c:out value="${topoBkg.name} " /></b></td>
		</tr>
		<tr>
			<th>Accepted</th>
			<td><c:out value="${topoBkg.accepted}" /></td>
		</tr>
		
		<tr>
			<th>Borrow date</th>
			<td><c:out value="${topoBkg.borrow_date}" /></td>
		</tr>
		<tr>
			<th>Borrow end date</th>
			<td><c:out value="${topoBkg.borrow_end_date}" /></td>
		</tr>
	
		<tr>
			<th>In progress</th>
			<td><c:out value="${topoBkg.in_progress}" /></td>
		</tr>					
	</table>
	<spring:url value="/topos/{topoId}/topoBkgs" var="editUrl">
        <spring:param name="topoId" value="${topo.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit topo booking</a>
    
    <h2>Topos and Bookings</h2>

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
