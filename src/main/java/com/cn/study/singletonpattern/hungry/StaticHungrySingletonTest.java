package com.cn.study.singletonpattern.hungry;

import java.lang.reflect.Constructor;

import com.cn.study.singletonpattern.lazy.InnerLazySingleton;

public class StaticHungrySingletonTest {

	public static void main(String[] args) {
		
		for (int i = 0; i < 1; i++) {
			new Thread(
					new Runnable() {
						public void run() {
							StaticHungrySingleton staticHungrySingleton =
									StaticHungrySingleton.getInstance();
							System.err.println(staticHungrySingleton);
						}
					}
					
					).start();
		}
		
		
		try {
			Class<?> clazz = StaticHungrySingleton.class;
			Constructor<?> declaredConstructor = clazz.getDeclaredConstructor(null);
			declaredConstructor.setAccessible(true);
			Object newInstance = declaredConstructor.newInstance();
			StaticHungrySingleton innerLazySingleton =
					StaticHungrySingleton.getInstance();
			System.out.println(newInstance);
			System.out.println(innerLazySingleton);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
}
