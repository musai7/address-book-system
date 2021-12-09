package com.bridgeit.addressbooklogic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContactPerson {

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

	void updateContactConditionally(Predicate<AddressBook> predicate, String bookName, int num) {

		List<ArrayList<AddressBook>> arrlist = multipleAddressBooks.mapBook.entrySet().stream()
				.filter(k -> k.getKey().contains(bookName)).map(Map.Entry::getValue).collect(Collectors.toList());
		List<AddressBook> list = arrlist.get(0);
		System.out.println(arrlist);

		if (num == 1) {
			Scanner sc = new Scanner(System.in);
			for (AddressBook book : list) {
				if (predicate.test(book)) {
					book.setPhoneNumber(sc.next());
					break;
				}
			}
		}
		if (num == 2) {
			list.removeIf(predicate);
			System.out.println(list);
			multipleAddressBooks.mapBook.replace(bookName, (ArrayList<AddressBook>) list);
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
			List<ArrayList<AddressBook>> arrlist = multipleAddressBooks.mapBook.entrySet().stream()
					.map(Map.Entry::getValue)
					.collect(Collectors.toList());
			switch (num) {

			case 1:
				System.out.println("enter city name to search person ");
				String city = scanner.next();
				
				
				arrlist.stream().forEach(list -> list.stream().forEach(ad -> {
					if(ad.getCityName().equals(city))
						System.out.println("city matched name : " + city + " and person name : "+ad.getFirstName());
				}));
				break;
			case 2:
				System.out.println("enter state name to search person ");
				String state = scanner.next();
				arrlist.stream().forEach(list -> list.stream().forEach(ad -> {
					if(ad.getStateName().equals(state))
						System.out.println("city matched name : " + state + " and person name : "+ad.getFirstName());
				}));
				break;
			}
			if (num == 3) {
				break;
			}
		}
	}
	
	//sorting the address by contact name
	public void sortingAddresses() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter 1 : for sorting by person name \n enter 2 : for sorting by city name \n"
				+ " enter 3 : for sorting by state name  \n enter 4 : for sorting by zip ");
		int num = scanner.nextInt();
		switch(num) {
		case 1 :
			List<AddressBook> sortedMap =  multipleAddressBooks.mapBook.entrySet().stream()
					.map(Map.Entry::getValue).flatMap(list -> list.stream()
					.sorted((ad1,ad2) -> ad1.getFirstName().compareTo(ad2.getFirstName()))).collect(Collectors.toList());
			System.out.println(sortedMap);
			break;
		case 2 :
			List<AddressBook> sortedMap2 =multipleAddressBooks.mapBook.entrySet().stream()
			.map(Map.Entry::getValue).flatMap(list -> list.stream()
			.sorted((ad1,ad2) -> ad1.getCityName().compareTo(ad2.getCityName()))).collect(Collectors.toList());
			System.out.println(sortedMap2);
			break;
		case 3 :
			List<AddressBook> sortedMap3 =multipleAddressBooks.mapBook.entrySet().stream()
			.map(Map.Entry::getValue).flatMap(list -> list.stream()
			.sorted((ad1,ad2) -> ad1.getStateName().compareTo(ad2.getStateName())))
			.collect(Collectors.toList());
			System.out.println(sortedMap3);
			break;
		case 4 :
			List<AddressBook> sortedMap4 =multipleAddressBooks.mapBook.entrySet().stream()
			.map(Map.Entry::getValue).flatMap(list -> list.stream()
			.sorted((ad1,ad2) -> ad1.getZip().compareTo(ad2.getZip())))
			.collect(Collectors.toList());
			System.out.println(sortedMap4);

			break;
		}
	}

	// for storing the address into multiple Address books
	public void multiAddressBooks(String person, ArrayList<AddressBook> addreses2) {

		multipleAddressBooks.mapBook.put(person, ContactPerson.addreses);
		System.out.println(multipleAddressBooks.mapBook);
	}
}
