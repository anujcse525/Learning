package Singleton.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class ASingleton /*implements Serializable*/ implements Cloneable{
	private volatile static ASingleton asingle = null;

	private ASingleton() throws MyException {
		//Below 3 lines added to not break singleton because of Reflection
		if(asingle != null){
			throw new MyException("Use getInstance method");
		}
		System.out.println("Creating ...");
	}

	public static ASingleton getInstance() throws MyException {
		if (asingle == null) {
			asingle = new ASingleton();
		}
		return asingle;
	}
	
	//Added to avoid because of serialization, called when deserializing
	private Object readResolve() throws ObjectStreamException{
		System.out.println(" .. reading back ...");
		return asingle;
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}

public class Singleton {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, MyException, FileNotFoundException, IOException {
		ASingleton s1 = ASingleton. getInstance();
		ASingleton s2 = ASingleton.getInstance();
		
		print("s1", s1);
		print("s2", s2);
		
		//Breaking with Reflection
		/*Class clazz = Class.forName("Singleton.singleton.ASingleton");
		Constructor ctr =clazz.getDeclaredConstructor();
		ctr.setAccessible(true);
		
		ASingleton s3 = (ASingleton) ctr.newInstance();
		print("s3", s3);*/
		
		//Breaking with Serialization
		/*ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/Users/anujkumar/Desktop/learning/s2.ser")));
		oos.writeObject(s2);
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/Users/anujkumar/Desktop/learning/s2.ser")));
		ASingleton s3 = (ASingleton) ois.readObject();
		print("s3", s3);
		
		oos.close();
		ois.close();*/
		
		//Breaking with cloning
		try {
			ASingleton s3 = (ASingleton) s2.clone();
			print("s3", s3);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public static void print(String name, ASingleton single) {
		System.out.println(String.format("Object Created %s : with Hash : %d", name, single.hashCode()));
	}
}
