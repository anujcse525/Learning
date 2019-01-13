package com.anuj.string;

public class InternTest {

	public static void main(String[] args) {
		/*String s1=new String("hello");  
		String s2="hello";  
		String s3=s1.intern();//returns string from pool, now it will be same as s2  
		System.out.println(s1==s2);//false because reference variables are pointing to different instance  
		System.out.println(s2==s3);//true because reference variables are pointing to same instance
		*/
		
		String s1 = "Test";
        String s2 = "Test";
        String s3 = new String("Test");
         String s4 = s3.intern();
        System.out.println(s1 == s2); //true
        System.out.println(s2 == s3); //false
        System.out.println(s3 == s4); //false
        System.out.println(s1 == s3); //false
        System.out.println(s1 == s4); //true
        System.out.println(s1.equals(s2)); //true
        System.out.println(s2.equals(s3)); //true
        System.out.println(s3.equals(s4)); //true
        System.out.println(s1.equals(s4)); //true
        System.out.println(s1.equals(s3)); //true
	}

}
