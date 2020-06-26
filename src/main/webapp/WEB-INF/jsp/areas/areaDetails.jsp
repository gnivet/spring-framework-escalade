<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="areas">

	<h2>Site details</h2>

	<table class="table table-striped">
		<tr>
			<th>Name</th>
			<td><b><c:out value="${area.name} " /></b></td>
		</tr>
		<tr>
			<th>Address</th>
			<td><c:out value="${area.street}" /></td>
		</tr>
		<tr>
			<th>Postal code</th>
			<td><c:out value="${area.postalcode}" /></td>
		</tr>
		<tr>
			<th>City</th>
			<td><c:out value="${area.city}" /></td>
		</tr>
		<tr>
			<th>Country</th>
			<td><c:out value="${area.country}" /></td>
		</tr>
		<tr>
			<th>GPS Coordinate</th>
			<td><c:out value="${area.gpscoordinate}" /></td>
		</tr>
		<tr>
			<th>Birth Date</th>
			<td><c:out value="${area.Site.birthDate}" /></td>
		</tr>

		<tr>
			<th>Type</th>
			<td><c:out value="${area.Site.type.name}" /></td>
		</tr>
		<tr>
			<Th>Zone</Th>
			<td><c:out value="${area.Site.zone.name}" /></td>
		</tr>
		<tr>
			<Th>Way</Th>
			<td><c:out value="${area.Site.way.name}" /></td>
		</tr>
		
		<tr>
			<Th>Length</Th>
			<td><c:out value="${area.Site.length.name}" /></td>
		</tr>
		<tr>
			<Th>Cotation</Th>
			<td><c:out value="${area.Site.length.cotation}" /></td>
		</tr>
		<tr>
			<Th>Under cotation</Th>
			<td><c:out value="${area.Site.length.under_cotation}" /></td>
		</tr>
		<tr>
			<Th>Comment</Th>
			<td><c:out value="${area.Site.length.comment}" /></td>
		</tr>
		<tr>
			<Th>Length Status</Th>
			<td><c:out value="${area.Site.length.length_status}" /></td>
		</tr>
		<tr>
			<Th>Point</Th>
			<td><c:out value="${area.Site.point.name}" /></td>
		</tr>

	</table>
</escalade:layout>
