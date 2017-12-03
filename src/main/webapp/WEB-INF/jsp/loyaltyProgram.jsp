<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>About Loyalty</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script>
        if(window.opener) {
            window.opener.location.href = '/managerview'
            window.close()
        }
    </script>
</head>
<body>

    <jsp:include page="managerbanner.jsp" />

    <div class="container">

        <div class="starter-template">
            <h1>Loyalty program</h1>
            <h2>Program name: ${programName}</h2>
            <h2>Company name: ${companyName}</h2>
        </div>

    </div>


</body>

</html>