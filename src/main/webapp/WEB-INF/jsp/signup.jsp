<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>HR Portal</title>
    <link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <spring:url value="/css/main.css" var="springCss"/>
    <link href="${springCss}" rel="stylesheet"/>
</head>
<body>

<jsp:include page="banner.jsp"/>

<div class="container">

    <div class="starter-template">
        <h1>Add a user</h1>
        <div class="panel-body">
            <form accept-charset="UTF-8" role="form" method="post" action="singUpCustomer">
                <fieldset>
                    <div class="form-group">
                        <label class="control-label" for="login">Login</label>
                        <input class="form-control" name="login" id="login" type="text">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="password">Password</label>
                        <input class="form-control" name="password" id="password" type="text" value="">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="first_name">First name</label>
                        <input class="form-control" name="first_name" id="first_name" type="text" value="">
                    </div>
                    <div class="form-group">
                        <label class="control-label" for="last_name">Last name</label>
                        <input class="form-control" name="last_name" id="last_name" type="text" value="">
                    </div>
                    <button class="btn btn-lg btn-success btn-block" type="submit">Sing up</button>
                </fieldset>
            </form>
        </div>
    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>