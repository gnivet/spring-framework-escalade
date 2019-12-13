<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>
<escalade:layout pageName="topos">

	<h2>Topo details</h2>

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
			<td><c:out value="${area.topo.birthDate}" /></td>
		</tr>

		<tr>
			<th>Type</th>
			<td><c:out value="${area.topo.type.name}" /></td>
		</tr>
		<tr>
			<Th>Zone</Th>
			<td><c:out value="${area.topo.zone.name}" /></td>
		</tr>
		<tr>
			<Th>Way</Th>
			<td><c:out value="${area.topo.way.name}" /></td>
		</tr>
		<tr>
			<Th>Part</Th>
			<td><c:out value="${area.topo.part.name}" /></td>
		</tr>		
		<tr>
			<Th>Length</Th>
			<td><c:out value="${area.topo.length.name}" /></td>
		</tr>
		<tr>
			<Th>Cotation</Th>
			<td><c:out value="${area.topo.length.cotation}" /></td>
		</tr>
		<tr>
			<Th>Under cotation</Th>
			<td><c:out value="${area.topo.length.under_cotation}" /></td>
		</tr>
		<tr>
			<Th>Comment</Th>
			<td><c:out value="${area.topo.length.comment}" /></td>
		</tr>
		<tr>
			<Th>Length Status</Th>
			<td><c:out value="${area.topo.length.length_status}" /></td>
		</tr>
		<tr>
			<Th>Point</Th>
			<td><c:out value="${area.topo.point.name}" /></td>
		</tr>

	</table>
</escalade:layout>
