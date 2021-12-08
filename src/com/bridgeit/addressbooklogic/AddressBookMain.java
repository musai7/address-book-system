package com.bridgeit.addressbooklogic;

import java.util.Scanner;

public class AddressBookMain {

	public final static int EXIT = 2;
	public final static int EXIT_TWO = 6;


	public static void main(String[] args) {

		MultipleAddressBooks multipleAddressBooks = MultipleAddressBooks.getInstance();
		
		System.out.println("....................welcome to the address book program..........................");
		Scanner scanner = new Scanner(System.in);
		int exitTwo=0;
		while (exitTwo != EXIT_TWO) {
			
			ContactPerson contactPerson = new ContactPerson();
			AddressBook addressBook = new AddressBook();
			
			System.out.println("enter one to create a address book : ");
			int check = scanner.nextInt();
			String person = null ;
			
			if(check==1) {
				System.out.println("enter an adress book name : ");
				person = scanner.next();
			}
	
			System.out.println("\n enter 1 : for enter into an address book \n enter 2 : for modify the contact details \n enter 3 : for delate contact "
					+ "\n enter 4 : for search city or state \n enter 5 : for print multipleBoks \n enter "+ EXIT_TWO +" : for exit \n ");
			int num = scanner.nextInt();

			switch (num) {
			case 1:
				int exit = 0;
				while (exit != EXIT) {

					System.out.println(
							"enter 1 : for adding address \n enter " + EXIT + " : for exit");
					int num1 = scanner.nextInt();
					exit = num1;

					switch (num1) {

					case 1:
						System.out.println("enter a name to check contact excists or not ");
						String name = scanner.next();
						int count = contactPerson.checkUniqueFirstName(name, addressBook);
						if (count == 0) {
							addressBook = ContactPerson.inputContactDetails();
							contactPerson.addContact(addressBook);
						}
						break;
					case EXIT:
						System.out.println("quit from the address book program");
						break;
					}
				}
				contactPerson.multiAddressBooks(person,ContactPerson.addreses);
				break;
			case 2:
				contactPerson.updateContact();
				break;
			case 3:
				contactPerson.deleteContact();
				break;
			case 4:
				contactPerson.searchCityState();
				break;
			case 5:
				contactPerson.printBooks(multipleAddressBooks);
				break;
			case 6:
				exitTwo = EXIT_TWO;
				System.out.println("..................END...................");
				break;
			}
			System.out.println();
		}
	}
}
