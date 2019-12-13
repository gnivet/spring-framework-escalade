<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="escalade" tagdir="/WEB-INF/tags" %>

<%@ attribute name="pageName" required="true" %>
<%@ attribute name="customScript" required="false" fragment="true"%>

<!doctype html>
<html>
<escalade:htmlHeader/>

<body>
<escalade:bodyHeader menuName="${pageName}"/>

<div class="container-fluid">
    <div class="container xd-container">

        <jsp:doBody/>

        <escalade:pivotal/>
    </div>
</div>
<escalade:footer/>
<jsp:invoke fragment="customScript" />

</body>

</html>
