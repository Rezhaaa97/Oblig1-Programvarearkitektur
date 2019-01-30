package no.oslomet.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String nasjonalitet;

    public Author(){

    }

    public Author(long id, String firstName, String lastName, String nasjonalitet){
        this.id = id;
        this.firstName = firstName;
        this.lastName=lastName;
        this.nasjonalitet = nasjonalitet;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setNasjonalitet(String nasjonalitet) {
        this.nasjonalitet = nasjonalitet;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNasjonalitet() {
        return nasjonalitet;
    }
}
