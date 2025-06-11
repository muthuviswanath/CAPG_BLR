package com.capgemini.parameters;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
	static String value;
	public static  String getJsonData(String jsonPath, String key) {
		JSONParser parser = new JSONParser();
		try {
			FileReader jsonfile = new FileReader(jsonPath);
			Object obj = parser.parse(jsonfile);
			JSONObject jsonObject = (JSONObject) obj;
			value = (String) jsonObject.get(key);
		}
		catch (Exception e) {
			System.out.println("Error reading JSON file: " + e.getMessage());
		}
		if (value == null) {
			System.out.println("Key not found in JSON file: " + key);
			return null;
		} else {
			return value;
		}

	}
}