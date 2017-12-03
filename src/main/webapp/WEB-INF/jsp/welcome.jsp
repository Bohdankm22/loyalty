<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Loyalty</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

    <jsp:include page="banner.jsp" />

    <div class="container">

        <div class="starter-template">
            <h1>Loyalty program</h1>
            <h2>${message}</h2>
        </div>

        <img src="/resources/images/securenetshop2.png"/>

    </div>
     <jsp:include page="footer.jsp"/>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>