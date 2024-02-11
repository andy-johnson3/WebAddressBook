<%-- 
    Document   : RemoveContact
    Created on : Apr 14, 2023, 9:58:03 PM
    Author     : a_joh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="styles/styles.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Remove Contact</title>
    </head>
    <body>
        <h1><strong>CONFIRM</strong> Remove Contact</h1>
        <form action="AddressBookController" method="post">
            <input type="hidden" name="action" value="remove">
            <input type="hidden" name="contactID" value="${contact.getContactID()}">
            <label class="pad_top">ID: </label>${contact.getContactID()}<br>
            <label class="pad_top">First Name: </label>${contact.getFirstName()}<br>
            <label class="pad_top">Last Name: </label>${contact.getLastName()}<br>
            <label class="pad_top">Address: </label>${contact.getAddress()}<br>
            <label class="pad_top">Email: </label>${contact.getEmail()}<br>
            <label class="pad_top">Phone Number: </label>${contact.getPhoneNumber()}<br>
            <input type="submit" value="Remove">
        </form>
        <form action="AddressBookController" method="get">
            <input type="hidden" name="action" value="list"><br>
            <input type="submit" value="Return to Address Book List">
        </form>
            
    </body>
</html>
