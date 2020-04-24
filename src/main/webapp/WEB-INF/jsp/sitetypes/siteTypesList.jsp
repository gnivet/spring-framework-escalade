<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>
<escalade:layout pageName="siteTypes">
	<h2>Find site's type</h2>
	<!-- Research sites by site's types -->
	<spring:url value="/sitetypes" var="formUrl"/>
	<form:form modelAttribute="siteType" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal" id="search-siteType-form">
			<div class="form-group">
			<div class="control-group" id="name">
				<label class="col-sm-2 control-label">Code site's type </label>
				<div class="col-sm-10">
					<form:input class="form-control" path="name" size="50" maxlength="50"/>
					<span class="help-inline"><form:errors path="*"/></span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Find type</button>					
			</div>
		</div>
	</form:form>
	<h2>site's type</h2>	
	<table id="siteTypesTable"  class="table table-striped">
		<thead>
			<tr>
				<th style="width: 20px;">Name</th>
			</tr>
		</thead>
		<tbody>			
			<c:forEach items="${selections}" var="sitetype">
				<tr>
					<td class="myBlackcolor"><spring:url value="/siteTypes/{siteTypeId}"
							var="sitetypeUrl">
							<spring:param name="siteTypeId" value="${siteType.id} "/>
						</spring:url> <a href="${fn:escapeXml(areaUrl)}" class="myBlackcolor" >
						<c:out value="${siteType.name}"/></a></td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
</escalade:layout>

