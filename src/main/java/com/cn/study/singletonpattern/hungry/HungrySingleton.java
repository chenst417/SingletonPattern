package com.cn.study.singletonpattern.hungry;

/**
 *  饿汉式单例
 * @author User
 *
 */
public class HungrySingleton {

	private static final HungrySingleton hungrySingleton = new HungrySingleton();

	private HungrySingleton() {

	}

	public static HungrySingleton getInstance() {
		return hungrySingleton;
	}
}