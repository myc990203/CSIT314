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
        <form action ="Login" method = "post">
            <input class="inp" type="text" required="required" placeholder="Username" name="username"></input>
            <input class="inp" type="password" required="required" placeholder="Password" name="password"></input>

            <label for="dsa"><input class="radio" type="radio" id="cus" name="drone" value="customer" checked>Login As Customer</label>

            <label for="adas">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <input class="radio" type="radio" id="pro" name="drone" value="professional">Login As Professional</label>

            <br><br>

            <input type="submit" class="but" onclick=login() value="login">
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
