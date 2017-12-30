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

<jsp:include page="employeebanner.jsp"/>

<div class="container">

    <div class="starter-template">
        <h1>This is an employee view for ${login}</h1>
        <br />

        <h3>Here is a list of your tasks:</h3>
        <table class="table table-bordered table-responsive">
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Date Posted</th>
                <th>Last Updated</th>
                <th></th>
            </tr>
            <c:forEach items="${tasks}" var="currentDataSetObj">
                <tr>
                    <td><c:out value="${currentDataSetObj.title}"/></td>
                    <td><c:out value="${currentDataSetObj.description}"/></td>
                    <td><c:out value="${currentDataSetObj.postedAt}"/></td>
                    <td><c:out value="${currentDataSetObj.lastUpdatedAt}"/></td>
                    <td>
                        <button class="button" name="itemId" value="${currentDataSetObj.id}"><b>Change status</b></button>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </div>

</div>

<jsp:include page="footer.jsp"/>
<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>