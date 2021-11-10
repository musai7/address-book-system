package com.bridgeit.addressbooklogic;

import java.util.Scanner;

public class AddressBook {

	private final String firstName;
	private final String lastName;
	private final String address;
	private final String cityName;
	private final String stateName;
	private final String zip;
	private String phoneNumber;

	public AddressBook(String firstName, String lastName, String address, String cityName, String stateName, String zip,
			String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getCityName() {
		return cityName;
	}

	public String getStateName() {
		return stateName;
	}

	public String getZip() {
		return zip;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	@Override
	public String toString() {
		return "AddressBook [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", cityName="
				+ cityName + ", stateName=" + stateName + ", zip=" + zip + ", phoneNumber=" + phoneNumber + "]";
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
		System.out.println("stste name : ");
		String stateName = scanner.next();
		System.out.println("zip : ");
		String zip = scanner.next();
		System.out.println("phone number : ");
		String phoneNumber = scanner.next();
		AddressBook addressBook = new AddressBook(firstName, lastName, address, cityName, stateName, zip,
				phoneNumber);
		return addressBook;
	}

	public static void main(String[] args) {
		
		System.out.println("welcome to the address book program");
		AddressBook addressBook =contactPerson();
		System.out.println(addressBook);		
	}
}
