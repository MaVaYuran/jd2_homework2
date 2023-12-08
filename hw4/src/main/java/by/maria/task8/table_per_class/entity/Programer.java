package by.maria.task8.table_per_class.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name="PROGRAMER")
public class Programer extends User{
    private static final long serialVersionUID = 2L;

    private String language;

    public Programer() {
    }

    public Programer(Long id, String username, Role role, String language) {
        super(id, username, role);
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Programer programer = (Programer) o;

        return Objects.equals(language, programer.language);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (language != null ? language.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Programer{" +
                "language='" + language + '\'' +
                '}';
    }
}
