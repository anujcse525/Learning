package com.trickyquestions;

public class StringObjectNull {
	/*
	 * public static void main(String[] args) { foo(null); }
	 * 
	 * public static void foo(Object o) { System.out.println("Object impl"); }
	 * 
	 * public static void foo(String s) { System.out.println("String impl"); }
	 */

	public static void main(String[] args) {
		/*
		 * long longWithL = 1000*60*60*24*365L; long longWithoutL =
		 * 1000*60*60*24*365; System.out.println(longWithL);
		 * System.out.println(longWithoutL);
		 */

		System.out.println("Current class : " + getCurrClassName());
	}

	private static String getCurrClassName() {
		
		return (new CurClassNameGenerator()).getClassName();
	}

	public static class CurClassNameGenerator extends SecurityManager {
		public String getClassName(){
			return getClassContext()[1].getName();
		}
	}
}
