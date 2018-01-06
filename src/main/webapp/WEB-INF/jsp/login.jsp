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
        <h1>Login as a Customer</h1>
        <div class="panel-body">
            <b>
                <%
                    if(null != request.getAttribute("errorMessage")) {
                        out.println(request.getAttribute("errorMessage"));
                    }
                %>
            </b>
            <form accept-charset="UTF-8" role="form" method="post" action="loginUser">
                <fieldset>
                    <div class="form-group">
                        <input class="form-control" placeholder="Login" name="login" type="text">
                    </div>
                    <div class="form-group">
                        <input class="form-control" placeholder="Password" name="password" type="password" value="">
                    </div>
                    <div class="checkbox">
                        <label>
                            <input name="remember" type="checkbox" value="Remember Me"> Remember Me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-success btn-block" type="submit">Login</button>
                </fieldset>
            </form>
        </div>
    </div>

</div>

</body>

</html>