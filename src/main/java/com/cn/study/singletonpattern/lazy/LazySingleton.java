package com.cn.study.singletonpattern.lazy;

/**
 * 懒汉式单例
 * @author User
 *
 *	存在线程安全问题。
 *	类加载的时候不实例化，调用的时候才进行实例化。
 */
public class LazySingleton {

	private static LazySingleton lazySingleton = null ;

	private LazySingleton() {

	}

	public static final LazySingleton getInstance() {
		if(lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

}