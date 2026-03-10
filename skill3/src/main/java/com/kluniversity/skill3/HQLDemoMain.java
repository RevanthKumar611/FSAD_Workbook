package com.kluniversity.skill3;

import com.kluniversity.skill3.dao.ProductDAO;
import com.kluniversity.skill3.entity.Product;
import com.kluniversity.skill3.util.HibernateUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class HQLDemoMain {
    
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        ProductDAO productDAO = new ProductDAO(sessionFactory);
        
        System.out.println("========== INSERTING SAMPLE PRODUCTS ==========");
        productDAO.saveProduct(new Product("Laptop", "Electronics", 75000.0, 15));
        productDAO.saveProduct(new Product("Mobile", "Electronics", 25000.0, 30));
        productDAO.saveProduct(new Product("Tablet", "Electronics", 35000.0, 20));
        productDAO.saveProduct(new Product("Headphones", "Accessories", 2500.0, 50));
        productDAO.saveProduct(new Product("Charger", "Accessories", 800.0, 100));
        productDAO.saveProduct(new Product("Mouse", "Accessories", 500.0, 80));
        productDAO.saveProduct(new Product("Keyboard", "Accessories", 1500.0, 60));
        productDAO.saveProduct(new Product("Monitor", "Electronics", 12000.0, 25));
        
        System.out.println("\n========== TASK 3: SORTING BY PRICE ==========");
        System.out.println("\n--- Ascending Order ---");
        List<Product> ascProducts = productDAO.getProductsSortedByPriceAsc();
        ascProducts.forEach(System.out::println);
        
        System.out.println("\n--- Descending Order ---");
        List<Product> descProducts = productDAO.getProductsSortedByPriceDesc();
        descProducts.forEach(System.out::println);
        
        System.out.println("\n========== TASK 4: SORTING BY QUANTITY (HIGHEST FIRST) ==========");
        List<Product> quantityProducts = productDAO.getProductsSortedByQuantityDesc();
        quantityProducts.forEach(System.out::println);
        
        System.out.println("\n========== TASK 5: PAGINATION ==========");
        System.out.println("\n--- First 3 Products ---");
        List<Product> firstThree = productDAO.getFirstThreeProducts();
        firstThree.forEach(System.out::println);
        
        System.out.println("\n--- Next 3 Products ---");
        List<Product> nextThree = productDAO.getNextThreeProducts();
        nextThree.forEach(System.out::println);
        
        System.out.println("\n========== TASK 6: AGGREGATE FUNCTIONS ==========");
        System.out.println("\n--- Total Product Count ---");
        Long totalCount = productDAO.getTotalProductCount();
        System.out.println("Total Products: " + totalCount);
        
        System.out.println("\n--- Products with Quantity > 0 ---");
        Long inStockCount = productDAO.getInStockProductCount();
        System.out.println("In-Stock Products: " + inStockCount);
        
        System.out.println("\n--- Count Grouped by Description ---");
        List<Object[]> countByDesc = productDAO.getProductCountByDescription();
        for (Object[] row : countByDesc) {
            System.out.println("Description: " + row[0] + ", Count: " + row[1]);
        }
        
        System.out.println("\n--- Minimum Price ---");
        Double minPrice = productDAO.getMinimumPrice();
        System.out.println("Minimum Price: Rs." + minPrice);
        
        System.out.println("\n--- Maximum Price ---");
        Double maxPrice = productDAO.getMaximumPrice();
        System.out.println("Maximum Price: Rs." + maxPrice);
        
        System.out.println("\n========== TASK 7: GROUP BY DESCRIPTION ==========");
        List<Object[]> groupedProducts = productDAO.groupProductsByDescription();
        for (Object[] row : groupedProducts) {
            System.out.println("Description: " + row[0] + 
                             ", Count: " + row[1] + 
                             ", Avg Price: Rs." + row[2]);
        }
        
        System.out.println("\n========== TASK 8: WHERE - PRICE RANGE FILTER ==========");
        List<Product> priceRangeProducts = productDAO.getProductsInPriceRange(1000.0, 30000.0);
        priceRangeProducts.forEach(System.out::println);
        
        System.out.println("\n========== TASK 9: LIKE OPERATIONS ==========");
        System.out.println("\n--- Names Starting with 'M' ---");
        List<Product> startsWith = productDAO.getProductsStartingWith("M");
        startsWith.forEach(System.out::println);
        
        System.out.println("\n--- Names Ending with 'r' ---");
        List<Product> endsWith = productDAO.getProductsEndingWith("r");
        endsWith.forEach(System.out::println);
        
        System.out.println("\n--- Names Containing 'top' ---");
        List<Product> containing = productDAO.getProductsContaining("top");
        containing.forEach(System.out::println);
        
        System.out.println("\n--- Names with Exactly 5 Characters ---");
        List<Product> exactLength = productDAO.getProductsWithNameLength(5);
        exactLength.forEach(System.out::println);
        
        System.out.println("\n========== ALL PRODUCTS ==========");
        List<Product> allProducts = productDAO.getAllProducts();
        allProducts.forEach(System.out::println);
        
        sessionFactory.close();
        System.out.println("\nHibernate SessionFactory closed.");
    }
}
