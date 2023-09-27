package store.test;

import store.model.Category;
import store.model.CategoryID;
import utils.JPAUtils;

import javax.persistence.EntityManager;

public class TestMergeFlush {
    public static void main(String[] args) {
        EntityManager manager = JPAUtils.getEntityManager();

        Category smartphones = new Category(new CategoryID("CELLPHONES", "ELECTRONICS"));


        manager.getTransaction().begin();
        manager.persist(smartphones);
        smartphones.setName("BOOKS");

        manager.flush();
        manager.clear();

        smartphones = manager.merge(smartphones);
        smartphones.setName("SOFTWARE'S");

        manager.flush();
        manager.clear();

        smartphones = manager.merge(smartphones);
        manager.remove(smartphones);
        manager.flush();
    }
}
