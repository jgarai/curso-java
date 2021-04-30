package com.ipartek.formacion.poo.ejercicios;

public class Libro {
	/*
	 * Crea una clase llamada Libro que guarde la informaci�n de cada uno de los
	 * libros de una biblioteca. La clase debe guardar el t�tulo del libro, autor,
	 * n�mero de ejemplares del libro y n�mero de ejemplares prestados. La clase
	 * contendr� los siguientes m�todos: Constructor por defecto. Constructor con
	 * par�metros. M�todos Setters/getters M�todo pr�stamo que incremente el
	 * atributo correspondiente cada vez que se realice un pr�stamo del libro. No se
	 * podr�n prestar libros de los que no queden ejemplares disponibles para
	 * prestar. Devuelve true si se ha podido realizar la operaci�n y false en caso
	 * contrario. M�todo devoluci�n que decremente el atributo correspondiente
	 * cuando se produzca la devoluci�n de un libro. No se podr�n devolver libros
	 * que no se hayan prestado. Devuelve true si se ha podido realizar la operaci�n
	 * y false en caso contrario. M�todo toString para mostrar los datos de los
	 * libros. Este m�todo se heredada de Object y lo debemos modificar (override)
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
