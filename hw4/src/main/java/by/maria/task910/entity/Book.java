package by.maria.task910.entity;

import javax.persistence.*;

@Entity
public class Book {
    private static final long serialVersionUI = 3l;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @Column(name = "year")
    private int yearOfCreation;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="writer_id")
    private Writer writer;

    public Book() {
    }

    public Book( String title, int yearOfCreation, Writer writer) {

        this.title = title;
        this.yearOfCreation = yearOfCreation;
        this.writer = writer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfCreation() {
        return yearOfCreation;
    }

    public void setYearOfCreation(int yearOfCreation) {
        this.yearOfCreation = yearOfCreation;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfCreation=" + yearOfCreation +
                '}';
    }
}
