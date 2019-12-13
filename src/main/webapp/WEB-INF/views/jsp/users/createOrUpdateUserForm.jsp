<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>

<escalade:layout pageName="users">
    <h2>
        <c:if test="${user['new']}">New </c:if> User
    </h2>
    <form:form modelAttribute="user" class="form-horizontal" id="add-user-form">
        <div class="form-group has-feedback">
            <escalade:inputField label="First Name" name="firstName"/>
            <escalade:inputField label="Last Name" name="lastName"/>
            <escalade:inputField label="Email" name="firstEmail"/> 
            <escalade:inputField label="Address" name="address"/>
            <escalade:inputField label="Postal code" name="postalcode"/>
            <escalade:inputField label="City" name="city"/>
            <escalade:inputField label="Telephone" name="telephone"/> 
            <escalade:inputField label="Password" name="firstPassword"/>  
            <escalade:inputField label="Username" name="firstUsername"/>          
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${user['new']}">
                        <button class="btn btn-default" type="submit">Add User</button>
                    </c:when>
                    <c:otherwise>
                        <button class="btn btn-default" type="submit">Update User</button>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </form:form>   
</escalade:layout>
