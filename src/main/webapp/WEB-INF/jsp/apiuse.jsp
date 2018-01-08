<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>HR Portal</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>

<jsp:include page="banner.jsp"/>

<div class="container">

    <div class="starter-template">
        <h1>API Usage</h1>
        <br/>
        <p>To get JSON with all users use GET call to "{webserver}/api/user"</p>
        <p>To get JSON with a particular user use GET call to "{webserver}/api/user/<b>userid</b>" where <b>userid</b>
            is the user identification number (e.g. 1)</p>
        <p>To get JSON with a particular user tasks use GET call to "{webserver}/api/user/<b>userid</b>/task" where <b>userid</b>
            is the user identification number (e.g. 1)</p>
        <br />
        <p>To get JSON with all tasks use GET call to "{webserver}/api/task"</p>
        <p>To get JSON with a particular task use GET call to "{webserver}/api/task/<b>taskid</b>" where <b>taskid</b>
            is the task identification number (e.g. 1)</p>
    </div>

</div>

<jsp:include page="footer.jsp"/>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>