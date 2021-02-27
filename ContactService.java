package module3;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
	// A map makes sense as the data structure for Contacts because we will need to lookup by contact ID
	private Map<String, Contact> contactMap = new HashMap<String, Contact>();
	
		
		public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
			// Contact IDs must be unique, check to see if contactID is used already.
			if (!contactMap.containsKey(contactID)) {
				contactMap.put(contactID, new Contact(contactID, firstName, lastName, phone, address));
			}
			else {
				throw new IllegalArgumentException("ContactID is already in use");
			}
		}
		
		public void deleteContact(String contactID) {
			contactMap.remove(contactID);
		}
		
		public void updateFirstName(String contactID, String firstName) {
			contactMap.get(contactID).setFirstName(firstName);
		}
		
		public void updateLastName(String contactID, String lastName) {
			contactMap.get(contactID).setLastName(lastName);
		}
		
		public void updatePhone(String contactID, String phone) {
			contactMap.get(contactID).setPhone(phone);
		}
		
		public void updateAddress(String contactID, String address) {
			contactMap.get(contactID).setAddress(address);
		}
		
		// Method for returning the Contact object for a given ContactID.
		public Contact getContact(String key) {
			return contactMap.get(key);
		}
}
