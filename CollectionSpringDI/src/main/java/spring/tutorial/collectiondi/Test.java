package spring.tutorial.collectiondi;

import java.util.Hashtable;
import java.util.TreeSet;
import java.util.Vector;

public class Test {
	Vector<String> fruits;
	TreeSet<String> cricketers;
	Hashtable<String, String> countryCap;

	public Vector<String> getFruits() {
		return fruits;
	}

	public void setFruits(Vector<String> fruits) {
		this.fruits = fruits;
	}

	public TreeSet<String> getCricketers() {
		return cricketers;
	}

	public void setCricketers(TreeSet<String> cricketers) {
		this.cricketers = cricketers;
	}

	public Hashtable<String, String> getCountryCap() {
		return countryCap;
	}

	public void setCountryCap(Hashtable<String, String> countryCap) {
		this.countryCap = countryCap;
	}

	@Override
	public String toString() {
		return "Test [fruits=" + fruits + ", cricketers=" + cricketers + ", countryCap=" + countryCap + "]";
	}

}
