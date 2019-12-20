<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags"%>

<escalade:layout pageName="app_user">
    <h2>
        <c:if test="${app_user['new']}">New </c:if> User
    </h2>
    <form:form modelAttribute="AppUser" class="form-horizontal" id="add-app_user-form">
        <div class="form-group has-feedback">
        	<input type="hidden" name="id" value="${app_user.user_id}" /> 
            <escalade:inputField label="User Name" name="user_name"/>
            <escalade:inputField label="Password" name="encryted_password "/>
            <input type="hidden" name="id" value="${app_user.enabled}" /> 
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <c:choose>
                    <c:when test="${app_user['new']}">
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
