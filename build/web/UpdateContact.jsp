<%-- 
    Document   : UpdateContact
    Created on : Apr 14, 2023, 9:09:28 PM
    Author     : a_joh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="styles/styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Contact</title>
    </head>
    <body>
        <h1>Update Contact</h1>
        <form action="AddressBookController" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="originalID" value="${contact.getContactID()}">
            <label class="pad_top">ID:</label>
            <input type ="text" name="newID" value="${contact.getContactID()}"><br>
            <label class="pad_top">First Name:</label>
            <input type ="text" name="fName" value="${contact.getFirstName()}"><br>
            <label class="pad_top">Last Name:</label>
            <input type ="text" name="lName" value="${contact.getLastName()}"><br>
            <label class="pad_top">Address:</label>
            <input type ="text" name="address" value="${contact.getAddress()}"><br>
            <label class="pad_top">Email:</label>
            <input type ="email" name="email" value="${contact.getEmail()}"><br>
            <label class="pad_top">Phone Number:</label>
            <input type ="text" name="pNumber" value="${contact.getPhoneNumber()}"><br>
            <input type="submit" value="Update">
        </form>
        <form action="AddressBookController" method="get">
            <input type="hidden" name="action" value="list"><br>
            <input type="submit" value="Return to Address Book List">
        </form>
            
    </body>
</html>