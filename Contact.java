package module3;


public class Contact {

	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Maximum string length set as final attributes instead of putting magic numbers in the code.
	private final int maxLength = 10;
	private final int phoneLength = 10;
	private final int maxAddressLength = 30;
	
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		// First check to see if any of the inputs are null.
		if (contactID == null || firstName == null || lastName == null || phone == null || address == null) {
			// If they are null, throw an exception.
			throw new IllegalArgumentException("Input is null");
		}
		
		// Check to see if the provided contact ID is valid by calling the checkInput method.
		if (checkInput(contactID, maxLength)) {			
			this.contactID = contactID;
		}
		else {
			throw new IllegalArgumentException("Invalid Contact ID");
		}
		
		// Since the Set methods need to check the input when changing these attributes, I just call the methods
		// from here instead of writing the input checks again in the constructor.

		setFirstName(firstName);
		setLastName(lastName);
		setPhone(phone);
		setAddress(address);
		
	}
	
	// Helper method for checking the input length.
	private Boolean checkInput(String input, int maxLength) {
		return ((input.length() <= maxLength));
	}
	
	// Getters and Setters for every attribute except contact ID, which only has a getter.
	public String getContactID() {
		return contactID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		if (checkInput(firstName, maxLength) && firstName != null)  {
			this.firstName = firstName;
		}
		else {
			throw new IllegalArgumentException("Invalid First Name");
		}
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		if (checkInput(lastName, maxLength) && lastName != null) {
			this.lastName = lastName;
		}
		else {
			throw new IllegalArgumentException("Invalid Last Name");
		}
	}
	
	public String getPhone() {
		return phone;
	}
	
	// Phone Setter has a different check because the length of phone number must be exactly 10.
	public void setPhone(String phone) {
		if (phone.length() == phoneLength && phone != null) {
			this.phone = phone;
		}
		else {
			throw new IllegalArgumentException("Invalid Phone Number");
		}
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		if (checkInput(address, maxAddressLength) && address != null) {
			this.address = address;
		}
		else {
			throw new IllegalArgumentException("Invalid Address");
		}
	}
}

