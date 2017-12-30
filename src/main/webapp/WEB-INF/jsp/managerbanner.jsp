<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-inverse">
    <div class="navbar-header">
        <a class="navbar-brand" href="/hrview">
            <span class="glyphicon glyphicon-eye-open"></span>
            HR Portal
        </a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
            <li><a href="viewtasks">Tasks</a></li>
        </ul>

        <ul class="nav navbar-nav pull-right">
            <li class=""><a>Welcome ${login}</a></li>
            <li class=""><a href="logout">Logout</a></li>
        </ul>
    </div>
</nav>

