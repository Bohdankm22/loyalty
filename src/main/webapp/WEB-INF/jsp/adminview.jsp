<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>HR Portal</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

<jsp:include page="adminbanner.jsp"/>

<div class="container">

    <div class="starter-template">
        <h1>This is a admin view</h1>
    </div>

    <h3>Here is a list of all users:</h3>

    <table class="table table-bordered table-responsive">
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Role</th>
            <th></th>
        </tr>
        <c:forEach items="${users}" var="currentDataSetObj">
            <tr>
                <td><c:out value="${currentDataSetObj.name}"/></td>
                <td><c:out value="${currentDataSetObj.surname}"/></td>
                <td><c:out value="${currentDataSetObj.userRole}"/></td>
                <td>
                    <button class="button" name="itemId" value="${currentDataSetObj.id}"><b>Redeem</b></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>

</html>