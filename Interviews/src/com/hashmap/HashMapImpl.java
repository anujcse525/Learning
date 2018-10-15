package com.hashmap;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapImpl {

	public static void main(String[] args) {

		HashMap<HashMapKey, String> map = new HashMap<HashMapKey, String>();
		HashMapKey key1 = new HashMapKey();
		key1.firstName = "anuj";
		key1.secondName = "kumar";
		HashMapKey key2 = new HashMapKey();
		key2.firstName = "Shweta";
		key2.secondName = "kumari";
		map.put(key1, "NBR");
		map.put(key2, "ABR");

		printMap(map);
		Set<Entry<HashMapKey, String>> entries = map.entrySet();
		for (Entry<HashMapKey, String> e : entries) {
			HashMapKey kk = e.getKey();
			kk.setFirstName(kk.getFirstName() + "111");
		}
		printMap(map);
	}

	public static void printMap(HashMap<HashMapKey, String> map){
		Set<Entry<HashMapKey, String>> entries = map.entrySet();
		for (Entry<HashMapKey, String> e : entries) {
			System.out.println(e.getKey() + " -- " + e.getValue());
		}
	}
}
