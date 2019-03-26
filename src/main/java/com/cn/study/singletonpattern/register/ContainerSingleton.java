package com.cn.study.singletonpattern.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ContainerSingleton {

	private ContainerSingleton() {
		
	}
	
	private static Map<String, Object> ioc = new ConcurrentHashMap<String, Object>();
	
	public static Object getBean(String className) {
		synchronized (ioc) {
			if(!ioc.containsKey(className)) {
				Object object = null;
				try {
					object = Class.forName(className).newInstance();
					ioc.put(className, object);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return ioc.get(className);
	}
	
}
