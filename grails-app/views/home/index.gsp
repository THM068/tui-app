<%--
  Created by IntelliJ IDEA.
  User: thandomafela
  Date: 19/01/2014
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
     <title>TUI Search Application</title>
     <meta name="layout" content="main"/>
</head>
<body>
    <h3>Search for an image</h3>
    <div id='image-search-container'>
        <g:form controller="home" action="search" >
            <input type="text" placeholder="Search for an image" class="textfield-size">
            <input type="submit" class="btn btn-primary" value="Search">
        </g:form>

        <div id="image-tile-container">

        </div>
    </div>

</body>
</html>