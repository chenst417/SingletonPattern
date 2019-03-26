package com.cn.study.singletonpattern.lazy;

import java.lang.reflect.Constructor;

public class LazySingletonTest {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							LazySingleton lazySingleton =
									LazySingleton.getInstance();
							System.err.println(lazySingleton);
						}
					}
					
					).start();
		}
		
		try {
			Class<?> clazz = InnerLazySingleton.class;
			Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
			declaredConstructor.setAccessible(true);
			Object newInstance = declaredConstructor.newInstance();
			InnerLazySingleton innerLazySingleton =
					InnerLazySingleton.getInstance();
			System.out.println(newInstance);
			System.out.println(innerLazySingleton);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}
