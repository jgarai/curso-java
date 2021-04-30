package com.ipartek.formacion.poo.ejercicios;

public class Fraccion {
	/*
	 * Escribe una clase para representar fracciones. La clase tendrá dos atributos
	 * de tipo int: num (numerador) y den (denominador). La clase debe contener los
	 * constructores y métodos adecuados para que este método main funcione de forma
	 * correcta:
	 */
	private Integer num;
	private Integer den;

	public Fraccion(Integer num, Integer den) {
		setNum(num);
		setDen(den);
	}

	public Fraccion() {
		setNum(0);
		setDen(1);
	}

	public Fraccion(int i) {
		this(i, 1);
	}

	@Override
	public String toString() {
		simplificar();
		return num + "/" + den;
	}

	private void simplificar() {
		int n = mcd(); // se calcula el mcd de la fracción
		num = num / n;
		den = den / n;

	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Integer getDen() {
		return den;
	}

	public void setDen(Integer den) {
		this.den = den;
	}

	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = getNum() * f.den + getDen() * f.num;
		aux.den = getDen() * f.den;
		aux.simplificar();
		return aux;

	}

	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = getNum() * f.den - getDen() * f.num;
		aux.den = getDen() * f.den;
		aux.simplificar();
		return aux;

	}

	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = getNum() * f.num;
		aux.den = getDen() * f.den;
		aux.simplificar();
		return aux;

	}

	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = getNum() * f.den;
		aux.den = getDen() * f.num;
		aux.simplificar();
		return aux;

	}

	// Cálculo del máximo común divisor
	private int mcd() {
		int u = Math.abs(num);
		int v = Math.abs(den);
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}

}
