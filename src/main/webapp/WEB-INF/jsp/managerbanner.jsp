<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Loyalty</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">Home</a></li>
                <li><a href="loyaltyProgram">Loyalty Program</a></li>
                <li><a href="offers">Offers</a></li>
            </ul>

            <ul class="nav navbar-nav pull-right">
                <li class=""><a>Welcome ${login}</a></li>
                <li class=""><a href="logout">Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

