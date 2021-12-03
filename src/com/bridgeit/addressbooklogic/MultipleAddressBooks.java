package com.bridgeit.addressbooklogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultipleAddressBooks {
	
	Map<String, ArrayList<AddressBook>> mapBook = new HashMap<>();

	@Override
	public String toString() {
		return "MultipleAddressBooks [mapBook=" + mapBook + "]";
	}
}
