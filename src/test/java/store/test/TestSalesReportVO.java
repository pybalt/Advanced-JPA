package store.test;

import store.dao.ClientDAO;
import store.dao.OrderDAO;
import store.dao.ProductDAO;
import utils.JPAUtils;

import javax.persistence.EntityManager;

import static store.test.AggregationFunctions.generateABunchOfOrders;

public class TestSalesReportVO {
    static EntityManager manager = JPAUtils.getEntityManager();
    static ProductDAO productDAO = new ProductDAO(manager);
    static OrderDAO orderDAO = new OrderDAO(manager);
    static ClientDAO clientDAO = new ClientDAO(manager);
    public static void main(String[] args) {
        generateABunchOfOrders(10);
        System.out.println("Sales report VO: ");
        orderDAO.salesReportVO().forEach(System.out::println);
        manager.close();
    }

}
