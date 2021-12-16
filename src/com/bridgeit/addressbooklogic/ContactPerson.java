package com.bridgeit.addressbooklogic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.github.cliftonlabs.json_simple.JsonObject;
import com.opencsv.CSVWriter;

public class ContactPerson {

	static int value;
	private static final String HOME = "data/addressBook.txt";
	private static final String HOME_ONE = "data/addresses.csv";
	private static final String MY_JSON = "data/addresses.json";

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
					System.out.println("enter phone number");
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
					.map(Map.Entry::getValue).collect(Collectors.toList());

			switch (num) {

			case 1:
				System.out.println("enter city name to search person ");
				String city = scanner.next();

				arrlist.stream().forEach(
						list -> list.stream().filter(ad -> ad.getCityName().equals(city)).forEach(ad -> System.out
								.println("city matched name : " + city + " and person name : " + ad.getFirstName())));
				// arrlist.stream().filter(list ->)
				break;
			case 2:
				System.out.println("enter state name to search person ");
				String state = scanner.next();
				arrlist.stream().forEach(list -> list.stream().forEach(ad -> {
					if (ad.getStateName().equals(state))
						System.out.println("city matched name : " + state + " and person name : " + ad.getFirstName());
				}));
				break;
			}
			if (num == 3) {
				break;
			}
		}
	}

	// sorting the address by contact name
	public void sortingAddresses() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("enter 1 : for sorting by person name \n enter 2 : for sorting by city name \n"
				+ " enter 3 : for sorting by state name  \n enter 4 : for sorting by zip ");
		int num = scanner.nextInt();
		switch (num) {
		case 1:
			List<AddressBook> sortedMap = multipleAddressBooks.mapBook.entrySet().stream().map(Map.Entry::getValue)
					.flatMap(list -> list.stream()
							.sorted((ad1, ad2) -> ad1.getFirstName().compareTo(ad2.getFirstName())))
					.collect(Collectors.toList());
			System.out.println(sortedMap);
			break;
		case 2:
			List<AddressBook> sortedMap2 = multipleAddressBooks.mapBook.entrySet().stream().map(Map.Entry::getValue)
					.flatMap(list -> list.stream().sorted((ad1, ad2) -> ad1.getCityName().compareTo(ad2.getCityName())))
					.collect(Collectors.toList());
			System.out.println(sortedMap2);
			break;
		case 3:
			List<AddressBook> sortedMap3 = multipleAddressBooks.mapBook.entrySet().stream().map(Map.Entry::getValue)
					.flatMap(list -> list.stream()
							.sorted((ad1, ad2) -> ad1.getStateName().compareTo(ad2.getStateName())))
					.collect(Collectors.toList());
			System.out.println(sortedMap3);
			break;
		case 4:
			List<AddressBook> sortedMap4 = multipleAddressBooks.mapBook.entrySet().stream().map(Map.Entry::getValue)
					.flatMap(list -> list.stream().sorted((ad1, ad2) -> ad1.getZip().compareTo(ad2.getZip())))
					.collect(Collectors.toList());
			System.out.println(sortedMap4);

			break;
		}
	}

	public void writeInputFile() throws IOException {

		StringBuffer stringBuffer = new StringBuffer();

		List<String> list = multipleAddressBooks.mapBook.entrySet().stream().map(Map.Entry::getKey)
				.collect(Collectors.toList());
		for (String string : list) {
			multipleAddressBooks.mapBook.entrySet().stream().filter(map -> map.getKey().contains(string))
					.map(value -> value.getValue()).forEach(list1 -> {
						list1.stream().forEach(ad -> {
							String str = ad.toString().concat("\n");
							stringBuffer.append(str);
						});
					});
		}
		PrintWriter printWriter = new PrintWriter(HOME);
		printWriter.write(stringBuffer.toString());
		printWriter.close();
		System.out.println("successfully write into file");
	}

	@SuppressWarnings("resource")
	public void readDatafromFile() throws IOException {
		FileReader fileReader = new FileReader(HOME);
		int ch;
		while ((ch = fileReader.read()) != -1) {
			System.out.print((char) ch);
		}
	}

	// for storing the address into multiple Address books
	public void multiAddressBooks(String person, ArrayList<AddressBook> addreses2) {

		multipleAddressBooks.mapBook.put(person, ContactPerson.addreses);
		System.out.println(multipleAddressBooks.mapBook);
	}

	public void writeCSVFile() throws IOException {

		List<String[]> stringslist = new ArrayList<>();
		PrintWriter printWriter = new PrintWriter(HOME_ONE);
		CSVWriter csvWriter = new CSVWriter(printWriter);

		multipleAddressBooks.mapBook.entrySet().stream().map(Map.Entry::getValue)
				.forEach(list -> list.stream().forEach(ad -> {
					stringslist.add(new String[] { ad.getFirstName(), ad.getLastName(), ad.getAddress(),
							ad.getCityName(), ad.getStateName(), ad.getZip(), ad.getPhoneNumber() });
				}));
		csvWriter.writeAll(stringslist);
		csvWriter.close();
		System.out.println("....successfully Write into csv file....");

	}

	public void readCSVFile() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(HOME_ONE));
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] addressArray = line.split(",");
			System.out.println("AddressBook [firstName=" + addressArray[0] + ", lastName=" + addressArray[1]
					+ ", address=" + addressArray[2] + ", cityName=" + addressArray[3] + ", stateName="
					+ addressArray[4] + ", zip=" + addressArray[5] + ", phoneNumber=" + addressArray[6] + "]");
		}
	}

	@SuppressWarnings("unchecked")
	public void writeDataToJason() {

		JSONObject jsonObject = new JSONObject();
		JSONObject jsonObject2 = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		multipleAddressBooks.mapBook.entrySet().stream().map(Map.Entry::getValue)
				.forEach(list -> list.stream().forEach(ad -> {
					jsonObject.put("firstName", ad.getFirstName());
					jsonObject.put("lastName", ad.getLastName());
					jsonObject.put("address", ad.getAddress());
					jsonObject.put("cityName", ad.getCityName());
					jsonObject.put("stateName", ad.getStateName());
					jsonObject.put("zip", ad.getZip());
					jsonObject.put("phoneNumber", ad.getPhoneNumber());
					jsonObject2.put("AddressBook", jsonObject);
					jsonArray.add(jsonObject2);
				}));

		try (FileWriter printWriter = new FileWriter(MY_JSON)) {
			printWriter.write(jsonArray.toJSONString());
			printWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void readDataFromJason() {

		JSONParser jsonParser = new JSONParser();
		try (FileReader fileReader = new FileReader(MY_JSON)) {
			Object obj = jsonParser.parse(fileReader);
			JSONArray jsonArray = (JSONArray) obj;
			System.out.println(jsonArray.toJSONString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
