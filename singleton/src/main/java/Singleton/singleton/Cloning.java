package Singleton.singleton;

class Person {
	private String name;
	private String city;
	
	public Person(String name, String city) {
		super();
		this.name = name;
		this.city = city;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", city=" + city + "]";
	}
	
	
}

class Employee implements Cloneable{
	private int salary;
	private Person person;
	
	public Employee(String name, String city, int sal) {
		this.person = new Person(name, city);
		this.salary = sal;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", person=" + person + "]";
	}
	
}

public class Cloning {

	public static void main(String[] args) {
		Employee emp = new Employee("anuj", "BLR", 1000);
		Employee clonedEmp = null;
		try {
			clonedEmp = (Employee) emp.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		System.out.println(emp);
		System.out.println(clonedEmp);

		System.out.println("After cloning");
		clonedEmp.getPerson().setName("kumar");;
		System.out.println(emp);
		System.out.println(clonedEmp);
	}

}
