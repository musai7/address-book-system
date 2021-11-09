package com.bridgeit.addressbooklogic;

public class AddressBook {

	private final String firstName;
	private final String lastName;
	private final String address;
	private final String cityName;
	private final String stateName;
	public final int zip;
	public final long phoneNumber;
	private final String emailID;

	public AddressBook(String firstName, String lastName, String address, String cityName, String stateName, int zip,
			long phoneNumber, String emailID) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.cityName = cityName;
		this.stateName = stateName;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.emailID = emailID;
	}

	public static void main(String[] args) {
		System.out.println("welcome to the address book program");
	}

}
