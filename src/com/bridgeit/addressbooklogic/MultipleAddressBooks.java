package com.bridgeit.addressbooklogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleAddressBooks {
	
	public static MultipleAddressBooks instance;
	Map<String, ArrayList<AddressBook>> mapBook = new HashMap<>();
	
	private MultipleAddressBooks() {
		
	}
	
	public static MultipleAddressBooks getInstance() {
		
		if(instance == null) {
			instance = new MultipleAddressBooks();
		}
		return instance;	
	}

	@Override
	public String toString() {
		return "MultipleAddressBooks [mapBook=" + mapBook + "]";
	}
}
