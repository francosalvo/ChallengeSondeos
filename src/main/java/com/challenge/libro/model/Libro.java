package com.challenge.libro.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String titulo;
    
    private String autor;
    
    private Date fecha_lanz;
    private double precio;
    
    public Libro(Integer id, String titulo, String autor, Date fecha_lanz, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fecha_lanz = fecha_lanz;
        this.precio = precio;
    }
    
    public Libro() {
        
    }



	public Integer getId() {
		return id;
	}











	public void setId(Integer id) {
		this.id = id;
	}











	public String getTitulo() {
		return titulo;
	}











	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}











	public String getAutor() {
		return autor;
	}











	public void setAutor(String autor) {
		this.autor = autor;
	}











	public Date getFecha_lanz() {
		return fecha_lanz;
	}











	public void setFecha_lanz(Date fecha_lanz) {
		this.fecha_lanz = fecha_lanz;
	}



	@Override
	public String toString() {
		return "Libros [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", fecha_lanz=" + fecha_lanz
				+ ", precio=" + precio + "]";
	}





	public double getPrecio() {
		return precio;
	}





	public void setPrecio(double precio) {
		this.precio = precio;
	}


	

}
