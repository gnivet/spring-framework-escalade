<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="users">

    <h2>Find Users</h2>

    <spring:url value="/users" var="formUrl"/>
    <form:form modelAttribute="user" action="${fn:escapeXml(formUrl)}" method="get" class="form-horizontal"
               id="search-user-form">
        <div class="form-group">
            <div class="control-group" id="userName">
                <label class="col-sm-2 control-label">Last name </label>
                <div class="col-sm-10">
                    <form:input class="form-control" path="userName" size="30" maxlength="80"/>
                    <span class="help-inline"><form:errors path="*"/></span>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Find User</button>
            </div>
        </div>
		<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
		<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
    </form:form>

    <br/>
    <a class="btn btn-default" href='<spring:url value="/users/new" htmlEscape="true"/>'>Add User</a>
</escalade:layout>
