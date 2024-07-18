<%-- 
    Document   : insert
    Created on : Apr 25, 2024, 10:00:00 AM
    Author     : chinl
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert New Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            width: 400px;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        .container h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 8px;
            font-weight: bold;
        }

        input[type="text"], input[type="number"], input[type="checkbox"] {
            padding: 10px;
            margin-bottom: 16px;
            border: 1px solid #ccc;
            border-radius: 6px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            background-color: #1877f2;
            color: white;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #165eab;
        }

        .checkbox-container {
            display: flex;
            align-items: center;
        }

        .checkbox-container label {
            margin-bottom: 0;
            margin-left: 8px;
        }

        .checkbox-container input[type="checkbox"] {
            margin-right: 8px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Insert New Product</h2>
        <form action="MainController" method="POST">
            <label for="mobileId">Mobile ID:</label>
            <input type="text" id="mobileId" name="mobileId" required>

            <label for="description">Description:</label>
            <input type="text" id="description" name="description" required>

            <label for="price">Price:</label>
            <input type="number" id="price" name="price" required>

            <label for="mobileName">Mobile Name:</label>
            <input type="text" id="mobileName" name="mobileName" required>

            <label for="yearOfProduct">Year of Production:</label>
            <input type="number" id="yearOfProduct" name="yearOfProduct" required>

            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" required>

            <div class="checkbox-container">
                <input type="checkbox" id="notSale" name="notSale">
                <label for="notSale">Not Sale</label>
            </div>
            <label for="image">Quantity:</label>
            <input type="text" id="image" name="image" required>

            <input type="submit" name="action" value="Insert new product">
        </form>
        <a href="staff.jsp" style="text-decoration: none">Back</a>
    </div>
</body>
</html>
