package com.cn.study.singletonpattern.register;

public enum EnumSingleton {
	INSTANCE;
	
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
	
	public static EnumSingleton getInstance() {
		return INSTANCE;
	}
}