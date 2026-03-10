package com.kluniversity.skill3.dao;

import com.kluniversity.skill3.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDAO {
    
    private SessionFactory sessionFactory;
    
    public ProductDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void saveProduct(Product product) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
            System.out.println("Product saved: " + product.getName());
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    
    public List<Product> getProductsSortedByPriceAsc() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p ORDER BY p.price ASC";
            Query<Product> query = session.createQuery(hql, Product.class);
            return query.getResultList();
        }
    }
    
    public List<Product> getProductsSortedByPriceDesc() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p ORDER BY p.price DESC";
            Query<Product> query = session.createQuery(hql, Product.class);
            return query.getResultList();
        }
    }
    
    public List<Product> getProductsSortedByQuantityDesc() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p ORDER BY p.quantity DESC";
            Query<Product> query = session.createQuery(hql, Product.class);
            return query.getResultList();
        }
    }
    
    public List<Product> getFirstThreeProducts() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setFirstResult(0);
            query.setMaxResults(3);
            return query.getResultList();
        }
    }
    
    public List<Product> getNextThreeProducts() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setFirstResult(3);
            query.setMaxResults(3);
            return query.getResultList();
        }
    }
    
    public Long getTotalProductCount() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(p) FROM Product p";
            Query<Long> query = session.createQuery(hql, Long.class);
            return query.getSingleResult();
        }
    }
    
    public Long getInStockProductCount() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0";
            Query<Long> query = session.createQuery(hql, Long.class);
            return query.getSingleResult();
        }
    }
    
    public List<Object[]> getProductCountByDescription() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            return query.getResultList();
        }
    }
    
    public Double getMinimumPrice() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT MIN(p.price) FROM Product p";
            Query<Double> query = session.createQuery(hql, Double.class);
            return query.getSingleResult();
        }
    }
    
    public Double getMaximumPrice() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT MAX(p.price) FROM Product p";
            Query<Double> query = session.createQuery(hql, Double.class);
            return query.getSingleResult();
        }
    }
    
    public List<Object[]> groupProductsByDescription() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "SELECT p.description, COUNT(p), AVG(p.price) FROM Product p GROUP BY p.description";
            Query<Object[]> query = session.createQuery(hql, Object[].class);
            return query.getResultList();
        }
    }
    
    public List<Product> getProductsInPriceRange(double minPrice, double maxPrice) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p WHERE p.price BETWEEN :min AND :max";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("min", minPrice);
            query.setParameter("max", maxPrice);
            return query.getResultList();
        }
    }
    
    public List<Product> getProductsStartingWith(String prefix) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p WHERE p.name LIKE :pattern";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("pattern", prefix + "%");
            return query.getResultList();
        }
    }
    
    public List<Product> getProductsEndingWith(String suffix) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p WHERE p.name LIKE :pattern";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("pattern", "%" + suffix);
            return query.getResultList();
        }
    }
    
    public List<Product> getProductsContaining(String substring) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p WHERE p.name LIKE :pattern";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("pattern", "%" + substring + "%");
            return query.getResultList();
        }
    }
    
    public List<Product> getProductsWithNameLength(int length) {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product p WHERE LENGTH(p.name) = :length";
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setParameter("length", length);
            return query.getResultList();
        }
    }
    
    public List<Product> getAllProducts() {
        try (Session session = sessionFactory.openSession()) {
            String hql = "FROM Product";
            Query<Product> query = session.createQuery(hql, Product.class);
            return query.getResultList();
        }
    }
}
