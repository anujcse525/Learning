package spring.tutorial.arraytypespringdi;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class Car {

	String carCompany;
	Engine[] engines;

	Vector en = new Stack<Engine>();
	public String getCarCompany() {
		return carCompany;
	}

	public void setCarCompany(String carCompany) {
		this.carCompany = carCompany;
	}

	public Engine[] getEngines() {
		return engines;
	}

	public void setEngines(Engine[] engines) {
		this.engines = engines;
	}

	@Override
	public String toString() {
		return "Car [carCompany=" + carCompany + ", engine=" + Arrays.toString(engines) + "]";
	}

	
	
}
