package se.group4.springbootlab2.dtos;

public class GenreDto {                                                                                                 //DataTransferObject, utför skickningen ut från controller till services
    private int id;
    private String genreName;

    public GenreDto(int id, String genreName) {
        this.id = id;
        this.genreName = genreName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }
}
