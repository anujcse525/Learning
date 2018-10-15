package spring.tutorial.SpringLearning;

public class Test {
	private String email;
	private String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Test(String name, int age, String email) {
		this.name = name;
		this.age = age;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Test [email=" + email + ", name=" + name + ", age=" + age + "]";
	}

}
