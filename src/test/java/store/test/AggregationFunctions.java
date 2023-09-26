package store.test;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import store.dao.ClientDAO;
import store.dao.OrderDAO;
import store.dao.ProductDAO;
import store.model.Client;
import store.model.Order;
import store.model.OrderedItem;
import utils.JPAUtils;

import javax.persistence.EntityManager;

import java.util.List;

import static store.test.InsertProduct.insertSomeProductToDatabase;

public class AggregationFunctions {
    static EntityManager manager = JPAUtils.getEntityManager();
    static ProductDAO productDAO = new ProductDAO(manager);
    static OrderDAO orderDAO = new OrderDAO(manager);
    static ClientDAO clientDAO = new ClientDAO(manager);
    public static void main(String[] args) {
        generateABunchOfOrders(10);
        System.out.println("Total sold value: " + orderDAO.totalSoldValue());
        System.out.println("Average sold value: " + orderDAO.averageSoldValue());
        System.out.println("Sales report: ");
        orderDAO.salesReport().forEach(e-> System.out.println(e[0] + " - " + e[1] + " - " + e[2]));
        manager.close();
    }
    public static void generateABunchOfOrders(int numberOfOrders){
        insertSomeProductToDatabase(manager);
        List<Client> clients = List.of(new Client("Juan", "95165476"),
                new Client("Pedro", "65265473"),
                new Client("Maria", "65465474"),
                new Client("Jose", "65167472")
                );
        clients.forEach(clientDAO::save);
        List<Order> orders = new ArrayList<>();
        for (int i = 0; i < numberOfOrders; i++) {
            orders.add(
                    new Order(
                            clients.get(
                                    ThreadLocalRandom.current().nextInt(0, 4)
                            )
                    )
            );
        }
        orders.forEach(e-> e.addItem(
                new OrderedItem(
                        ThreadLocalRandom.current().nextInt(0, numberOfOrders),
                        productDAO.find(1l),
                        e
                )
        ));
        manager.getTransaction().begin();
        orders.forEach(orderDAO::save);
        manager.getTransaction().commit();
    }
}
