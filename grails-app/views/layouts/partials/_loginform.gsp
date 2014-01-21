<div style="display:none">
    <div id="loginForm">
        <div class="alert alert-error login-error" style="display: none"></div>
        <form action='${request.contextPath}/j_spring_security_check' method='POST' id='ajaxLoginForm' name='ajaxLoginForm'>
            <label for="username">Email</label>
            <div class="login-row"><input type="text" name="j_username" id="username" class="login-field"/></div>
            <label for="password">Password</label>
            <div class="login-row"><input type="password" name="j_password" id="password" class="login-field"/></div>
            <div id="login-submit">
                <span class="login-submit"><input type="submit" value="Sign In" id="login-signin" /></span>
            </div>
        </form>
    </div>
</div>