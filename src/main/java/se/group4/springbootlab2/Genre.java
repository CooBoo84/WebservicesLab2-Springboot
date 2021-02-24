package se.group4.springbootlab2;

import javax.persistence.*;

@Entity
@Table(name="genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String genreName;

    public Genre(int id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    public long getId() {
        return id;
    }

    public void setId(int genreId) {
        this.id = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
