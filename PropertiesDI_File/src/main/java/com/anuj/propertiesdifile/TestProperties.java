package com.anuj.propertiesdifile;

import java.util.Properties;
import java.util.Set;

public class TestProperties {
	private Properties properties;

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public void printProperties() {
		Set props = properties.keySet();
		for(Object obj: props){
			System.out.println("Key : " + obj.toString() + " Value : " + properties.getProperty((String) obj));
		}
	}

}
