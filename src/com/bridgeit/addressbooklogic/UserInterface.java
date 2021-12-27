package com.bridgeit.addressbooklogic;

import java.util.Scanner;

public class UserInterface {
	
	@SuppressWarnings("resource")
	public int showUserMenu() {
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"\n enter 1 : for enter into an address book \n enter 2 : for modify the contact details \n enter 3 : for delate contact "
						+ "\n enter 4 : for search city or state \n enter 5 : for print multipleBoks"
						+ " \n enter 6 : for sorting address \n enter 7 : for write the data into file \n enter 8 : for read the data from file "
						+ "\n enter 9 : for write the data into CSV file \n enter 10 : for read the data from CSV file "
						+ " \n enter 11 : for write the data into JSON file " + " \n enter 12 : for read the data from JSON file "
						+ "\n enter " + AddressBookMain.EXIT_TWO + " : for exit \n ");
		int num = scanner.nextInt();
		return num;	
	}
	
	public void printBooks(MultipleAddressBooks multipleAddressBooks) {

		System.out.println(multipleAddressBooks.mapBook);
	}
}
