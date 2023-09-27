package store.model;

import javax.persistence.*;

@Entity
public class Category {
    @EmbeddedId
    private CategoryID id;
    public CategoryID getId() {
        return id;
    }

    public void setId(CategoryID id) {
        this.id = id;
    }

    public Category(){
        /*
        Not having this default constructor throws...
        INFO: HHH000327: Error performing load command
        org.hibernate.InstantiationException: No default constructor for entity:  : store.model.Category
         */
    }
    public Category(CategoryID id) {
        this.id = id;
    }

    public String getName() {
        return id.getName();
    }

    public void setName(String name) {
        id.setName(name);
    }
}
