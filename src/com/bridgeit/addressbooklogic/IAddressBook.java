package com.bridgeit.addressbooklogic;

import java.util.function.Predicate;

public interface IAddressBook {

	public void addContact(AddressBook addressBook);

	public void updateContactConditionally(Predicate<AddressBook> predicate, String bookName, int num);

	public int checkUniqueFirstName(String name, AddressBook addressBook);

	public void searchCityState();

	public void sortingAddresses();
}
