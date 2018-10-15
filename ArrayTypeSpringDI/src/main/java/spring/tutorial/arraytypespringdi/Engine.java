package spring.tutorial.arraytypespringdi;

import java.util.Arrays;

public class Engine {
	String[] models;

	@Override
	public String toString() {
		return "Engine [models=" + Arrays.toString(models) + "]";
	}

	public String[] getModels() {
		return models;
	}

	public void setModels(String[] models) {
		this.models = models;
	}
	
	
}
