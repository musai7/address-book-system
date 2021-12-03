package com.bridgeit.addressbooklogic;

	public class AddressBook {

	private String firstName;
	private String lastName;
	private String address;
	private String cityName;
	private String stateName;
	private String zip;
	private String phoneNumber;

	public AddressBook() {
		
	}
	
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
}
