package com.accolite;

import java.lang.reflect.Constructor;

class A {
	public void method() {
		System.out.println("In a");
	}
}

class B extends A {
	@Override
	public void method() {
		System.out.println("In b");
	}
}

class ReflectionTest {
	public static void main(String... args) throws Exception {
		A b = new B();
		b.method();
		b.getClass().getSuperclass().getMethod("method", new Class[] {})
				.invoke(b.getClass().getSuperclass().newInstance(), new Object[] {});

		Class<?> a = Class.forName("A.class");
		Constructor ctr = a.getConstructor();
		A ab = (A) ctr.newInstance();
	}
}
