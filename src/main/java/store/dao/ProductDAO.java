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
        return manager.createNamedQuery("Product.findByName", Product.class)
                .setParameter("name", name)
                .getResultList();
    }
    public List<Product> listByCategory(Category category){
        return manager.createNamedQuery("Product.findByCategory", Product.class)
                .setParameter("category", category.getName())
                .getResultList();
    }

    public BigDecimal getPriceByName(String name) {
        return manager
                .createNamedQuery("Product.getPriceByName", BigDecimal.class)
                .setParameter("name", name).getSingleResult();
    }
}
