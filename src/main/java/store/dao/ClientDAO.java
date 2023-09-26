package store.dao;

import store.model.Client;

import javax.persistence.EntityManager;

public class ClientDAO {
    private EntityManager manager;
    public ClientDAO(EntityManager manager){
        this.manager = manager;
    }
    public void save(Client client){
        manager.persist(client);
    }
    public void update(Client client){
        manager.merge(client);
    }
    public void delete(Client client){
        manager.remove(client);
    }
    public void findById(Long id){
        manager.find(Client.class, id);
    }
    public void findAll(){
        String jpql = "SELECT P FROM Client AS P";
        manager.createQuery("from Client", Client.class).getResultList();
    }
    public void findByName(String name){
        String jpql = "SELECT P FROM Client AS P WHERE P.name = :name";
        manager.createQuery(jpql, Client.class).setParameter("name", name).getResultList();
    }
}
