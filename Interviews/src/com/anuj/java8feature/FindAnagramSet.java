package com.anuj.java8feature;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.anuj.searching.FindRepeatedNumber;

class Words implements Comparable<Words>{
	int index;
	String word;
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Words(int index, String word) {
		super();
		this.index = index;
		this.word = word;
	}
	
	@Override
	public int compareTo(Words o) {
		return word.compareTo(o.word);
	}
	
}

public class FindAnagramSet {

	
	public static void main(String[] args) {
		FindAnagram findAna = (words) -> {
			Set<Set<String>> result = new HashSet<Set<String>>();
			Set<String> wordList = new HashSet<String>();
			
			for(String word : words){
				char[] wordChar = word.toCharArray();
				Arrays.sort(wordChar);
				wordList.add(new String(wordChar));
				
			}
			Collections.sort(words);
			return null;
		};
		
		List<String> words = new LinkedList<String>();
		words.add("cat");
		words.add("atc");
		words.add("dog");
		words.add("god");
		findAna.findSetAnagram(words);
		
		
	}
	
	
	
	

}
