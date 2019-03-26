package com.cn.study.singletonpattern.register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import com.cn.study.singletonpattern.lazy.InnerLazySingleton;

public class EnumSingletonTest {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							EnumSingleton innerLazySingleton =
									EnumSingleton.getInstance();
							System.err.println(innerLazySingleton);
						}
					}
					
					).start();
		}
		
		System.err.println("========================");
		
		
		try {
			
			EnumSingleton innerLazySingleton =
					EnumSingleton.getInstance();
			
			Thread.sleep(1000);
			
			Class<?> clazz = EnumSingleton.class;
			Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(String.class, int.class);
			declaredConstructor.setAccessible(true);
			Object newInstance = declaredConstructor.newInstance("INSTANCE", 0);
			
			
			System.out.println(newInstance);
			System.out.println(innerLazySingleton);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		EnumSingleton innerLazySingleton1 = EnumSingleton.getInstance();
		
		EnumSingleton innerLazySingleton2 = null;
		
		
		try {
			FileOutputStream fos = new FileOutputStream("Serializable.obj");
			
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(innerLazySingleton1);
			
			oos.flush();
			oos.close();
			
			FileInputStream fis = new FileInputStream("Serializable.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			innerLazySingleton2 = (EnumSingleton) ois.readObject();
			ois.close();
			
			System.out.println(innerLazySingleton1);
			System.out.println(innerLazySingleton2);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
