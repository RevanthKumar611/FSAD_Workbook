package com.klu;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.*;
import org.hibernate.query.Query;
import jakarta.persistence.criteria.*;
public class MainApp {
 static Scanner sc = new Scanner(System.in);
 public static void main(String[] args) {
 int ch;
 do {
 System.out.println("\n=== MENU (HQL + HCQL) ===");
 System.out.println("1. Insert Student");
 System.out.println("2. Show Students (HQL)");
 System.out.println("3. HCQL - Students marks > 50");
 System.out.println("0. Exit");
 System.out.print("Enter: ");
 ch = sc.nextInt();
 switch(ch) {
 case 1: insert(); break;
 case 2: showHQL(); break;
 case 3: showHCQL(); break;
 }
 } while(ch != 0);
 }
 static void insert() {
 System.out.print("Enter name: ");
 String name = sc.next();
 System.out.print("Enter marks: ");
 int marks = sc.nextInt();
 Session session = HibernateUtil.getSessionFactory().openSession();
 Transaction tx = session.beginTransaction();
 Student s = new Student(name, marks);
 session.persist(s);
 tx.commit();
 session.close();
 System.out.println("Inserted!");
 }
 // ===== HQL Example =====
 static void showHQL() {
 Session session = HibernateUtil.getSessionFactory().openSession();
 Query<Student> q = session.createQuery("from Student", Student.class); // HQL
 List<Student> list = q.list();
 System.out.println("\nID NAME MARKS");
 for(Student s : list) {
 System.out.println(s.getId()+" "+s.getName()+" "+s.getMarks());
 }
 session.close();
 }
 // ===== HCQL Example =====
 static void showHCQL() {
 Session session = HibernateUtil.getSessionFactory().openSession();
 CriteriaBuilder cb = session.getCriteriaBuilder();
 CriteriaQuery<Student> cq = cb.createQuery(Student.class);
 Root<Student> root = cq.from(Student.class);
 cq.select(root).where(cb.gt(root.get("marks"), 50)); // marks > 50
 Query<Student> q = session.createQuery(cq);
 List<Student> list = q.getResultList();
 System.out.println("\nStudents (marks > 50):");
 for(Student s : list) {
 System.out.println(s.getId() + " | " + s.getName() + " | " + s.getMarks());
 }
 session.close();
 }
}
