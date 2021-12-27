package com.bridgeit.addressbooklogic;

import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {

	public final static int EXIT = 2;
	public final static int EXIT_TWO = 13;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		MultipleAddressBooks multipleAddressBooks = MultipleAddressBooks.getInstance();
		FileIOService readAndWriteData = new FileIOService();

		System.out.println("....................welcome to the address book program..........................");
		Scanner scanner = new Scanner(System.in);
		int exitTwo = 0;
		while (exitTwo != EXIT_TWO) {

			ContactPerson contactPerson = new ContactPerson();
			AddressBook addressBook = new AddressBook();
			UserInterface userInterface = new UserInterface();

			System.out.println("enter one to create a address book : ");
			int check = scanner.nextInt();
			String person = null;

			if (check == 1) {
				System.out.println("enter an adress book name : ");
				person = scanner.next();
			}
			int num = userInterface.showUserMenu();
			switch (num) {
			case 1:
				int exit = 0;
				while (exit != EXIT) {

					System.out.println("enter 1 : for adding address \n enter " + EXIT + " : for exit");
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
				contactPerson.multiAddressBooks(person, ContactPerson.addreses);
				break;
			case 2:
				// contactPerson.updateContact();
				System.out.println("enter address book name to update contact : ");
				String bookName = scanner.next();
				System.out.println("enter a first name to update contact ");
				String name = scanner.next();
				contactPerson.updateContactConditionally(books -> books.getFirstName().equals(name), bookName, 1);
				break;
			case 3:
				System.out.println("enter address book name to delete address : ");
				String bookName1 = scanner.next();
				System.out.println("enter a first name to delete contact ");
				String name1 = scanner.next();
				contactPerson.updateContactConditionally(books -> books.getFirstName().equals(name1), bookName1, 2);
				break;
			case 4:
				contactPerson.searchCityState();
				break;
			case 5:
				userInterface.printBooks(multipleAddressBooks);
				break;
			case 6:
				contactPerson.sortingAddresses();
				break;
			case 7:
				readAndWriteData.writeTxtData.writeDataIntoFile();
				break;
			case 8:
				readAndWriteData.readTxtData.readDataFromFile();
				break;
			case 9:
				readAndWriteData.writeCSVData.writeDataIntoFile();
				break;
			case 10:
				readAndWriteData.readCSVData.readDataFromFile();
				break;
			case 11:
				readAndWriteData.writeJSONData.writeDataIntoFile();
				break;
			case 12:
				readAndWriteData.readJSONData.readDataFromFile();
				break;
			case EXIT_TWO:

				exitTwo = EXIT_TWO;
				System.out.println("..................END...................");
				break;
			}
			System.out.println();
		}
	}
}
