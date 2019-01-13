package com.accolite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ToSerialize implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1752121374107767619L;
	static int stInt =20;
	int inInt;
	transient int trInt;

	public ToSerialize(int inInt, int trInt) {
		super();
		this.inInt = inInt;
		this.trInt = trInt;
	}

	public static int getStInt() {
		return stInt;
	}

	public static void setStInt(int stInt) {
		ToSerialize.stInt = stInt;
	}

	public int getInInt() {
		return inInt;
	}

	public void setInInt(int inInt) {
		this.inInt = inInt;
	}

	public int getTrInt() {
		return trInt;
	}

	public void setTrInt(int trInt) {
		this.trInt = trInt;
	}
}

class ChildSerializable extends ToSerialize{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6857541708184818733L;
	
	public String name;
	public int roll;
	
	
	public ChildSerializable(String name, int roll) {
		super(22, 33);
		this.name = name;
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	
}
public class SerializableTest {

	public static void main(String[] args) {
		/*ToSerialize test = new ToSerialize(44, 55);
		test.inInt = 5;
		test.trInt = 10;*/
		
		//ToSerialize.stInt = 15;
		ChildSerializable test = new ChildSerializable("Anuj", 525);
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("/Users/anujkumar/Desktop/MyJava/Ser.ser")));
			oos.writeObject(test);

			ois = new ObjectInputStream(new FileInputStream(new File("/Users/anujkumar/Desktop/MyJava/Ser.ser")));
			ChildSerializable toDes = (ChildSerializable) ois.readObject();
			System.out.println(toDes.inInt + " - " + toDes.trInt + " - " + toDes.stInt);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
