package com.crm.qa.util;

import java.util.HashMap;
import java.util.Map;

public class MyMapAssert {
	
	Map<String, String> expectedMap = new HashMap();
	Map<String, String> actualMap = new HashMap();
	
	private static final String KEY1 = "TITLE";
	private static final String KEY2 = "COMPANY";
	
	public boolean compareMaps() {
		
		expectedMap.put(KEY1, "TitleTest1");
		expectedMap.put(KEY2, "CompanyTest1");
		
		actualMap.put(KEY1, "TitleTest11");
		actualMap.put(KEY2, "CompanyTest1");
		
		Boolean mapsEqualFlag = expectedMap.equals(actualMap);
		
		return mapsEqualFlag;
		
	}
	
	public void mapDifference() {
		System.out.println("There is difference between Expected Map and Actual one.");
		for (String key: expectedMap.keySet()) {
			if (!expectedMap.get(key).equalsIgnoreCase(actualMap.get(key))) {
				System.out.println(key +": Expected is " + expectedMap.get(key) + ". But Actual is " + actualMap.get(key) + ".");
			}
		}
	}
	
		
	public static void main(String[] args) {
		MyMapAssert obj = new MyMapAssert();
		if (obj.compareMaps()) {
			System.out.println("Maps same");
		}else {
			obj.mapDifference();
		}

	}

}
