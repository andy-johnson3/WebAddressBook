<%-- 
    Document   : NewContact
    Created on : Apr 10, 2023, 9:38:41 PM
    Author     : a_joh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="styles/styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Contact</title>
    </head>
    <body>
        <h1>Insert New Contact</h1>
        <form action="AddressBookController" method="post">
            <input type="hidden" name="action" value="add" required>
            <label class="pad_top">ID:</label>
            <input type ="text" name="id"  required><br>
            <label class="pad_top">First Name:</label>
            <input type ="text" name="fName" required><br>
            <label class="pad_top">Last Name:</label>
            <input type ="text" name="lName" required><br>
            <label class="pad_top">Address:</label>
            <input type ="text" name="address" required><br>
            <label class="pad_top">Email:</label>
            <input type ="email" name="email" required><br>
            <label class="pad_top">Phone Number:</label>
            <input type ="text" name="pNumber" required><br>
            <input type="submit" value="Submit">
        </form>
            
    </body>
</html>
