package store.test;

import store.dao.CategoryDAO;
import store.dao.ProductDAO;
import store.model.Category;
import store.model.Product;
import utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class insertProduct {
    public static void main(String[] args) {

        EntityManager manager = JPAUtils.getEntityManager();
        CategoryDAO categoryDAO = new CategoryDAO(manager);
        ProductDAO productDAO = new ProductDAO(manager);


        manager.getTransaction().begin();


        Category smartPhone = new Category("SMARTPHONE");
        Product cellPhone = new Product(
                "Samsung",
                "Very good cellphone",
                new BigDecimal("100"),
                smartPhone
        );


        categoryDAO.insert(smartPhone);
        productDAO.insert(cellPhone);

        manager.getTransaction().commit();
        manager.close();
    }
}
