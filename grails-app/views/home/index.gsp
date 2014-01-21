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
    <div id='image-search-container'>
        <h3>Search for an image</h3>
        <g:form controller="home" action="search" >
            <input type="text" name="q" placeholder="Search for an image" class="textfield-size" id="searchTerm">
            <g:select name="numPerPage" from="${[5,10,20,30,40]}" value="20"  />

            <input type="submit" class="btn btn-primary" value="Search" id="searchBtn">
            <g:link class="btn btn-primary" controller="home" action="exportResults" elementId="exportResultLink">Export Search Results</g:link>
            <span class="loading">
                <img src="${resource(dir: 'images', file: 'spinner.gif')}" alt="">
                <span>Images loading ....</span>
            </span>
        </g:form>
    </div>
    <div class="alert alert-error" style="display: none">

    </div>
    <div id="image-tile-container">
        <g:each in="${imageList}" var="map">
            <g:render template="imageInfo"  model="[image: map]" />
        </g:each>
    </div>

    <r:script>
        var addToFavsUrl = '${createLink(controller: 'home', action: 'favourites')}';
    </r:script>

</body>
</html>