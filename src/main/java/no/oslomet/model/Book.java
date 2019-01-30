package no.oslomet.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    private long ISBN;
    private String title;
    private String releaseYear;
    private Author author;

    public Book(){

    }

    public Book(long ISBN, String title, String releaseYear, Author author) {
        this.ISBN = ISBN;
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public Author getAuthor() {
        return author;
    }
}
