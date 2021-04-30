package com.ipartek.formacion.poo.ejercicios;

public class Complejo {
	/*
	 * Escribe una clase Complejo que modele el comportamiento de los números
	 * complejos. Un número complejo, es una entidad matemática que viene dada por
	 * un par de números reales, el primero a se denomina la parte real y al segundo
	 * b la parte imaginaria. Se representa escribiendo las dos partes del número
	 * entre paréntesis (a, b) o también de la forma a + bi. La i se denomina unidad
	 * imaginaria, representa la raíz cuadrada de -1. La clase Complejo tendrá dos
	 * datos privados de tipo double: parte real y parte imaginaria. La clase
	 * Complejo contendrá un constructor por defecto que inicializará a 0 los
	 * atributos y un constructor con dos parámetros correspondientes a los valores
	 * de la parte real e imaginaria a asignar al nuevo objeto.
	 */
//	Contendrá, además de los setters y getters, los siguientes métodos:
//	sumar para sumar dos números complejos.
//	(a, b) + (c, d) = (a + c, b + d);
//	restar para restar dos números complejos.
//	(a, b) - (c, d) = (a - c, b - d);
//	multiplicar para multiplicar dos números complejos:
//	(a, b) * (c, d) = (a*c – b*d, a*d + b*c)
//	multiplicar para multiplicar un número complejo por un número double:
//	(a, b) * n = (a * n, b * n)
//	dividir para dividir dos números complejos:
//	(a, b) / (c, d) = ((a*c + b*d) / (c2 + d2) , (b*c – a*d) / (c2 + d2))
	/*
	 * Todos los métodos anteriores devuelven el objeto número complejo resultado de
	 * la operación. La clase contendrá además un método toString para mostrar el
	 * número complejo de la siguiente forma: (parte real, parte imaginaria) y un
	 * método equals que compruebe si dos números complejos son iguales o no. Una
	 * vez creada la clase, escribe un programa para probar la clase. Un ejemplo de
	 * main podría ser este:
	 */

	private double real;
	private double imaginaria;

	public Complejo(double real, double imaginaria) {
		setReal(real);
		setImaginaria(imaginaria);
	}

	public Complejo() {
		setReal(0);
		setImaginaria(0);
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}

	public Complejo sumar(Complejo c) {
		Complejo aux = new Complejo();
		aux.setReal(getReal() + c.getReal());
		aux.setImaginaria(getImaginaria() + c.getImaginaria());

		return aux;

	}

	public Complejo restar(Complejo c) {
		Complejo aux = new Complejo();
		aux.setReal(getReal() - c.getReal());
		aux.setImaginaria(getImaginaria() - c.getImaginaria());

		return aux;

	}

	public Complejo multiplicar(Complejo c) {
		Complejo aux = new Complejo();
		aux.setReal(getReal() * c.getReal() - getImaginaria() * c.getImaginaria());
		aux.setImaginaria(getReal() * c.getImaginaria() + getImaginaria() * c.getImaginaria());

		return aux;

	}

	public Complejo dividir(Complejo c) {
		Complejo aux = new Complejo();

		aux.setReal((getReal() * c.getReal() + getImaginaria() * c.getImaginaria())
				/ (c.getReal() * c.getReal() + c.getImaginaria() * c.getImaginaria()));
		aux.setImaginaria((getImaginaria() * c.getReal() - getReal() * c.getImaginaria())
				/ (c.getReal() * c.getReal() + c.getImaginaria() * c.getImaginaria()));
		return aux;

	}

	public Complejo multiplicar(double d) {
		Complejo aux = new Complejo();
		aux.setReal(getReal() * d);
		aux.setImaginaria((getImaginaria() * d));
		return aux;
	}

	@Override
	public String toString() {
		return "(" + getReal() + ", " + getImaginaria() + ")";
	}
}
