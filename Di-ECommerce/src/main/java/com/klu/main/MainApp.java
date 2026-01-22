package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.klu.config.AppConfig;
import com.klu.model.ProductOrder;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
   ProductOrder pr=(ProductOrder)context.getBean("order");
   pr.display();
   ApplicationContext context1=new AnnotationConfigApplicationContext(AppConfig.class);
   ProductOrder pr1=context1.getBean(ProductOrder.class);
   pr1.display();
	}

}
