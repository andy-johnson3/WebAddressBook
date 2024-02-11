package Servlets;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Beans.Contact;


public class AddressBookController extends HttpServlet {
    
    @Override
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        String dbURL = "jdbc:mysql://localhost:3306/addressbook";
        String username = "root";
        String password = "linklink";       
        
        if (action.equals("edit")){
            
            String id = request.getParameter("contact");
            
            String query = "SELECT * FROM contacts WHERE contact_id = '" + id + "'";
            
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection  conn = DriverManager.getConnection(dbURL, username, password);
                    Statement statement = conn.createStatement();
                    ResultSet rs = statement.executeQuery(query);

                    rs.next();
                    String contactID = rs.getString("contact_id");
                    String first = rs.getString("contact_fName");
                    String last = rs.getString("contact_lName");
                    String address = rs.getString("contact_address");
                    String email = rs.getString("contact_email");
                    String phoneNumber = rs.getString("contact_phoneNumber");
                    
                    System.out.println(contactID);

                    Contact contact = new Contact(contactID, first, last, address, email, phoneNumber);

                    request.setAttribute("contact", contact);
                    statement.close();
                    conn.close();
                } catch (ClassNotFoundException ex) {
                   Logger.getLogger(AddressBookController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AddressBookController.class.getName()).log(Level.SEVERE, null, ex);
                }

                getServletContext().getRequestDispatcher("/UpdateContact.jsp").forward(request, response);
            
        }   else if (action.equals("remove")){
            
            String id = request.getParameter("contact");
            
            String query = "SELECT * FROM contacts WHERE contact_id = '" + id + "'";
            
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection  conn = DriverManager.getConnection(dbURL, username, password);
                    Statement statement = conn.createStatement();
                    ResultSet rs = statement.executeQuery(query);

                    rs.next();
                    String contactID = rs.getString("contact_id");
                    String first = rs.getString("contact_fName");
                    String last = rs.getString("contact_lName");
                    String address = rs.getString("contact_address");
                    String email = rs.getString("contact_email");
                    String phoneNumber = rs.getString("contact_phoneNumber");

                    Contact contact = new Contact(contactID, first, last, address, email, phoneNumber);

                    request.setAttribute("contact", contact);
                    statement.close();
                    conn.close();
                } catch (ClassNotFoundException ex) {
                   Logger.getLogger(AddressBookController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(AddressBookController.class.getName()).log(Level.SEVERE, null, ex);
                }

                getServletContext().getRequestDispatcher("/RemoveContact.jsp").forward(request, response);
            
            
        }   else if (action.equals("list"))   {
            
            String query = "SELECT * FROM contacts";
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection  conn = DriverManager.getConnection(dbURL, username, password);
                    Statement statement = conn.createStatement();
                    ResultSet rs = statement.executeQuery(query);

                    List<Contact> contacts = new ArrayList<>();

                    while (rs.next()){
                        String contactID = rs.getString("contact_id");
                        String first = rs.getString("contact_fName");
                        String last = rs.getString("contact_lName");
                        String address = rs.getString("contact_address");
                        String email = rs.getString("contact_email");
                        String phoneNumber = rs.getString("contact_phoneNumber");

                        Contact contact = new Contact(contactID, first, last, address, email, phoneNumber);
                        contacts.add(contact);
                    }

                    request.setAttribute("contacts", contacts);
                    statement.close();
                    conn.close();
                } catch (ClassNotFoundException ex) {
                   Logger.getLogger(AddressBookController.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println(ex);
                } catch (SQLException ex) {
                   Logger.getLogger(AddressBookController.class.getName()).log(Level.SEVERE, null, ex);
                   System.out.println(ex);
                }

                getServletContext().getRequestDispatcher("/AddressBook.jsp").forward(request, response);
            }

    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
        String action = request.getParameter("action");
        
        if (action.equals("add")){
            String id = request.getParameter("id");
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String pNumber = request.getParameter("pNumber");

            String dbURL = "jdbc:mysql://localhost:3306/addressbook";
            String username = "root";
            String password = "linklink"; 

            String preparedQuery = 
                    "INSERT INTO contacts (contact_id, contact_fName, contact_lName, contact_address, contact_email, contact_phoneNumber) "
                  + "VALUES (?, ?, ?, ?, ?, ?)";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, username, password);
                Statement statement = conn.createStatement();
                
                PreparedStatement ps = conn.prepareStatement(preparedQuery);
                ps.setString(1, id);
                ps.setString(2, fName);
                ps.setString(3, lName);
                ps.setString(4, address);
                ps.setString(5, email);
                ps.setString(6, pNumber);
                ps.executeUpdate();
                
                String message = "Contact successfully added!";
                request.setAttribute("message", message);

                statement.close();
                conn.close();
                
            } catch (ClassNotFoundException ex) {
               String message = "Class was not found.  Object was not added.";
               request.setAttribute("message", message);
            } catch (SQLException ex) {
                String message = "SQL Exception occured.  Object was not added.";
                request.setAttribute("message", message);
            }
            
            getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
            
        }   else if (action.equals("update")){
            String originalID = request.getParameter("originalID");
            String newID = request.getParameter("newID");
            String fName = request.getParameter("fName");
            String lName = request.getParameter("lName");
            String address = request.getParameter("address");
            String email = request.getParameter("email");
            String pNumber = request.getParameter("pNumber");

            String dbURL = "jdbc:mysql://localhost:3306/addressbook";
            String username = "root";
            String password = "linklink"; 

            String preparedQuery = 
                    "UPDATE contacts SET "
                  + "contact_id = ?, "
                  + "contact_fName = ?, "
                  + "contact_lName = ?, " 
                  + "contact_address = ?, "
                  + "contact_email = ?, "
                  + "contact_phoneNumber = ? "
                  + "WHERE contact_id = ?";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, username, password);
                Statement statement = conn.createStatement();
                
                PreparedStatement ps = conn.prepareStatement(preparedQuery);
                ps.setString(1, newID);
                ps.setString(2, fName);
                ps.setString(3, lName);
                ps.setString(4, address);
                ps.setString(5, email);
                ps.setString(6, pNumber);
                ps.setString(7, originalID);
                ps.executeUpdate();
                
                String message = "Contact successfully updated!";
                request.setAttribute("message", message);

                statement.close();
                conn.close();
                
            } catch (ClassNotFoundException ex) {
                String message = "Class was not found.  Object was not updated.";
                request.setAttribute("message", message);
            } catch (SQLException ex) {
                String message = "SQL Exception occured.  Object was not updated.";
                request.setAttribute("message", message);
            }     
            
            getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
            
        } else if (action.equals("remove")){
            String id = request.getParameter("contactID");

            String dbURL = "jdbc:mysql://localhost:3306/addressbook";
            String username = "root";
            String password = "linklink"; 

            String preparedQuery = 
                    "DELETE FROM contacts "
                  + "WHERE contact_id = ?";

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(dbURL, username, password);
                Statement statement = conn.createStatement();
                
                PreparedStatement ps = conn.prepareStatement(preparedQuery);
                ps.setString(1, id);
                ps.executeUpdate();
                
                String message = "Contact successfully removed from Address Book";
                request.setAttribute("message", message);

                statement.close();
                conn.close();
                
            } catch (ClassNotFoundException ex) {
               String message = "Class was not found.  Object was not removed.";
               request.setAttribute("message", message);
            } catch (SQLException ex) {
               String message = "SQL Exception occured.  Object was not removed.";
               request.setAttribute("message", message);
            }  
            
            
            getServletContext().getRequestDispatcher("/Confirmation.jsp").forward(request, response);
    }

}
}

