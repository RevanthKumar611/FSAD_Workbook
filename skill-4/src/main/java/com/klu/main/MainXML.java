package com.klu.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.klu.model.Student;

public class MainXML {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = (Student) context.getBean("student");
        student.display();
    }
}
