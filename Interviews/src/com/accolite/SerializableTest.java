package com.accolite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ToSerialize implements Serializable{
	static int stInt =20;
	int inInt;
	transient int trInt;

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

public class SerializableTest {

	public static void main(String[] args) {
		ToSerialize test = new ToSerialize();
		test.inInt = 5;
		test.trInt = 10;
		//ToSerialize.stInt = 15;

		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(new File("/Users/anujkumar/Desktop/MyJava/Ser.ser")));
			oos.writeObject(test);

			ois = new ObjectInputStream(new FileInputStream(new File("/Users/anujkumar/Desktop/MyJava/Ser.ser")));
			ToSerialize toDes = (ToSerialize) ois.readObject();
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