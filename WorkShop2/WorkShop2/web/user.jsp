<%-- 
    Document   : user
    Created on : Apr 22, 2024, 9:35:05 PM
    Author     : chinl
--%>

<%@page import="java.util.List"%>
<%@page import="Entities.EntitiesDTO"%>
<%@page import="Users.UserDTO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>User Page</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f0f2f5;
                margin: 0;
                padding: 0;
                height: 100%;
            }

            .container {
                width: 100%;
                padding: 20px;
                background: #ffffff;
                border-radius: 8px;
                box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                display: flex;
                flex-direction: column;
                justify-content: center;
                align-items: center;
                min-height: 100vh;
            }

            .header {
                text-align: center;
                margin-bottom: 24px;
            }

            .header h2 {
                color: red;
            }

            form {
                margin-bottom: 20px;
                display: flex;
                justify-content: center;
                align-items: center;
            }

            form input[type="number"] {
                margin-right: 10px;
                padding: 10px;
                border: 1px solid #ccd0d5;
                border-radius: 6px;
                width: 150px;
            }

            form input[type="submit"] {
                padding: 10px 20px;
                border: none;
                border-radius: 6px;
                background-color: #1877f2;
                color: white;
                font-size: 16px;
                cursor: pointer;
            }

            form input[type="submit"]:hover {
                background-color: #165eab;
            }

            table {
                width: 100%;
                border-collapse: collapse;
                margin-top: 20px;
            }

            table,
            th,
            td {
                border: 1px solid #ddd;
            }

            th,
            td {
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            .button-container {
                display: flex;
                justify-content: center;
                width: 100%;
                margin-top: 20px;
            }

            .button-container form {
                margin: 0 10px;
            }


        </style>
    </head>

    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            String search = request.getParameter("Search");
            if (search == null) {
                search = "";
            }

        %>
        <div class="container">
            <div class="header">
                <h2>Welcome to <span> : <%= loginUser.getFullName()%></span></h2>
            </div>
            <form action="MainController" method="POST">
                <input type="number" name="searchMin" placeholder="Minimum price" value="<%= request.getParameter("searchMin")%>" />
                <input type="number" name="searchMax" placeholder="Maximum price" value="<%= request.getParameter("searchMax")%>" />
                <input type="submit" name="action" value="Search" />
            </form>

            <%
                List<EntitiesDTO> list = (List<EntitiesDTO>) request.getAttribute("LIST_PRODUCTS");
                if (list != null) {
                    if (!list.isEmpty()) {
            %>
            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>No.</th>
                            <th>Mobile ID</th>
                            <th>Description</th>
                            <th>Price</th>
                            <th>Mobile name</th>
                            <th>Year of production</th>
                            <th>Quantity</th>
                            <th>Not sale</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            int count = 1;
                            for (EntitiesDTO product : list) {
                        %>
                    <form action="MainController">

                        <tr>
                            <td><%= count++%></td>
                            <td><%= product.getMobileId()%></td>
                            <td>
                                <%= product.getDescription()%>
                            </td>
                            <td>
                                <%= product.getPrice()%>
                            </td>
                            <td>
                                <%= product.getMobileName()%>
                            </td>
                            <td>
                                <%= product.getYearOfProduct()%>
                            </td>
                            <td>
                                <%= product.getQuantity()%>
                            </td>
                            <td>
                                <%= product.isNotSale()%>
                            </td>
                        </tr>
                    </form>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
            <%
                    }
                }
            %>

            <div class="button-container">
                <form action="MainController" method="POST">
                    <input type="submit" name="action" value="Shopping" />
                </form>
                <form action="MainController" method="POST">
                    <input type="submit" name="action" value="Logout" />
                </form>
            </div>
        </div>
    </body>

</html>
