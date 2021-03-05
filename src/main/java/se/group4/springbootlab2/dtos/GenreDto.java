package se.group4.springbootlab2.dtos;

public class GenreDto {                                                                                                 //DataTransferObject, utför skickningen ut från controller till services
    private int id;
    private String name;

    public GenreDto(int id, String name) {
        this.id = id;
        this.name = name;
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
