package se.group4.springbootlab2.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.group4.springbootlab2.entities.Genre;

import java.util.List;

@Repository
public interface GenreRepository extends JpaRepository <Genre, Integer> {                                               //Det som kopplar oss mot databasen
   List<Genre> findAllByNameContains(String name);
}