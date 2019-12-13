<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="users">

    <h2>user Information</h2>


    <table class="table table-striped">
        <tr>
            <th>Name</th>
            <td><b><c:out value="${user.firstName} ${user.lastName}"/></b></td>
        </tr>
        
        <tr>
            <th>Email</th>
            <td><c:out value="${user.firstEmail}"/></td>
        </tr> 
        <tr>
            <th>Address</th>
            <td><c:out value="${user.address}"/></td>
        </tr>
        <tr>
            <th>Postal code</th>
            <td><c:out value="${user.postalcode}"/></td>
        </tr>
        <tr>
            <th>City</th>
            <td><c:out value="${user.city}"/></td>
        </tr>
        <tr>
            <th>Telephone</th>
            <td><c:out value="${user.telephone}"/></td>
        </tr> 
         <tr>
            <th>user name</th>
            <td><c:out value="${user.firstUsername}"/></td>
        </tr> 
        <tr>
            <th>Password</th>
            <td><c:out value="${user.firstPassword}"/></td>
        </tr> 
    </table>
		
    <spring:url value="/users/{userId}/edit" var="editUrl">
        <spring:param name="userId" value="${user.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(editUrl)}" class="btn btn-default">Edit user</a>
    
    
    <spring:url value="/users/{userId}/topos/new" var="addUrl">
        <spring:param name="userId" value="${user.id}"/>
    </spring:url>
    <a href="${fn:escapeXml(addUrl)}" class="btn btn-default">Add New topo</a>

    <br/>
    <br/>
    <br/>
    <h2>topos and Visits</h2>

    <table class="table table-striped">      
        <c:forEach var="topo" items="${user.topos}">
            <tr>
                <td valign="top">
                    <dl class="dl-horizontal">
                        <dt><b>Name</b></dt>
                        <dd><c:out value="${topo.name}"/></dd>
                        <dt><b>Birth Date</b></dt>
                        <dd><escalade:localDate date="${topo.birthDate}" pattern="yyyy-MM-dd"/></dd>
                        <dt><b>Type</b></dt>
                        <dd><c:out value="${topo.type.name}"/></dd>
                        <dt><b>Area</b></dt>
                        <dd><c:out value="${topo.area.name}"/></dd>
                        <dt><b>GPS Coordinate</b></dt>
                        <dd><c:out value="${topo.area.gpscoordinate}"/></dd>                           
                        <dt><b>Street</b></dt>
                        <dd><c:out value="${topo.area.street}"/></dd>
                        <dt><b>Postal Code</b></dt>
                        <dd><c:out value="${topo.area.postalcode}"/></dd>
                        <dt><b>City</b></dt>
                        <dd><c:out value="${topo.area.city}"/></dd>
                        <dt><b>Country</b></dt>
                        <dd><c:out value="${topo.area.country}"/></dd>
                        <dt><b>Point</b></dt>
                        <dd><c:out value="${topo.point.name}"/></dd>
                        <dt><b>Length</b></dt>
                        <dd><c:out value="${topo.length.name}"/></dd>
                        <dt><b>Cotation</b></dt>
                        <dd><c:out value="${topo.length.cotation}"/></dd>
                        <dt><b>Under cotation</b></dt>
                        <dd><c:out value="${topo.length.under_cotation}"/></dd>
                        <dt><b>Comment</b></dt>
                        <dd><c:out value="${topo.length.comment}"/></dd>
                        <dt><b>Length Statut</b></dt>
                        <dd><c:out value="${topo.length.length_status}"/></dd>
                        <dt><b>Part</b></dt>
                        <dd><c:out value="${topo.part.name}"/></dd>
                        <dt><b>Way</b></dt>
                        <dd><c:out value="${topo.way.name}"/></dd>
                        <dt><b>Zone</b></dt>
                        <dd><c:out value="${topo.zone.name}"/></dd>
                        <dt><b>Topo Valid</b></dt>
                        <dd><c:out value="${topo.valid}"/></dd>
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
                        <c:forEach var="visit" items="${topo.visits}">
                            <tr>
                                <td><escalade:localDate date="${visit.date}" pattern="yyyy-MM-dd"/></td>
                                <td><c:out value="${visit.description}"/></td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>
                                <spring:url value="/users/{userId}/topos/{topoId}/edit" var="topoUrl">
                                    <spring:param name="userId" value="${user.id}"/>
                                    <spring:param name="topoId" value="${topo.id}"/>
                                </spring:url>
                                <a href="${fn:escapeXml(topoUrl)}">Edit topo</a>
                            </td>
                            
                            <td>
                                <spring:url value="/users/{userId}/topos/{topoId}/visits/new" var="visitUrl">
                                    <spring:param name="userId" value="${user.id}"/>
                                    <spring:param name="topoId" value="${topo.id}"/>
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
