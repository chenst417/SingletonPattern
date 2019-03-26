package com.cn.study.singletonpattern.lazy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
/**
 * 反射攻击
 * @author User
 *
 */
public class InnerLazySingletonTest {

	public static void main(String[] args) {

		/*
		 * for (int i = 0; i < 1; i++) { new Thread( new Runnable() { public void run()
		 * { InnerLazySingleton innerLazySingleton = InnerLazySingleton.getInstance();
		 * System.err.println(innerLazySingleton); } }
		 *
		 * ).start(); }
		 */
		System.err.println("========================");


		try {

			/*
			 *
			 * Class<?> clazz = InnerLazySingleton.class; Constructor<?> declaredConstructor
			 * = clazz.getDeclaredConstructor(null);
			 * declaredConstructor.setAccessible(true); Object newInstance =
			 * declaredConstructor.newInstance();
			 *
			 *
			 * Thread.sleep(1000000);
			 */

			/*
			 * InnerLazySingleton innerLazySingleton = InnerLazySingleton.getInstance();
			 *
			 *
			 * System.out.println(newInstance); System.out.println(innerLazySingleton);
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}

		InnerLazySingleton innerLazySingleton1 = InnerLazySingleton.getInstance();

		InnerLazySingleton innerLazySingleton2 = null;

		try {
			FileOutputStream fos = new FileOutputStream("Serializable.obj");

			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(innerLazySingleton1);

			oos.flush();
			oos.close();

			FileInputStream fis = new FileInputStream("Serializable.obj");
			ObjectInputStream ois = new ObjectInputStream(fis);

			innerLazySingleton2 = (InnerLazySingleton) ois.readObject();
			ois.close();

			System.out.println(innerLazySingleton1);
			System.out.println(innerLazySingleton2);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
