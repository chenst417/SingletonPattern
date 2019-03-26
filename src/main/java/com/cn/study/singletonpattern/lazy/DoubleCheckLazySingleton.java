package com.cn.study.singletonpattern.lazy;

/**
 * 懒汉式单例
 * @author User
 *        双重检查锁  +volatile
 *	不存在线程安全问题。
 *	类加载的时候不实例化，调用的时候才进行实例化.
 */
public class DoubleCheckLazySingleton {

	private static volatile DoubleCheckLazySingleton lazySingleton = null ;

	private DoubleCheckLazySingleton() {
		if(lazySingleton != null) {
			throw new IllegalStateException();
		}
	}

	public static final DoubleCheckLazySingleton getInstance() {
		if(lazySingleton == null) {
			synchronized (DoubleCheckLazySingleton.class) {
				if(lazySingleton == null) {
					lazySingleton = new DoubleCheckLazySingleton();
				}
			}
		}
		return lazySingleton;
	}

}