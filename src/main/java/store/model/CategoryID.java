package store.model;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CategoryID implements Serializable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    private String name;
    private String section;
    public CategoryID() {
    }
    public CategoryID(String name, String section) {
        this.name = name;
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryID)) return false;
        CategoryID that = (CategoryID) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getSection(), that.getSection());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSection());
    }
}
