package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.Config.AppConfig;
import com.klu.model.CourseeRegistration;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
       CourseeRegistration cr=(CourseeRegistration)context.getBean(CourseeRegistration.class);
       cr.display();
       
	}

}
