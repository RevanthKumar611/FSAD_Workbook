package com.example.util; 
 
import org.hibernate.SessionFactory; 
import org.hibernate.cfg.Configuration; 
 
public class HibernateUtil { 
    private static SessionFactory sessionFactory; 
 
    static { 
        sessionFactory = new Configuration() 
                .configure() // loads hibernate.cfg.xml 
                .buildSessionFactory(); 
    } 
 
    public static SessionFactory getSessionFactory() { 
        return sessionFactory; 
    } 
} 