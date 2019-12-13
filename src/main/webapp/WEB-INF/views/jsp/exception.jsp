<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<escalade:layout pageName="error">

    <spring:url value="/resources/images/topos.png" var="toposImage"/>
    <img src="${toposImage}"/>

    <h2>Something happened...</h2>

    <p>${exception.message}</p>

</escalade:layout>
