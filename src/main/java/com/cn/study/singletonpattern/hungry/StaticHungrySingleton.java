package com.cn.study.singletonpattern.hungry;

/**
 *  静态饿汉式单例
 * @author User
 *
 */
public class StaticHungrySingleton {

	private static final StaticHungrySingleton hungrySingleton ;
	// 静态代码块
	static {
		hungrySingleton = new StaticHungrySingleton();
	}

	private StaticHungrySingleton() {
		if(hungrySingleton != null) {
			throw new IllegalStateException();
		}
	}

	public static StaticHungrySingleton getInstance() {
		return hungrySingleton;
	}
}