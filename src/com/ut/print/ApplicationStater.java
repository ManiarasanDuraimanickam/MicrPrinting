package com.ut.print;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ut.print.check.Login;

public class ApplicationStater {

	public static void main(String[] args) {
		ApplicationContext context =(ApplicationContext) new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ComponentFactory.setContextComponent(context);
		Login login=context.getBean(Login.class);
		login.setVisible(true);
	}
}
