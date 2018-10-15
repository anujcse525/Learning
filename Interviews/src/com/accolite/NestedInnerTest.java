package com.accolite;

public class NestedInnerTest {

	public static void main(String[] args) {
		NestedInner.Inner NI = new NestedInner().new Inner();
		NI.show();

	}

}
