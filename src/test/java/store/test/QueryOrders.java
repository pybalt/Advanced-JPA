package store.test;

import store.dao.ClientDAO;
import store.dao.OrderDAO;
import store.dao.ProductDAO;
import store.model.Client;
import store.model.Order;
import store.model.OrderedItem;
import utils.JPAUtils;

import javax.persistence.EntityManager;

import static store.test.InsertProduct.insertSomeProductToDatabase;

public class QueryOrders {
        static EntityManager manager = JPAUtils.getEntityManager();
        static ProductDAO productDAO = new ProductDAO(manager);
        static OrderDAO orderDAO = new OrderDAO(manager);
        static ClientDAO clientDAO = new ClientDAO(manager);


    public static void main(String[] args) {
            insertSomeProductToDatabase(manager);
            Client client = new Client("Juan", "65165476");
            clientDAO.save(
                    client
            );
            Order order = new Order(client);
            order.addItem(
                    new OrderedItem(
                            5,
                            productDAO.find(1l),
                            order
                    )
            );
            manager.getTransaction().begin();
            orderDAO.save(order);
            manager.getTransaction().commit();
            manager.close();
    }

}
