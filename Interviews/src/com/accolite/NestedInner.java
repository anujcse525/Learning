package com.accolite;

public class NestedInner {
	int bb = 8;

	class Inner {
		public void show() {
			System.out.println("Nested Class caled" + bb);
		}
	}
}
