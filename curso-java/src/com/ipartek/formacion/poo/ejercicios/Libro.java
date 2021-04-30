package com.ipartek.formacion.poo.ejercicios;

public class Libro {
	/*
	 * Crea una clase llamada Libro que guarde la información de cada uno de los
	 * libros de una biblioteca. La clase debe guardar el título del libro, autor,
	 * número de ejemplares del libro y número de ejemplares prestados. La clase
	 * contendrá los siguientes métodos: Constructor por defecto. Constructor con
	 * parámetros. Métodos Setters/getters Método préstamo que incremente el
	 * atributo correspondiente cada vez que se realice un préstamo del libro. No se
	 * podrán prestar libros de los que no queden ejemplares disponibles para
	 * prestar. Devuelve true si se ha podido realizar la operación y false en caso
	 * contrario. Método devolución que decremente el atributo correspondiente
	 * cuando se produzca la devolución de un libro. No se podrán devolver libros
	 * que no se hayan prestado. Devuelve true si se ha podido realizar la operación
	 * y false en caso contrario. Método toString para mostrar los datos de los
	 * libros. Este método se heredada de Object y lo debemos modificar (override)
	 * para adaptarlo a la clase Libro.
	 */

	private String titulo;
	private String autor;
	private Integer ejemplares;
	private Integer prestados;

	public Libro() {

	}

	public Libro(String libro, String autor, Integer ejemplares, Integer prestados) {

		setTitulo(libro);
		setAutor(autor);
		setEjemplares(ejemplares);
		setPrestados(prestados);
	}

	public boolean prestamo() {
		Integer e = getEjemplares();
		Integer p = getPrestados();
		if (e > 0) {
			setEjemplares(e - 1);
			setPrestados(p + 1);
			return true;
		}
		return false;

	}

	public boolean devolucion() {
		Integer e = getEjemplares();
		Integer p = getPrestados();
		if (p > 0) {
			setEjemplares(e + 1);
			setPrestados(p - 1);
			return true;
		}
		return false;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String libro) {
		this.titulo = libro;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Integer getEjemplares() {
		return ejemplares;
	}

	public void setEjemplares(Integer ejemplares) {
		this.ejemplares = ejemplares;
	}

	public Integer getPrestados() {
		return prestados;
	}

	public void setPrestados(Integer prestados) {
		this.prestados = prestados;
	}

	@Override
	public String toString() {
		return "Libro [libro=" + titulo + ", autor=" + autor + ", ejemplares=" + ejemplares + ", prestados=" + prestados
				+ "]";
	}

}
