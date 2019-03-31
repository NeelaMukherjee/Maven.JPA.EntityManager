package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CD {

    @Id
    @GeneratedValue
    Long id;
    String title;
    String description;
    Integer year;
    @OneToMany(cascade = CascadeType.ALL)
    Set<Artist> artists;

    public CD(String title, String desc, Integer year,Set<Artist> artists ){

        this.title = title;
        this.description = desc;
        this.year= year;
        this.artists = new HashSet<Artist>(artists);

    }

    public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }



    Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
