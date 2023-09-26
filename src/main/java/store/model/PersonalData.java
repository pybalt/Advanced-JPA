package store.model;

import javax.persistence.Embeddable;

@Embeddable
public class PersonalData {
    public PersonalData(){};
    public PersonalData(String name, String dni){
        this.name = name;
        this.dni = dni;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    String name;
    String dni;

}
