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

<jsp:include page="banner.jsp"/>

<div class="container">

    <div class="starter-template">
        <h1>Login as a Customer</h1>
        <div class="panel-body">
            <form accept-charset="UTF-8" role="form" method="post" action="loginCustomer">
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

        <h1>Login as a Manager</h1>
        <div class="panel-body">
            <b>Sign In With Intuit</b><br />
            <a class="imgLink" onclick="'launchPopup(\'signInWithIntuit\');'" href="#">
                <img
                        style="height: 40px"
                        src="/resources/images/IntuitSignIn-lg-white@2x.jpg"

                />
            </a>
        </div>
    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script>
    function launchPopup(path) {
        var win;
        var checkConnect;
        var parameters = "location=1,width=800,height=650";
        parameters += ",left=" + (screen.width - 800) / 2 + ",top=" + (screen.height - 650) / 2;
        // Launch Popup
        win = window.open(path, 'connectPopup', parameters);
    }
</script>
</body>

</html>