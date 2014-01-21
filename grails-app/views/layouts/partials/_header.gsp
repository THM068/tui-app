<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <g:link uri="/" class="brand" href="#">
                <span style="float: right">&nbsp; TUI Search Application</span>
            </g:link>
            <div class="nav-collapse">
                <ul class="nav">
                    <li class="active">
                        <g:link controller="home" action="myFavourites">My Favourites</g:link>
                    </li>
                    <sec:ifNotLoggedIn>
                        <li>
                            <a id="loginLink" href="#loginForm">Login</a>
                        </li>
                    </sec:ifNotLoggedIn>
                        <li class="logoutLink" style="display: none">
                            <g:link controller="logout" action="index">Logout</g:link>
                        </li>
                    <sec:ifLoggedIn>
                        <li>
                            <g:link controller="logout" action="index">Logout</g:link>
                        </li>
                    </sec:ifLoggedIn>

                </ul>
            </div><!--/.nav-collapse -->
        </div>
    </div>
</div>