package module3;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
	@Test
	public void testContactClass() {
		Contact contact = new Contact("12345", "Derek", "Nill", "5134231234", "42 Hawk Drive");
		assertTrue(contact.getContactID().equals("12345"));
		assertTrue(contact.getFirstName().equals("Derek"));
		assertTrue(contact.getLastName().equals("Nill"));
		assertTrue(contact.getPhone().equals("5134231234"));
		assertTrue(contact.getAddress().equals("42 Hawk Drive"));
	}
	
	@Test
	public void testContactIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345689100", "Derek", "Nill", "5134231234", "42 Hawk Drive");
		});
	}
	
	@Test
	public void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "DerekDerekD", "Nill", "5134231234", "42 Hawk Drive");
		});
	}
	
	@Test
	public void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Derek", "NillNillNill", "5134231234", "42 Hawk Drive");
		});
	}
	
	@Test
	public void testPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Derek", "Nill", "5134231234678678", "42 Hawk Drive");
		});
	}
	
	@Test
	public void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Derek", "Nill", "5134231234", "123451234512345123451234512345123451234512345");
		});
	}
	
	@Test
	public void testContactIDNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Derek", "Nill", "5134231234", "42 Hawk Drive");
		});
	}
	
	@Test
	public void testFirstNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", null, "Nill", "5134231234", "42 Hawk Drive");
		});
	}
	
	@Test
	public void testLastNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Derek", null, "5134231234", "42 Hawk Drive");
		});
	}
	
	@Test
	public void testPhoneNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Derek", "Nill", null, "42 Hawk Drive");
		});
	}
	
	@Test
	public void testAddressNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345", "Derek", "Nill", "5134231234", null);
		});
	}
}
