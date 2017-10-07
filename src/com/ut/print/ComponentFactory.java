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
		if (applicationContext == null)
			return null;
		return applicationContext.getBean(cls);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getBeanByName(String cls) {
		if (applicationContext == null)
			return null;
		return (T) applicationContext.getBean(cls);
	}
}
