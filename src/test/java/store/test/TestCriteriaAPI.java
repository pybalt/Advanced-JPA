package store.test;

import store.dao.ClientDAO;
import store.dao.OrderDAO;
import store.dao.ProductDAO;
import utils.JPAUtils;

import javax.persistence.EntityManager;

import java.math.BigDecimal;

import static store.test.AggregationFunctions.generateABunchOfOrders;
import static store.test.InsertProduct.insertSomeProductToDatabase;

public class TestCriteriaAPI {
    static EntityManager manager = JPAUtils.getEntityManager();
    static ProductDAO productDAO = new ProductDAO(manager);
    static OrderDAO orderDAO = new OrderDAO(manager);
    static ClientDAO clientDAO = new ClientDAO(manager);

    public static void main(String[] args) {
        insertSomeProductToDatabase(manager);
        generateABunchOfOrders(10);
        productDAO.findByParametersWithCriteriaAPI("Samsung S23 ULTRA", null, null).forEach(System.out::println);

        productDAO.findByParametersWithCriteriaAPI("", "Very good cellphone", null).forEach(System.out::println);

        productDAO.findByParametersWithCriteriaAPI(null, null, new BigDecimal(100)).forEach(System.out::println);

        manager.close();
    }
}
