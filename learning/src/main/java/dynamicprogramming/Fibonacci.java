package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

	public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	static {
		map.put(0, 0);
		map.put(1, 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Fibo == " + getFibonacci(1000));
	}

	public static int getFibonacci(int num) {
		if (map.containsKey(num))
			return map.get(num);

		map.put(num -1, getFibonacci(num -1));
		map.put(num -2, getFibonacci(num -2));
		
		int result = map.get(num -1) + map.get(num -2);
		
		 map.put(num ,result);
		 return map.get(num);

	}
}
