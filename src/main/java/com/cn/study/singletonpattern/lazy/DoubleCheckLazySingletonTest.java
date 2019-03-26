package com.cn.study.singletonpattern.lazy;

import java.lang.reflect.Constructor;

public class DoubleCheckLazySingletonTest {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							DoubleCheckLazySingleton innerLazySingleton =
									DoubleCheckLazySingleton.getInstance();
							System.err.println(innerLazySingleton);
						}
					}
					
					).start();
		}
		
		System.err.println("========================");

		try {
			
			DoubleCheckLazySingleton innerLazySingleton =
					DoubleCheckLazySingleton.getInstance();
			
			Thread.sleep(1000);
			
			Class<?> clazz = DoubleCheckLazySingleton.class;
			Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
			declaredConstructor.setAccessible(true);
			Object newInstance = declaredConstructor.newInstance();
			
			
			System.out.println(newInstance);
			System.out.println(innerLazySingleton);
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
	
}