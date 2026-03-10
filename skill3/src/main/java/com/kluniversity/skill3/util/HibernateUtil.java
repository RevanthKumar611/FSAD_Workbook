package com.kluniversity.skill3.util;

import com.kluniversity.skill3.entity.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();
            
            System.out.println("SessionFactory created successfully!");
            
        } catch (Exception e) {
            System.err.println("Error creating SessionFactory: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
