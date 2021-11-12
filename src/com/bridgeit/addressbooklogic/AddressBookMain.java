package com.bridgeit.addressbooklogic;

import java.util.Scanner;

public class AddressBookMain {
	public static void main(String[] args) {

		System.out.println("welcome to the address book program ");
		AddressBook addressBook = new AddressBook(null, null, null, null, null, null, null);
		ContactPerson contactPerson = new ContactPerson();
		Scanner scanner = new Scanner(System.in);
		int exit = 0;
		
		while (exit != 4) {
			
			System.out.println(
					"for adding enter : 1 \n for updating enter : 2 \n for deletion enter : 3 \n enter 4 for exit ");
			int num = scanner.nextInt();
			exit = num;
			
			switch (num) {
			
				case 1:
					addressBook = ContactPerson.inputContactDetails();
					contactPerson.addContact(addressBook);
					break;
				case 2:
					System.out.println("enter a firsName of contact to modify");
					String name = scanner.next();
					contactPerson.updateContact(name, addressBook);
					break;
				case 3:
					System.out.println("enter a first name to delete contact ");
					String name1 = scanner.next();
					contactPerson.deleteContact(name1, addressBook);
					break;
				case 4 :
					System.out.println("quit from the address book program");
					System.out.println(contactPerson.addreses);
					break;
			}
		}
	}
}
