package spring.tutorial.SecondaryTypeSpringDI;

public class Engine {

	private String carModelYear;

	public String getCarModelYear() {
		return carModelYear;
	}

	public void setCarModelYear(String carModelYear) {
		this.carModelYear = carModelYear;
	}

	@Override
	public String toString() {
		return "Engine [carModelYear=" + carModelYear + "]";
	}
	
}