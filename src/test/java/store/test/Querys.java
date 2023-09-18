package store.test;

import store.dao.ProductDAO;
import store.model.Category;
import store.model.Product;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

import static store.test.InsertProduct.insertSomeProductToDatabase;

public class Querys {
    static EntityManager manager = JPAUtils.getEntityManager();
    static ProductDAO productDAO = new ProductDAO(manager);
    public static void main(String[] args) {

        insertSomeProductToDatabase(JPAUtils.getEntityManager());

        findProductByName(manager, 1l);

        getPricesOfAllProducts();

        getDescriptionOfProductByName("Samsung S23 ULTRA");

        listByCategory(manager.find(Category.class, 1l));
        
        getPriceByName("Samsung S23 ULTRA");
    }

    private static void getPriceByName(String name) {
        BigDecimal price = productDAO.getPriceByName(name);
        System.out.println(price);
    }

    private static void listByCategory(Category category) {
        productDAO.listByCategory(category).forEach(e-> System.out.println(e.getName()));
    }

    private static void getDescriptionOfProductByName(String name) {
        List<Product> _products =  productDAO.findByName(name);
        _products.forEach(e-> System.out.println(e.getDescription()));
    }

    private static void getPricesOfAllProducts() {
        List<Product> listOfProducts = productDAO.listAll();
        listOfProducts.forEach(e-> System.out.println(e.getPrice()));
    }

    private static void findProductByName(EntityManager manager, Long id) {
        ProductDAO productDAO = new ProductDAO(manager);
        Product product = productDAO.find(id);
        System.out.println(product.getName());
    }
}
