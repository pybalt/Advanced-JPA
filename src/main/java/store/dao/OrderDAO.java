package store.dao;

import store.VO.salesReport;
import store.model.Order;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class OrderDAO {
    private EntityManager manager;
    public OrderDAO(EntityManager manager){
        this.manager = manager;
    }
    public void save(Order order){
        manager.persist(order);
    }
    public void update(Order order){
        manager.merge(order);
    }
    public void delete(Order order){
        manager.remove(order);
    }
    public Order findById(Long id){
        return manager.find(Order.class, id);
    }
    public List<Order> findAll(){
        String jpql = "SELECT P FROM Order AS P";
        return manager.createQuery("from Order", Order.class).getResultList();
    }
    public BigDecimal totalSoldValue(){
        String jpql = "SELECT SUM(P.totalValue) FROM Order AS P";
        return manager.createQuery(jpql, BigDecimal.class).getSingleResult();
    }
    public Double averageSoldValue(){
        String jpql = "SELECT AVG(P.totalValue) FROM Order AS P";
        return manager.createQuery(jpql, Double.class).getSingleResult();
    }
    public List<Object[]> salesReport(){
        String jpql = "SELECT product.name, SUM(orderedItem.quantity), MAX(ord.date) FROM Order AS ord "
                + "JOIN ord.orderedItems orderedItem "
                + "JOIN orderedItem.product product "
                + "GROUP BY product.name, orderedItem.quantity ORDER BY orderedItem.quantity DESC";
        return manager.createQuery(jpql, Object[].class).getResultList();
    }
    public List<salesReport> salesReportVO(){
        String jpql = "SELECT new store.VO.salesReport( product.name, SUM(orderedItem.quantity), MAX(ord.date) ) FROM Order AS ord "
                + "JOIN ord.orderedItems orderedItem "
                + "JOIN orderedItem.product product "
                + "GROUP BY product.name, orderedItem.quantity ORDER BY orderedItem.quantity DESC";
        return manager.createQuery(jpql, salesReport.class).getResultList();
    }

}
