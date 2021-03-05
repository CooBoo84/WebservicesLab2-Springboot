package se.group4.springbootlab2.entities;

import javax.persistence.*;

@Entity
@Table(name="genres")
public class Genre {                                                                                                    //Databaskopplingens klasser som vi läser och skriver till databasen

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Genre(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}