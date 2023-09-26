package store.test;

import store.dao.ClientDAO;
import store.dao.OrderDAO;
import store.dao.ProductDAO;
import store.model.Order;
import utils.JPAUtils;

import javax.persistence.EntityManager;

import static store.test.AggregationFunctions.generateABunchOfOrders;

public class TestJoinFetch {
    static EntityManager manager = JPAUtils.getEntityManager();
    static ProductDAO productDAO = new ProductDAO(manager);
    static OrderDAO orderDAO = new OrderDAO(manager);
    static ClientDAO clientDAO = new ClientDAO(manager);
    public static void main(String[] args) {
        generateABunchOfOrders(10);
        Order orderWithClient = orderDAO.findOrderWithClientFetch(
                2L
        );
        manager.close();
        System.out.println(orderWithClient.getClient().getName());
    }
}
