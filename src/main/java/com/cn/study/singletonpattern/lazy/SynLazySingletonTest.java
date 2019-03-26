package com.cn.study.singletonpattern.lazy;

import java.lang.reflect.Constructor;

public class SynLazySingletonTest {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							SynLazySingleton lazySingleton =
									SynLazySingleton.getInstance();
							System.err.println(lazySingleton);
						}
					}
					
					).start();
		}
		
		try {
			Class<?> clazz = SynLazySingleton.class;
			Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
			declaredConstructor.setAccessible(true);
			Object newInstance = declaredConstructor.newInstance();
			SynLazySingleton innerLazySingleton =
					SynLazySingleton.getInstance();
			System.out.println(newInstance);
			System.out.println(innerLazySingleton);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}
