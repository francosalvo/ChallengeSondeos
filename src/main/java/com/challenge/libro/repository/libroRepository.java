package com.challenge.libro.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.challenge.libro.model.Libro;

@Repository
public interface libroRepository extends JpaRepository <Libro, Integer> {

}
