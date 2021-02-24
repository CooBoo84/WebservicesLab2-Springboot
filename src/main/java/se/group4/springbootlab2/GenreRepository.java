package se.group4.springbootlab2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository <Genre, Integer> {
    List<Genre> findAllByGenreName(String genreName);
}
