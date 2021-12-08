package com.bridgeit.addressbooklogic;

public interface IAddressBook {
	
	public void addContact(AddressBook addressBook);
	
	public void updateContact();
	
	public void deleteContact();
	
	public int checkUniqueFirstName(String name,AddressBook addressBook);
}
