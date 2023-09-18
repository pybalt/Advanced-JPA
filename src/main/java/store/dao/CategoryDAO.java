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

    public void update(Category model){
        this.manager.merge(model);
    }
    public void delete(Category model){
        this.manager.merge(model);
        this.manager.remove(model);
    }
    public Category find(Long id){
        return manager.find(Category.class, id);
    }
}
