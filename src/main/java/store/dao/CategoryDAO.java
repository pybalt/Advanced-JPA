package store.dao;

import store.model.Category;

import javax.persistence.EntityManager;

public class CategoryDAO
{
    private final EntityManager manager;
    public CategoryDAO(EntityManager manager){
        this.manager = manager;
    }
    public void insert(Category model){
        this.manager.persist(model);
    }
}
