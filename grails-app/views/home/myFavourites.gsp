<%--
  Created by IntelliJ IDEA.
  User: thandomafela
  Date: 19/01/2014
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>My Favourites</title>
    <meta name="layout" content="main"/>
</head>
<body>
    <h3>My favourite images</h3>
    <div id="image-tile-container">
        <g:each in="${imageList}" var="favourite">
            <div class="img-container">
                <img src="${favourite.url}" alt="" title="${map?.title}">
            </div>
        </g:each>
    </div>
</body>
</html>