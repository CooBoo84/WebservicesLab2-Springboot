package se.group4.springbootlab2.entities;

import javax.persistence.*;

@Entity
@Table(name="genres")
public class Genre {                                                                                                    //Databaskopplingens klasser som vi läser och skriver till databasen

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String genreName;

    public Genre(int id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    public Genre() {

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