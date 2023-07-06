package com.challenge.libro.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.libro.model.Libro;
import com.challenge.libro.repository.*;

@Service
public class librosServiceImpl implements librosService{

	@Autowired
	private libroRepository librosRepository;
	
	

	@Override
	public Libro createLibros(Libro libro) {
		// TODO Auto-generated method stub
		return librosRepository.save(libro);
	}

	@Override
	public Libro updateLibros(Libro libro) {
		if (librosRepository.existsById(libro.getId())) {
	        
	        Libro libroActualizado = librosRepository.save(libro);
	        
	        return libroActualizado;
	    } else {
	        throw new NoSuchElementException("Libro no encontrado");
	    }
	}

	@Override
	public void deleteLibros(Integer id) {
		// TODO Auto-generated method stub
		 librosRepository.deleteById(id);
		
	}

	@Override
	public Libro findById(Integer id) {
		 return librosRepository.findById(id)
		            .orElseThrow(() -> new NoSuchElementException("Libro no encontrado"));
		}

	@Override
	public List<Libro> findAll() {
		// TODO Auto-generated method stub
		return librosRepository.findAll();
	}
	

}
