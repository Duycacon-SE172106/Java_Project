<%-- 
    Document   : staff
    Created on : Apr 16, 2024, 2:55:44 PM
    Author     : chinl
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="Entities.EntitiesDTO"%>
<%@page import="Users.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Staff Page</title>
        <style>
            body, html {
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
                min-height: 100vh; /* Sử dụng min-height để đảm bảo container có ít nhất chiều cao bằng viewport */
            }

            .header {
                text-align: center;
                margin-bottom: 24px;
            }

            .header h1 {
                font-size: 24px;
                color: #333;
            }

            form {
                margin-bottom: 20px;
                display: flex;
                justify-content: center;
                align-items: center;
                flex-wrap: wrap;
            }

            form input[type="text"],
            form input[type="password"],
            form input[type="number"] {
                margin-bottom: 16px;
                padding: 10px;
                border: 1px solid #ccd0d5;
                border-radius: 6px;
                width: 70%;
                max-width: 400px;
            }

            form input[type="submit"],
            button {
                padding: 10px;
                border: none;
                border-radius: 6px;
                background-color: #1877f2;
                color: white;
                font-size: 16px;
                cursor: pointer;
                width: 30%;
                max-width: 150px;
                margin-left: 10px;
            }

            form input[type="submit"]:hover,
            button:hover {
                background-color: #165eab;
            }

            table {
                width: 70%;
                max-width: 600px;
                border-collapse: collapse;
                margin-top: 20px;
                overflow-y: auto; /* Thêm thanh cuộn dọc khi cần */
            }

            table, th, td {
                border: 1px solid #ddd;
            }

            th, td {
                padding: 8px;
                text-align: left;
            }

            th {
                background-color: #f2f2f2;
            }

            button[type="submit"] {
                background-color: transparent;
                border: none;
                color: #1877f2;
                cursor: pointer;
                font-size: 14px;
                text-decoration: underline;
                width: auto;
                margin-right: 0;
            }

            button[type="submit"]:hover {
                color: #165eab;
            }

            /* Thêm margin-bottom cho form */
            form {
                margin-bottom: 20px;
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
                <h1 style="color: red">Welcome to <span><%= loginUser.getFullName()%></span></h1>
            </div>
            <form action="MainController" method="GET">
                <input type="text" name="search" placeholder="Enter here to search" value="<%= search %>" style="width: 100%; max-width: 500px" />
                <input type="submit" name="action" value="Search" style="width: 25%; max-width: 100px;" />
                <input type="submit" name="action" value="Insert" style="width: 25%; max-width: 100px;" />
                <input type="submit" name="action" value="Logout" style="width: 25%; max-width: 100px;" />
            </form>

            <%
                List<EntitiesDTO> list = (List<EntitiesDTO>) request.getAttribute("LIST_PRODUCTS");
                if (list != null) {
                    if (!list.isEmpty()) {
            %>
            <table>
                <thead>
                    <tr>
                <thead>
                    <tr>
                        <th style="text-align: center;">No.</th>
                        <th style="text-align: center;">Mobile ID</th>
                        <th style="text-align: center;">Description</th>
                        <th style="text-align: center;">Price</th>
                        <th style="text-align: center;">Mobile name</th>
                        <th style="text-align: center;">Year of production</th>
                        <th style="text-align: center;">Quantity</th>
                        <th colspan="2" style="text-align: center;">Action</th>
                    </tr>
                </thead>

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
                        <td>
                            <input type="text" name="mobileId" value="<%= product.getMobileId()%>" readonly=""/>
                        </td>
                        <td>
                            <input type="text" name="description" value="<%= product.getDescription()%>" />
                        </td>
                        <td>
                            <input type="number" name="price" value="<%= product.getPrice()%>" />
                        </td>
                        <td>
                            <input type="text" name="mobileName" value="<%= product.getMobileName()%>" />
                        </td>
                        <td>
                            <input type="number" name="yearOfProduct" value="<%= product.getYearOfProduct()%>" />
                        </td>
                        <td>
                            <input type="number" name="quantity" value="<%= product.getQuantity()%>" />
                        </td>
                        <td >
                            <input type="hidden" name="mobileId" value="<%= product.getMobileId() %>">
                            <input type="hidden" name="search" value="<%= search %>"/>
                            <input type="submit" name="action" value="Update"/>
                        </td>
                        <td>                                    
                            <a href="MainController?action=Delete&mobileId=<%= product.getMobileId()%>&search=<%= search%>" style="text-decoration: none">Delete</a>
                        </td>
                    </tr>
                </form>
                <%
                    }
                %>
                </tbody>
            </table>
                <%
                }
            }
        %>
        </div>
    </body>
</html>
