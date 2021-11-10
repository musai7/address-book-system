package com.bridgeit.addressbooklogic;

import java.util.Scanner;

public class AddressBook {

	private String firstName;
	private String lastName;
	private String address;
	private String cityName;
	private String stateName;
	private String zip;
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

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
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
		System.out.println("state name : ");
		String stateName = scanner.next();
		System.out.println("zip : ");
		String zip = scanner.next();
		System.out.println("phone number : ");
		String phoneNumber = scanner.next();
		AddressBook addressBook = new AddressBook(firstName, lastName, address, cityName, stateName, zip, phoneNumber);
		return addressBook;
	}

	public AddressBook updateDetails(String name,AddressBook addressBook) {

		if (firstName.equals(name)) {
			System.out.println(this.firstName);
			addressBook = contactPerson();
		}
		return addressBook;
	}

	public static void main(String[] args) {

		System.out.println("welcome to the address book program");
		AddressBook addressBook = contactPerson();
		System.out.println(addressBook);
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter a name");
		String name = scanner.next();
		addressBook = addressBook.updateDetails(name,addressBook);
		System.out.println(addressBook);
	}
}
