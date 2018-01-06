<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>HR Portal</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

<jsp:include page="custbanner.jsp"/>

<div class="container">

    <h1>Hello, ${customerFirstName}</h1>
    <br/>
    <div class="starter-template">
        <h2>Congradulations! You have <b>${customer.points}</b> points!</h2>
    </div>

    <h3>Here are a few offers where you could redeem your points!</h3>

    <table class="table table-bordered table-responsive">
        <tr>
            <th>Name</th>
            <th>Description</th>
            <th>Type</th>
            <th>Discount</th>
            <th>Points</th>
            <th></th>
        </tr>
        <c:forEach items="${availOffers}" var="currentDataSetObj">
            <tr>
                <td><c:out value="${currentDataSetObj.name}"/></td>
                <td><c:out value="${currentDataSetObj.description}"/></td>
                <td><c:out value="${currentDataSetObj.type}"/></td>
                <td><c:out value="${currentDataSetObj.discount}"/></td>
                <td><c:out value="${currentDataSetObj.points}"/></td>
                <td>
                    <button class="button" name="itemId" value="${currentDataSetObj.id}"><b>Redeem</b></button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>