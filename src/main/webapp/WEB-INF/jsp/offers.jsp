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
    <script>
        if (window.opener) {
            window.opener.location.href = '/managerview'
            window.close()
        }
    </script>
</head>
<body>

<jsp:include page="managerbanner.jsp"/>

<div class="container">

    <div class="starter-template">
        <h1>Loyalty program ${programName} launched by ${companyName}</h1>

        <h2>Existing offers:</h2>
        <div class="container">
            <table class="table table-bordered table-responsive">
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Type</th>
                    <th>Discount</th>
                    <th>Points</th>
                </tr>
                <c:forEach items="${availOffers}" var="currentDataSetObj">
                    <tr>
                        <td><c:out value="${currentDataSetObj.name}"/></td>
                        <td><c:out value="${currentDataSetObj.description}"/></td>
                        <td><c:out value="${currentDataSetObj.type}"/></td>
                        <td><c:out value="${currentDataSetObj.discount}"/></td>
                        <td><c:out value="${currentDataSetObj.points}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <h2>Please select item to create an offers:</h2>
        <div class="container">
            <form method="post" action="createOffer">
                <table class="table table-bordered table-responsive">
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Type</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${goods}" var="currentDataSetObj">
                        <tr>
                            <td><c:out value="${currentDataSetObj.name}"/></td>
                            <td><c:out value="${currentDataSetObj.description}"/></td>
                            <td><c:out value="${currentDataSetObj.type}"/></td>
                            <td><button class="button" name="itemId" value="${currentDataSetObj.id}">Create offer</button></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
        </div>


    </div>

</div>


</body>

</html>