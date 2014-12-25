package com.gwt.kyu.server;

import java.util.HashMap;
import java.util.Set;

public class ListBoxOperation {
	public HashMap<String, String[]> getCityList() {
		HashMap<String, String[]> hm = new HashMap<String, String[]>();
		hm.clear();
		String[] france = { "Paris", "Lyon", "Marseille", "Nice", "Toulouse",
				"Nantes" };
		String[] italy = { "Rome", "Milan", "Florence", "Naples" };
		String[] netherlands = { "Amsterdam", "Rotterdam", "Groningen" };
		String[] spain = { "Madrid", "Barcelona", "Valencia", "Sevilla",
				"Bilbao" };
		String[] turkey = { "Istanbul", "Ankara", "Izmir", "Bursa", "Antalya",
				"Trabzon" };
		String[] unitedKingdom = { "London", "Birmingham", "Liverpool",
				"Manchester","Everton" };
		String[] usa = { "New York", "Los Angeles", "Chicago", "Houston",
				"Philadelphia" };
		hm.put("France", france);
		hm.put("Italy", italy);
		hm.put("Netherlands", netherlands);
		hm.put("Spain", spain);
		hm.put("Turkey", turkey);
		hm.put("United Kingdom", unitedKingdom);
		hm.put("U.S.A.", usa);
		return hm;
	}

	public String[] getCities(String Country) {
		String[] citiesArray = null;
		HashMap<String, String[]> hm = getCityList();
		Set<String> keys = hm.keySet();
		for (String key : keys) {
			if (key.equals(Country)) {
				citiesArray = hm.get(key);
				break;
			}
		}
		return citiesArray;
	}

	public boolean validateFirstName(String firstName) {
		return firstName.matches("[a-zA-Z][a-zA-Z]*");
	} 

	// validate last name
	public boolean validateLastName(String lastName) {
		return lastName.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
	}
}
