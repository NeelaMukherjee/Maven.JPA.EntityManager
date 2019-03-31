package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artist {

    @Id
    @GeneratedValue
    Long id;
    String first_name;
    String last_name;
    String instument;

    public Artist(String first_name, String last_name, String instument){

        this.first_name= first_name;
        this.last_name = last_name;
        this.instument = instument;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getInstument() {
        return instument;
    }

    public void setInstument(String instument) {
        this.instument = instument;
    }
}
