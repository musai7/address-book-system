package com.bridgeit.addressbooklogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactPerson<T> implements IAddressBook {

	static int value;
	public static List<AddressBook> addreses;

	public ContactPerson() {
		addreses = new ArrayList<>();
	}
	
	public List<AddressBook> getAddreses() {
		return addreses;
	}

	public void setAddreses(List<AddressBook> addreses) {
		this.addreses = addreses;
	}

	public void addContact(AddressBook addressBook) {

		// added new contact into list
		addreses.add(addressBook);
		System.out.println(addreses);
	}

	public static AddressBook inputContactDetails() {

		Scanner scanner = new Scanner(System.in);
		System.out.println(" enter first name : ");
		String firstName = scanner.next();
		System.out.println("enter last name : ");
		String lastName = scanner.next();
		System.out.println(" enter address : ");
		String address = scanner.next();
		System.out.println("enter city name : ");
		String cityName = scanner.next();

		System.out.println("enter state name : ");
		String stateName = scanner.next();
		System.out.println("zip : ");
		String zip = scanner.next();
		System.out.println("enter phone number : ");
		String phoneNumber = scanner.next();
		AddressBook addressBook = new AddressBook(firstName, lastName, address, cityName, stateName, zip, phoneNumber);
		return addressBook;
	}

	public void updateContact(String name, AddressBook addressBook) {
		// updated the phone number of existing contact
		int count = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter phone number : ");
		String number = scanner.next();
		for (int i = 0; i < addreses.size(); i++) {
			if (addressBook.getFirstName().equals(name)) {
				addressBook.setPhoneNumber(number);
				count++;
			}
		}
		if (count == 0) {
			System.out.println(name + " contact not existed ");
		}
		System.out.println(addreses);
	}

	public void deleteContact(String name, AddressBook addressBook) {

		// delete the matched contact
		for (int i = 0; i < addreses.size(); i++) {
			if (addressBook.getFirstName().equals(name)) {
				addreses.remove(i);
			}
		}
		System.out.println(addreses);
	}

	public int dublicateAddress(String name, AddressBook addressBook) {
		int count = 0;
		for (int i = 0; i < addreses.size(); i++) {
			if(addressBook.getFirstName() == null) {
				return 0;
			}
			else if (addressBook.getFirstName().equals(name)) {
				count++;
			}
		}
		return count;
	}

	public void multiAddressBooks(MultipleAddressBooks book) {
		
		book.mapBook.put("person1", addreses);
		
	}

	public void printBooks(MultipleAddressBooks multipleAddressBooks) {

		System.out.println(multipleAddressBooks.mapBook);
	}
}
