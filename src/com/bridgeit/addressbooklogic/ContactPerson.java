package com.bridgeit.addressbooklogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactPerson implements IAddressBook {

	static int value;
	public static ArrayList<AddressBook> addreses;
	MultipleAddressBooks multipleAddressBooks = MultipleAddressBooks.getInstance();

	public ContactPerson() {
		addreses = new ArrayList<>();
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

	public void updateContact() {
		// updated the phone number of existing contact

		int match = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.println("enter address book name to modify address : ");
		String bookName = scanner.next();
		System.out.println("enter a firsName of contact to modify");
		String name = scanner.next();
		System.out.println("enter phone number : ");
		String number = scanner.next();

		if (multipleAddressBooks.mapBook.containsKey(bookName)) {
			ArrayList<AddressBook> list = multipleAddressBooks.mapBook.get(bookName);
			for (AddressBook book : list) {
				if (book.getFirstName().equals(name)) {
					match++;
					book.setPhoneNumber(number);
					break;
				}
			}
			multipleAddressBooks.mapBook.replace(bookName, list);
		} else {
			System.out.println("address book not exists ");
		}
		if (match == 1) {
			System.out.println("updated the phone number");
		} else
			System.out.println("no match found");

	}

	public void deleteContact() {

		// delete the matched contact at specified book name
		int count = -1;
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter address book name to delete address : ");
		String bookName = scanner.next();
		System.out.println("enter a first name to delete contact ");
		String name = scanner.next();
		if (multipleAddressBooks.mapBook.containsKey(bookName)) {
			ArrayList<AddressBook> list = multipleAddressBooks.mapBook.get(bookName);
			for (AddressBook book : list) {
				count++;
				if (book.getFirstName().equals(name)) {
					list.remove(count);
					break;
				}
			}
			multipleAddressBooks.mapBook.replace(bookName, list);
		} else {
			System.out.println("address book not exists ");
		}
	}

	// its check for the existing list contains unique name
	public int checkUniqueFirstName(String name, AddressBook addressBook) {
		int count = 0;
		for (int i = 0; i < addreses.size(); i++) {
			if (addressBook.getFirstName() == null) {
				return 0;
			} else if (addressBook.getFirstName().equals(name)) {
				count++;
			}
		}
		return count;
	}

	public void printBooks(MultipleAddressBooks multipleAddressBooks) {

		System.out.println(multipleAddressBooks.mapBook);
	}

	public void searchCityState() {
		
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println(
					"enter 1 : for search a person by city name \n enter 2 : for search a person by state name  \n enter 3 : for exit ");
			int num = scanner.nextInt();
			int count = 0;
			switch (num) {

			case 1:
				System.out.println("enter city name to search person ");
				String city = scanner.next();
				for (List<AddressBook> entry : multipleAddressBooks.mapBook.values()) {
					for (AddressBook addressBook1 : entry) {
						if (addressBook1.getCityName().equals(city)) {
							System.out.println("city matched name : " + city + " and person name : "
									+ addressBook1.getFirstName());
							count++;
						}
					}
				}
				System.out.println("number of persons find by city name is : " + count);
				break;
			case 2:
				System.out.println("enter state name to search person ");
				String state = scanner.next();
				for (List<AddressBook> entry : multipleAddressBooks.mapBook.values()) {
					for (AddressBook addressBook1 : entry) {
						if (addressBook1.getStateName().equals(state)) {
							System.out.println("state matched : " + state + " and person name is : "
									+ addressBook1.getFirstName());
							count++;
						}
					}
				}
				System.out.println("number of persons find by state name is : " + count);
				break;
			}
			if (num == 3) {
				break;
			}
		}

	}

	// for storing the address into multiple Address books
	public void multiAddressBooks(String person, ArrayList<AddressBook> addreses2) {

		multipleAddressBooks.mapBook.put(person, ContactPerson.addreses);
		System.out.println(multipleAddressBooks.mapBook);
	}
}
