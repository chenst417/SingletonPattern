package com.cn.study.singletonpattern.lazy;

/**
 * 懒汉式单例
 * @author User
 *  synchronized
 *	不存在线程安全问题。
 *	类加载的时候不实例化，调用的时候才进行实例化。
 *        由于synchronized锁，导致执行效率低
 */
public class SynLazySingleton {

	private static SynLazySingleton lazySingleton = null ;

	private SynLazySingleton() {

	}

	public synchronized static final SynLazySingleton getInstance() {
		if(lazySingleton == null) {
			lazySingleton = new SynLazySingleton();
		}
		return lazySingleton;
	}

}