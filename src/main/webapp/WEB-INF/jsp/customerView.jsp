<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>About Loyalty</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>
</head>
<body>

    <jsp:include page="custbanner.jsp" />

    <div class="container">

        <h1>Hello, ${customerFirstName}</h1>
        <br/>
        <div class="starter-template">
            <h2>Congradulations! You have <b>${customer.points}</b> points!</h2>
        </div>





    </div>

    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>