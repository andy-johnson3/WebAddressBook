<%-- 
    Document   : address_details
    Created on : Apr 10, 2023, 9:38:41 PM
    Author     : a_joh
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="styles/styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Address Book</title>
</head>
<body>
    <h1>Address Book</h1>
    <form action="NewContact" method="get">
        <input type="submit" name="insert" value="Insert Contact">
    </form><br>
    <table>
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>Email Address</th>
            <th>Phone Number</th> 
            <th></th>
            <th></th> 
        </tr>
    <c:forEach var="con" items="${contacts}">
        <tr>
            <td>${con.getContactID()}</td>
            <td>${con.getFirstName()}</td>
            <td>${con.getLastName()}</td>
            <td>${con.getAddress()}</td>
            <td>${con.getEmail()}</td>
            <td>${con.getPhoneNumber()}</td>
            <td>
                <form action="AddressBookController" method="get">
                    <input type="hidden" name="contact" value="${con.getContactID()}">
                    <input type="hidden" name="action" value="edit">
                    <input type ="submit" value="Edit">
                </form>
            </td>
            <td>
                <form action="AddressBookController" method="get">
                    <input type="hidden" name="contact" value="${con.getContactID()}">
                    <input type="hidden" name="action" value="remove">
                    <input type ="submit" value="Remove">
               </form>
            </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>