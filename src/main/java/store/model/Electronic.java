package store.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "electronics")
public class Electronic extends Product{
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    private String brand;
    private String model;
    public Electronic(){}
    public Electronic(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

}
