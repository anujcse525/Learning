package com.anuj.java8feature;

import java.util.List;
import java.util.Set;

@FunctionalInterface
public interface FindAnagram {
	Set<Set<String>> findSetAnagram(List<String> words);
}
