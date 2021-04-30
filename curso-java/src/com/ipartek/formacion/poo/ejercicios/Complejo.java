package com.ipartek.formacion.poo.ejercicios;

public class Complejo {
	/*
	 * Escribe una clase Complejo que modele el comportamiento de los n�meros
	 * complejos. Un n�mero complejo, es una entidad matem�tica que viene dada por
	 * un par de n�meros reales, el primero a se denomina la parte real y al segundo
	 * b la parte imaginaria. Se representa escribiendo las dos partes del n�mero
	 * entre par�ntesis (a, b) o tambi�n de la forma a + bi. La i se denomina unidad
	 * imaginaria, representa la ra�z cuadrada de -1. La clase Complejo tendr� dos
	 * datos privados de tipo double: parte real y parte imaginaria. La clase
	 * Complejo contendr� un constructor por defecto que inicializar� a 0 los
	 * atributos y un constructor con dos par�metros correspondientes a los valores
	 * de la parte real e imaginaria a asignar al nuevo objeto.
	 */
//	Contendr�, adem�s de los setters y getters, los siguientes m�todos:
//	sumar para sumar dos n�meros complejos.
//	(a, b) + (c, d) = (a + c, b + d);
//	restar para restar dos n�meros complejos.
//	(a, b) - (c, d) = (a - c, b - d);
//	multiplicar para multiplicar dos n�meros complejos:
//	(a, b) * (c, d) = (a*c � b*d, a*d + b*c)
//	multiplicar para multiplicar un n�mero complejo por un n�mero double:
//	(a, b) * n = (a * n, b * n)
//	dividir para dividir dos n�meros complejos:
//	(a, b) / (c, d) = ((a*c + b*d) / (c2 + d2) , (b*c � a*d) / (c2 + d2))
	/*
	 * Todos los m�todos anteriores devuelven el objeto n�mero complejo resultado de
	 * la operaci�n. La clase contendr� adem�s un m�todo toString para mostrar el
	 * n�mero complejo de la siguiente forma: (parte real, parte imaginaria) y un
	 * m�todo equals que compruebe si dos n�meros complejos son iguales o no. Una
	 * vez creada la clase, escribe un programa para probar la clase. Un ejemplo de
	 * main podr�a ser este:
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
