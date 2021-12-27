package com.bridgeit.addressbooklogic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.opencsv.CSVWriter;

public class FileIOService {

	MultipleAddressBooks multipleAddressBooks = MultipleAddressBooks.getInstance();

	// Write The Data Of Address Book Into Text File...
	IWriteData writeTxtData = () -> {
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
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(ContactPerson.TEXT_FILE);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		printWriter.append(stringBuffer.toString());
		printWriter.close();
		System.out.println("successfully write into file");
	};

	// Read The Data Of Address Book From Text File...
	IReadData readTxtData = () -> {
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(ContactPerson.TEXT_FILE);
			int ch;
			while ((ch = fileReader.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	// Write The Data Of Address Book Into CSV File...

	IWriteData writeCSVData = () -> {

		List<String[]> stringslist = new ArrayList<>();
		PrintWriter printWriter;
		try {
			printWriter = new PrintWriter(ContactPerson.CSV_FILE);
			CSVWriter csvWriter = new CSVWriter(printWriter);
			stringslist
					.add(new String[] { "FirstName", "LastName", "Address", "CityName", "StateName", "PhoneNumber" });

			multipleAddressBooks.mapBook.entrySet().stream().map(Map.Entry::getValue)
					.forEach(list -> list.stream()
					.forEach(ad -> {
						stringslist.add(new String[] { ad.getFirstName(), ad.getLastName(), ad.getAddress(),
								ad.getCityName(), ad.getStateName(), ad.getZip(), ad.getPhoneNumber() });
					}));
			csvWriter.writeAll(stringslist);
			csvWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("....successfully Write into csv file....");
	};

	IReadData readCSVData = () -> {

		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(ContactPerson.CSV_FILE));
			String line = "";
			int num = 0;
			while ((line = br.readLine()) != null) {
				if (num == 0) {
					num++;
					continue;
				}
				String[] addressArray = line.split(",");
				System.out.println("AddressBook [firstName=" + addressArray[0] + ", lastName=" + addressArray[1]
						+ ", address=" + addressArray[2] + ", cityName=" + addressArray[3] + ", stateName="
						+ addressArray[4] + ", zip=" + addressArray[5] + ", phoneNumber=" + addressArray[6] + "]");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	@SuppressWarnings("unchecked")
	IWriteData writeJSONData = () -> {

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

		try (FileWriter printWriter = new FileWriter(ContactPerson.JSON_FILE)) {
			printWriter.write(jsonArray.toJSONString());
			printWriter.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("....successfully Write into JSON file....");
	};

	IReadData readJSONData = () -> {

		JSONParser jsonParser = new JSONParser();
		try (FileReader fileReader = new FileReader(ContactPerson.JSON_FILE)) {
			Object obj = jsonParser.parse(fileReader);
			JSONArray jsonArray = (JSONArray) obj;
			System.out.println(jsonArray.toJSONString());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	};
}
