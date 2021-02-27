package module3;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {

	@Test
	public void testAddContact() {
		// Create a new contact with the addContact method, then make sure that everything was created properly.
		ContactService contactService = new ContactService();
		contactService.addContact("12345", "Derek", "Nill", "5134231234", "42 Hawk Drive");
		
		assertTrue(contactService.getContact("12345").getFirstName().equals("Derek"));
		assertTrue(contactService.getContact("12345").getLastName().equals("Nill"));
		assertTrue(contactService.getContact("12345").getPhone().equals("5134231234"));
		assertTrue(contactService.getContact("12345").getAddress().equals("42 Hawk Drive"));
	}
	
	@Test
	public void testAddUniqueID() {
		// Create a new contact, then try creating one again with the same contact ID.
		// The addContact method should throw an exception.
		ContactService contactService = new ContactService();
		contactService.addContact("12345", "Derek", "Nill", "5134231234", "42 Hawk Drive");
		assertThrows(IllegalArgumentException.class, () -> {
			contactService.addContact("12345", "Derek", "Nill", "5134231234", "42 Hawk Drive");
		});
	}
	
	@Test
	public void testDeleteContact() {
		// Create a new Contact, then try check that the new Contact object exists in the contact list map.
		ContactService contactService = new ContactService();
		contactService.addContact("12345", "Derek", "Nill", "5134231234", "42 Hawk Drive");
		assertTrue(contactService.getContact("12345") != null);
		
		// use the deleteContact method to then remove the Contact from the map, and then check that it is in fact gone.
		contactService.deleteContact("12345");
		assertTrue(contactService.getContact("12345") == null);
	}
	
	@Test
	public void testUpdateAttributes() {
		ContactService contactService = new ContactService();
		contactService.addContact("12345", "Derek", "Nill", "5134231234", "42 Hawk Drive");
		contactService.updateFirstName("12345", "Ryan");
		contactService.updateLastName("12345", "Braun");
		contactService.updatePhone("12345", "6312221111");
		contactService.updateAddress("12345", "23 Schooner Path");
		
		assertTrue(contactService.getContact("12345").getFirstName().equals("Ryan"));
		assertTrue(contactService.getContact("12345").getLastName().equals("Braun"));
		assertTrue(contactService.getContact("12345").getPhone().equals("6312221111"));
		assertTrue(contactService.getContact("12345").getAddress().equals("23 Schooner Path"));
	}
}
