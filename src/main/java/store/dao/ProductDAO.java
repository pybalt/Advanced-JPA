package store.dao;

import store.model.Category;
import store.model.Product;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {
    private final EntityManager manager;
    public ProductDAO(EntityManager manager){
        this.manager = manager;
    }
    public void insert(Product model){
        this.manager.persist(model);
    }
    public Product find(Long id){
        return manager.find(Product.class, id);
    }
    public List<Product> listAll(){
        String jqpl = "SELECT P from Product as P";
        return manager.createQuery(jqpl, Product.class).getResultList();
    }

    public List<Product> findByName(String name){
        String jpql = "SELECT P FROM Product as P WHERE P.name=:name";
        return manager.createQuery(jpql, Product.class).setParameter("name", name).getResultList();
    }
    public List<Product> listByCategory(Category category){
        String jpql = "SELECT P FROM Product as P WHERE P.category.name=:name";
        return manager.createQuery(jpql, Product.class).setParameter("name", category.getName()).getResultList();
    }

    public BigDecimal getPriceByName(String name) {
        String jpql = "SELECT P.price FROM Product as P WHERE P.name=:name";
        return manager.createQuery(jpql, BigDecimal.class).setParameter("name", name).getSingleResult();
    }
}
