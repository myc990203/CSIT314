<html>
<body>

<h2>Hello World!</h2>
<%--<form action="http://localhost:8080" method="post">--%>
<%--    First name: <input type="text" name="fname"><br>--%>
<%--    Last name: <input type="text" name="lname"><br>--%>
<%--    <input type="submit" value="提交">--%>
<%--</form>--%>
<form action="HelloServlet" method="post">
    First name: <input type="text" name="fname"><br>
    Last name: <input type="text" name="lname"><br>
    <input type="submit" value="post require">
</form>
<form action="HelloServlet" method="get">
    First name: <input type="text" name="fname"><br>
    Last name: <input type="text" name="lname"><br>
    <input type="submit" value="get require">
</form>

</body>
</html>
