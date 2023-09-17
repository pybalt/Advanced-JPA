package store.dao;

import store.model.Product;

import javax.persistence.EntityManager;

public class ProductDAO {
    private final EntityManager manager;
    public ProductDAO(EntityManager manager){
        this.manager = manager;
    }
    public void insert(Product model){
        this.manager.persist(model);
    }
}
