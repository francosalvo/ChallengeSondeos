package com.challenge.libro.controller;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.libro.repository.libroRepository;
import com.challenge.libro.model.Libro;

@RestController
@RequestMapping("/libros")
public class librosController {

    @Autowired
    private libroRepository libroRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Libro>> findAll() {
        try {
            List<Libro> libros = libroRepository.findAll();
            return ResponseEntity.ok(libros);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<Libro> findById(@PathVariable("id") Integer id) {
        try {
            Optional<Libro> libroOptional = libroRepository.findById(id);
            Libro libro = libroOptional.orElseThrow();
            return ResponseEntity.ok(libro);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Libro libro) {
        try {
            Libro savedLibro = libroRepository.save(libro);
            return ResponseEntity.ok("Libro guardado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo guardar el libro");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLibro(@PathVariable Integer id) {
        try {
            if (libroRepository.existsById(id)) {
                libroRepository.deleteById(id);
                String mensaje = "Se ha eliminado el libro con ID: " + id;
                return ResponseEntity.ok(mensaje);
            } else {
                throw new NoSuchElementException("Libro no encontrado");
            }
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        return ResponseEntity.notFound().build();
    }
}