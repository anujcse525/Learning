package com.citius;

public class InheritenceCheck {

	public static void main(String[] args) {
		//ChildClass cc = (ChildClass) new ParentClass("Ram");
		ParentClass pc = new ChildClass("Luv");
		//System.out.println(cc.getParentName() + "  " + cc.childName);
		System.out.println(pc.getParentName() );
		ParentClass pc1 = pc;
		System.out.println(pc1.getParentName() );
		pc = null;
		System.out.println(pc1.getParentName() );
		
	}
}