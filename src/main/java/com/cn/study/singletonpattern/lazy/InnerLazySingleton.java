package com.cn.study.singletonpattern.lazy;

import java.io.Serializable;
import java.nio.channels.SeekableByteChannel;

/**
 * 静态内部类懒汉式单例
 * @author User
 *
 */
public class InnerLazySingleton implements Serializable {

	private InnerLazySingleton() {
		if(InnerLazyHolder.innerLazySingleton != null) {
			throw new IllegalStateException();
		}
	}

	public static final InnerLazySingleton getInstance() {
		return InnerLazyHolder.innerLazySingleton;
	}

	private static class InnerLazyHolder {
		private static final InnerLazySingleton innerLazySingleton = new InnerLazySingleton();
	}

	private Object readResolve(){
		return InnerLazyHolder.innerLazySingleton;
	}

}