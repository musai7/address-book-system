package com.bridgeit.addressbooklogic;

import java.util.Scanner;

public class AddressBookMain {

	public final static int EXIT = 5;
	public final static int EXIT_TWO = 4;


	public static <T> void main(String[] args) {

		MultipleAddressBooks multipleAddressBooks = new MultipleAddressBooks();
		System.out.println("....................welcome to the address book program..........................");
		Scanner scanner = new Scanner(System.in);
		int exit2=0;
		while (exit2 != EXIT_TWO) {
			
			ContactPerson<Object> contactPerson = new ContactPerson<>();
			AddressBook addressBook = new AddressBook();
			System.out.println("enter adress book name of a person");
			String person = scanner.next();
	
			System.out.println("\n enter 1 : for add multiple address books \n enter 2 : for print multipleBoks\n enter 3 : for search city or state  \n enter "+ EXIT_TWO +" : for exit \n ");
			int num = scanner.nextInt();

			switch (num) {
			case 1:
				int exit = 0;
				while (exit != EXIT) {

					System.out.println(
							"enter 1 : for adding \n enter 2 : for modify the contact details \n enter 3 for delate contact  "
									+ "\n enter 4 : for multiple address books \n enter " + EXIT + " : for exit");
					int num1 = scanner.nextInt();
					exit = num1;

					switch (num1) {

					case 1:
						System.out.println("enter a name to check contact excists or not ");
						String name1 = scanner.next();
						int count = contactPerson.dublicateAddress(name1, addressBook);
						if (count == 0) {
							addressBook = ContactPerson.inputContactDetails();
							contactPerson.addContact(addressBook);
							break;
						}
						break;
					case 2:
						System.out.println("enter a firsName of contact to modify");
						String name = scanner.next();
						contactPerson.updateContact(name, addressBook);
						break;
					case 3:
						System.out.println("enter a first name to delete contact ");
						String name2 = scanner.next();
						contactPerson.deleteContact(name2, addressBook);
						break;
					case EXIT:
						System.out.println("quit from the address book program");
						break;
					}
				}				
				multipleAddressBooks.mapBook.put(person, ContactPerson.addreses);
				System.out.println(multipleAddressBooks.mapBook);
				break;
			case 2:
				contactPerson.printBooks(multipleAddressBooks);
			case 3:
				contactPerson.searchCityState(multipleAddressBooks);
				break;
			case 4:
				exit2=4;
				break;
			}
		}
	}
}
