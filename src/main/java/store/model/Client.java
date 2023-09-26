package store.model;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return this.personalData.getName();
    }

    public void setName(String name) {
        this.personalData.setName(name);
    }

    public String getDni() {
        return this.personalData.getDni();
    }

    public void setDni(String dni) {
        this.personalData.setDni(dni);
    }

    @Embedded
    private PersonalData personalData;
    public Client(){};
    public Client(String name, String dni){
        this.personalData = new PersonalData(name, dni);
    }
}
