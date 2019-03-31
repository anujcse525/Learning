package com.anuj.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastExample {
	public static void main(String[] args) {
		// Creating an ArrayList of integers

		ArrayList<Integer> list = new ArrayList<Integer>();
		CopyOnWriteArrayList<Integer> cwa = new CopyOnWriteArrayList<Integer>();
		cwa.add(555);
		cwa.addIfAbsent(666);
		cwa.add(777);
		Iterator<Integer> itr = cwa.iterator();
		while(itr.hasNext()){
			Integer in = itr.next();
			cwa.add(888);
			if(in == 555)
			cwa.remove(in);
		}
		
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
		map.put(22, 333);
		map.put(33, 444);
		map.put(44, 666);
		
		Iterator<Integer> mapItr = map.keySet().iterator();
		while(mapItr.hasNext()){
			Integer entry = mapItr.next();
			System.out.println(entry);
			map.remove(44);
		}
		// Adding elements to list

		list.add(1452);

		list.add(6854);

		list.add(8741);

		list.add(6542);

		list.add(3845);

		// Getting an Iterator from list

		Iterator<Integer> it = list.listIterator();
		System.out.println(list.size());
		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			if (integer == 8741)
				it.remove();
			
			// list.add(8457); // This will throw
			// ConcurrentModificationException
		}
		System.out.println(list.size());
	}
}
