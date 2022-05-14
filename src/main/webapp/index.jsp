<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="login.css"/>
    <script src="login.js"></script>
</head>

<body>
<div class="wt">

</div>
<div class="background">

</div>
<div class="content">
    <div id="login">
        <h1>Login</h1>
        <form action="Login" method="post">
            <input id="username" class="inp" type="text" required="required" placeholder="Username" onblur="setCookie_username()" name="u">
            <input id="password" class="inp" type="password" required="required" placeholder="Password" onblur="setCookie_pwd()" name="p">

            <label><input class="radio" type="radio" id="cus" name="drone" value="cus" onclick="setType1()">Login As Customer</label>

            <label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="radio" type="radio" id="pro" name="drone" value="pro" onclick="setType2()">Login As Professional</label>

            <br><br>
            <input type="submit" class="but" value="login">
            <span class="signin">
                        <a href="./register/register.html" methods="post">New to us? Sign in!</a>
            </span>
        </form>
    </div>
</div>

<div class="wt">

</div>
</body>
</html>
