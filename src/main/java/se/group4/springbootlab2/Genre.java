package se.group4.springbootlab2;

import javax.persistence.*;

@Entity
@Table(name="genres")
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long genreId;
    private String genreName;

    public Genre(long genreId, String genreName) {
        this.genreId = genreId;
        this.genreName = genreName;
    }

    public long getGenreId() {
        return genreId;
    }

    public void setGenreId(long genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
