package com.ut.print;

import org.springframework.context.ApplicationContext;

public class ComponentFactory {

	private static ApplicationContext applicationContext = null;

	private ComponentFactory() {

	}

	public static void setContextComponent(ApplicationContext applicationContext) {
		ComponentFactory.applicationContext = applicationContext;
	}

	public static <T> T getBeanByType(Class<T> cls) {
		return applicationContext.getBean(cls);
	}

	public static <T> T getBeanByName(String cls) {
		return (T) applicationContext.getBean(cls);
	}
}
