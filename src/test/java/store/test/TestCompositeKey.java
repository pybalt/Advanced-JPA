package store.test;

import store.dao.ClientDAO;
import store.dao.OrderDAO;
import store.dao.ProductDAO;
import store.model.Category;
import store.model.CategoryID;
import utils.JPAUtils;

import javax.persistence.EntityManager;

import static store.test.AggregationFunctions.generateABunchOfOrders;
import static store.test.InsertProduct.insertSomeProductToDatabase;

/**
 * A composite key is a key that is composed of more than one attribute.
 * In this case, we have a Category class that has a name and a section attribute.
 * Which can help us to identify a category.
 */

public class TestCompositeKey {
    static EntityManager manager = JPAUtils.getEntityManager();
    static ProductDAO productDAO = new ProductDAO(manager);
    static OrderDAO orderDAO = new OrderDAO(manager);
    static ClientDAO clientDAO = new ClientDAO(manager);
    public static void main(String[] args) {
        generateABunchOfOrders(10);
        System.out.println(
                manager.find(Category.class, new CategoryID("SMARTPHONES", "ELECTRONICS")).getId().getName()
        );
        // This may not be the most useful example, but think about a word that could be in more than one section, but with different meanings.
        // For example, "Java" could be both in the "Programming" and "Geography" section (Java could be an island of Indonesia).
    }
}
