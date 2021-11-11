package com.bridgeit.addressbooklogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactPerson {
	
	public List<AddressBook> addreses;
	
	public ContactPerson() {
		addreses = new ArrayList();
	}
	
	public void addContact(AddressBook addressBook) {
		addreses.add(addressBook);
		System.out.println(addreses);
	}

	public static AddressBook contactPerson() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("first name : ");
		String firstName = scanner.next();
		System.out.println("last name : ");
		String lastName = scanner.next();
		System.out.println("address : ");
		String address = scanner.next();
		System.out.println("city name : ");
		String cityName = scanner.next();
		System.out.println("state name : ");
		String stateName = scanner.next();
		System.out.println("zip : ");
		String zip = scanner.next();
		System.out.println("phone number : ");
		String phoneNumber = scanner.next();
		AddressBook addressBook = new AddressBook(firstName, lastName, address, cityName, stateName, zip, phoneNumber);
		return addressBook;
	}

	public void updateDetails(String name,AddressBook addressBook) {
		
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<addreses.size();i++) {
			if (addressBook.getFirstName().equals(name)) {
				System.out.println("enter phone number");
				String number = scanner.next();
				addressBook.setPhoneNumber(number);
			}
		}
		System.out.println(addreses);
	}
	
	public void deleteContact(String name,AddressBook addressBook) {
		for(int i=0;i<addreses.size();i++) {
			if(addressBook.getFirstName().equals(name)) {
				addreses.remove(i);
			}
		}
		System.out.println(addreses);
	}

	public static void main(String[] args) {

		System.out.println("welcome to the address book program");
		AddressBook addressBook = contactPerson();
		ContactPerson contactPerson = new ContactPerson();
		contactPerson.addContact(addressBook);
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter a first name of contact to modify");
		String name = scanner.next();
		contactPerson.updateDetails(name,addressBook);
		System.out.println("enter a first name to delete contact ");
		String name1 = scanner.next();
		contactPerson.deleteContact(name,addressBook);
	}
}
