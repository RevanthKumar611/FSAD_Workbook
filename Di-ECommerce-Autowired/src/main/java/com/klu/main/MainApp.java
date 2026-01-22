package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.AppConfig;
import com.klu.model.Order;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext cn=new AnnotationConfigApplicationContext(AppConfig.class);
		Order or=cn.getBean(Order.class);
		or.display();
		ApplicationContext cn1=new ClassPathXmlApplicationContext("applicationContext.xml");
		Order or1=cn.getBean(Order.class);
		or1.display();
		
		

	}

}
