
package Test;


import org.junit.Test;
import static org.junit.Assert.*;
import Beans.Contact;
/**
 *
 * @author a_joh
 */
public class Contact_Bean_Test {

    @Test
    public void testBean(){
        Contact contact = new Contact("1", "Andy", "Johnson", "144 Main St", "a@gmail.com", "888-787-7878");
             
        assertTrue(contact instanceof Contact);
        assertEquals(contact.getContactID(), "1");
        assertEquals(contact.getFirstName(), "Andy");
        assertEquals(contact.getLastName(), "Johnson");
        assertEquals(contact.getAddress(), "144 Main St");
        assertEquals(contact.getEmail(), "a@gmail.com");
        assertEquals(contact.getPhoneNumber(), "888-787-7878");
        
    }
}
