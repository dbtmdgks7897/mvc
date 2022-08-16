<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2022-08-10
  Time: 오후 4:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String userName = (String) session.getAttribute("username");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>점심 추천</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<%--    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"> --%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
<%--    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script src="js/index.js"></script>
</head>
<body>
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <ul class="nav navbar-nav">
                <li><a id="len1" class="hoverable" href="/main.gg">Main</a></li>
                <li><a id="len2" class="hoverable" href="/movie.gg">Moive</a></li>
                <li><a id="len3" class="hoverable" href="/search.gg">Search</a></li>
                <li><a id="len4" class="hoverable" href="/foodrandom.gg">Recommend</a></li>
                <li><a id="len5" class="hoverable" href="/foodlist.gg">FoodList</a></li>
                <% if(userName == null){ %>
                <li><a id="len6" class="hoverable" href="/login.gg">Login</a></li>
                <% } else { %>
                <li><a id="len6" class="hoverable" href="/logout.gg">Logout</a></li>
                <li><a id="len7" class="hoverable" href="#"><%=userName%>님</a></li>
                <% } %>
            </ul>
        </div>
    </nav>
