<%-- 
    Document   : viewCart
    Created on : Apr 22, 2024, 10:56:55 PM
    Author     : chinl
--%>

<%@page import="Entities.Cart"%>
<%@page import="java.util.Map"%>
<%@page import="Entities.EntitiesDTO"%>
<%@page import="java.util.HashMap"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f2f5;
                margin: 0;
                padding: 0;
            }

            .container {
                width: 80%;
                margin: 20px auto;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 10px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            .total {
                font-size: 20px;
                font-weight: bold;
                margin-top: 20px;
            }

            .edit-btn, .remove-btn {
                padding: 8px 16px;
                border: none;
                background-color: #4CAF50;
                color: white;
                cursor: pointer;
                border-radius: 4px;
                transition: background-color 0.3s;
            }

            .edit-btn:hover, .remove-btn:hover {
                background-color: #45a049;
            }

            .add-more-link {
                display: block;
                margin-top: 20px;
                text-decoration: none;
                color: #1877f2;
                font-weight: bold;
            }
            .home-btn {
                padding: 10px 20px;
                border: none;
                border-radius: 6px;
                background-color: #1877f2;
                color: white;
                font-size: 16px;
                cursor: pointer;
            }

            .home-btn:hover {
                background-color: #165eab;
            }
        </style>
    </head>
    <body>
    <div class="container">
        <% 
            Cart cart = (Cart) session.getAttribute("CART");
            if (cart != null && cart.getCart().size()>0) {
                if (cart != null) {
                    int count = 1;
                    double total = 0;
        %>
                    <table>
                        <thead>
                            <tr>
                                <th>No</th>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (EntitiesDTO product : cart.getCart().values()) {
                                total += product.getPrice() * product.getQuantity();
                            %>
                            <form action="MainController">
                                <tr>
                                    <td><%= count %></td>
                                    <td><%= product.getMobileId() %></td>
                                    <td><%= product.getMobileName() %></td>
                                    <td><%= product.getPrice() %></td>
                                    <td><input type="number" name="quantity" value="<%= product.getQuantity() %>" required=""></td>
                                    <td><%= product.getPrice() * product.getQuantity() %></td>
                                    <!--edit function-->
                                    <td>
                                        <form action="MainController">
                                            <input type="hidden" name="mobileId" value="<%= product.getMobileId() %>">
                                            <input type="hidden" name="quantity" value="<%= product.getQuantity() %>">
                                            <input type="submit" name="action" value="Edit" class="edit-btn">
                                        </form>
                                    </td>
                                    <td>
                                        <form action="MainController">
                                            <input type="hidden" name="mobileId" value="<%= product.getMobileId() %>">
                                            <input type="submit" name="action" value="Remove" class="remove-btn">
                                        </form>
                                    </td>
                                </tr>
                            <% 
                                count++;
                            }
                            %>
                            </form>
                        </tbody>
                    </table>
                    <div class="total">Total: <%= total %>$</div>
        <% 
                }
            } 
        %>
        <form action="MainController">
            <input type="submit" name="action" value="Home" class="home-btn">
        </form>
        <a href="shopping.jsp" class="add-more-link">Add more</a>
    </div>
</body>
</html>