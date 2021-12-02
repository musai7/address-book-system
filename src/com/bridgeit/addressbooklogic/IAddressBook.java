package com.bridgeit.addressbooklogic;

public interface IAddressBook {
	
	public void addContact(AddressBook addressBook);
	
	public void updateContact(String name, AddressBook addressBook);
	
	public void deleteContact(String name, AddressBook addressBook);
	
	public int dublicateAddress(String name,AddressBook addressBook);
}
