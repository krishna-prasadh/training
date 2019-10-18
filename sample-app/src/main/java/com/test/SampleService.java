package com.test;

import java.util.List;
import java.util.ArrayList;

public class SampleService {

	public List<String> getItems(String str) {

		List<String> arr = new ArrayList<String>();

		if (str.equals("Fruits")) {
			arr.add("Apple");
			arr.add("Custard apple");
			arr.add("Pine Apple");
		} else if (str.equals("Vegtables")) {
			arr.add("Potato");
			arr.add("Tomato");
			arr.add("Spinach");
		}
		else {
			arr.add("Snikkers");
			arr.add("5star");
			arr.add("Dairy milk");
		}
		return arr;
	}

}
