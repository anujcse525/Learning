package com.accolite;

public enum Color {
	RED(20), GREEN(30), BLUE(40);
	int num;
	private Color(){
		
	}
	private Color(int abc) {
		System.out.println("Constructor " + this.toString());
		this.num = abc;
	}
	public static void main(String[] args) {
		Color cl = Color.BLUE;
		System.out.println(cl + ""+cl.num + Color.values());
		
		System.out.print("Y" + "O");
		System.out.println('A' + '1');
		int[] arr = {1, 2, 3, 4, 5};
		for(int i=0; i< arr.length; i++){
			System.out.println(arr[i]);
			continue;
			//System.out.println("abc");
		}
	}
}
