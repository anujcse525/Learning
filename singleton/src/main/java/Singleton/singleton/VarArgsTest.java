package Singleton.singleton;

public class VarArgsTest {

	public static float average(int... arg) {
		float avg = 0f;
		int n = arg.length;
		for (int abc : arg) {
			avg += abc;
		}
		return avg/n;
	}

	public static void main(String[] args) {
		System.out.println(average(1, 2, 3, 4, 5, 6));
	}

}
