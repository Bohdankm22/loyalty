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
        <h2>Create offer</h2>
        <div class="container">
            <form method="post" action="offerCreated">
                <table class="table table-responsive table-bordered">
                    <tr>
                        <td>
                            Item name
                        </td>
                        <td>
                            ${item.name}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Item description
                        </td>
                        <td>
                            ${item.description}
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Item type
                        </td>
                        <td>
                            ${item.type}
                        </td>
                    </tr>

                    <tr>
                        <td>
                            Discont %
                        </td>
                        <td>
                            <input class="form-control" placeholder="Discount" name="discount" type="number"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Cost in points
                        </td>
                        <td>
                            <input class="form-control" placeholder="Cost" name="cost" type="number"/>
                            <input class="form-control" name="id" type="hidden" value="${item.id}"/>
                        </td>
                    </tr>
                </table>

                <button class="label-success" value="Create offer"></button>
            </form>

        </div>


    </div>

</div>


</body>

</html>