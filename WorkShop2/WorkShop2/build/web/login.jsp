<%-- 
    Document   : login
    Created on : Apr 16, 2024, 2:54:20 PM
    Author     : chinl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="MainController" method="POST">        
            User name<input type="text" name="userID"><br/>
            Password<input type="password" name="password"><br/>
            <input type="submit" name="action" value="Login">
            <input type="reset" value="Reset">      
        </form>
    </body>
</html>
