
package Beans;


public class Contact {
    
    private String id;
    private String firstName;
    private String lastName;
    private String address;
    private String emailAddress;
    private String phoneNumber;
    
    public Contact(){
        this.id = "";
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.emailAddress = "";
        this.phoneNumber = "";
    }
    
    public Contact(String id, String firstName, String lastName, String address, String emailAddress, String phoneNumber){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        
    }
    
    public String getContactID(){
        return this.id;
    }
    
    public void setContactID(String id){
        this.id = id;
    }
    
    public String getFirstName(){
        return this.firstName;
    }
    
    public void setFirstName(String first){
        this.firstName = first;
    }
    
    public String getLastName(){
        return this.lastName;
    }
    
    public void setLastName(String last){
        this.lastName = last;
    }
    
    public String getAddress(){
        return this.address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
    
    public String getEmail(){
        return this.emailAddress;
    }
    
    public void setEmail(String email){
        this.emailAddress = email;
    }
    
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
