package com.challenge.libro.service;

import java.util.List;


import com.challenge.libro.model.Libro;

public interface librosService {

	public Libro createLibros (Libro libro);
	public  Libro  updateLibros (Libro libro);
	public void deleteLibros(Integer id);
	List<Libro> findAll();
	Libro findById(Integer id);
	
	
}
