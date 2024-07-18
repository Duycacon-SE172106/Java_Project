<%-- 
    Document   : shopping
    Created on : Apr 23, 2024, 8:14:42 AM
    Author     : chinl
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.EntitiesDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shopping Page</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f0f2f5;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }

            form {
                background: #ffffff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                display: flex;
                flex-direction: column;
                align-items: center;
                width: 400px; /* Đặt chiều rộng của form */
            }

            select, input[type="number"] {
                margin-bottom: 16px;
                padding: 10px;
                border: 1px solid #ccd0d5;
                border-radius: 6px;
                width: calc(100% - 20px);
                max-width: 400px;
            }

            .button-container {
                width: calc(100% - 20px);
                max-width: 400px;
                display: flex;
                justify-content: space-between;
                align-items: center;
                margin-top: 10px; /* Đặt margin phía trên */
                margin: auto;
            }

            input[type="submit"] {
                padding: 10px;
                border: none;
                border-radius: 6px;
                background-color: #1877f2;
                color: white;
                font-size: 16px;
                cursor: pointer;
                width: 48%; 
                margin-right:  10px;
            }

            input[type="submit"]:hover {
                background-color: #165eab;
            }
        </style>
    </head>
   <body>
    <form action="MainController" method="POST">
        <%
            List<EntitiesDTO> productList = (List<EntitiesDTO>) session.getAttribute("LIST_PRODUCTS");
            if (productList != null) {
        %>
        <label for="product">Type:</label>
        <select id="product" name="product">
            <%
                for (EntitiesDTO product : productList) {
                    if (!product.isNotSale()) {
            %>
            <option value="<%= product.getMobileId() %>-<%= product.getMobileName() %>-<%= product.getPrice() %>-<%= product.getYearOfProduct() %>">
                <%= product.getMobileName() %>-<%= product.getPrice() %>$
            </option>
            <%
                    }
                }
            %>
        </select>
        <%
            }
        %>
        <label for="quantity">Quantity:</label>
        <input type="number" id="quantity" name="quantity" min="1">
        <div class="button-container">
            <input type="submit" name="action" value="Add"/>
            <input type="submit" name="action" value="View"/>
            <input type="submit" name="action" value="Home"/>
        </div>
    </form>
</body>
</html>