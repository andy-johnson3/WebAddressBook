<%-- 
    Document   : Confirmation
    Created on : Apr 15, 2023, 9:26:33 AM
    Author     : a_joh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="styles/styles.css">
        <title>Confirmation Page</title>
    </head>
    <body>
        <h1>Confirmation</h1>
        <h2>${message}</h2>
        <form action="AddressBookController" method="get">
            <input type="hidden" name="action" value="list"><br>
            <input type="submit" value="Return to Address Book List">
        </form>
    </body>
</html>
