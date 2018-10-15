package com.anuj.propertiesdi;

import java.util.Properties;
import java.util.Set;

public class PropertiesTest {

	private Properties properties;
	
	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	public void printProperties(){
		Set keys = properties.keySet();
		for(Object key : keys){
			System.out.println("Key : " + key.toString() + " Value : " + properties.getProperty((String) key));
		}
	}
}
