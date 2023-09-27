package store.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name= "books")
public class Book extends Product{
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String author;
    private int numberOfPages;
    private String title;
    Book(){}
    public Book(String author, int numberOfPages, String title) {
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.title = title;
    }

}
