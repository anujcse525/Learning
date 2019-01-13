package com.anuj.java8feature.FI;

import java.util.function.Supplier;

public class SupplierTest {

	public static void main(String[] args) {
		Supplier<String> su = () -> {
			String otp = "";
			for(int i=0; i<6; i++){
				otp = otp + (int)(Math.random() * 10);
			}
			return otp;
		};
		System.out.println(su.get());
	}

}
