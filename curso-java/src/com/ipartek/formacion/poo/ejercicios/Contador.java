package com.ipartek.formacion.poo.ejercicios;

public class Contador {
	/*
	 * Crea una clase llamada Contador que contenga un único atributo entero llamado
	 * cont. La clase tendrá los siguientes constructores: Constructor por defecto
	 * Constructor con parámetros para inicializar el contador con un valor no
	 * negativo. Si el valor inicial que se recibe es negativo el contador tomará el
	 * valor cero como valor inicial. Constructor copia. Además de los métodos
	 * getter y setter, la clase contendrá los métodos: incrementar: incrementa el
	 * contador en una unidad. decrementar: decrementa el contador en una unidad. El
	 * contador nunca podrá tener un valor negativo. Si al decrementar se alcanza un
	 * valor negativo el contador toma el valor cero. Una vez creada la clase,
	 * escribe un método main para probar la clase.
	 */
	private Integer cont;

	public Contador() {

	}

	public Contador(Integer i) {
		if (i < 0) {
			setCont(0);
		} else
			setCont(i);
	}

	public Contador(Contador c) {
		setCont(c.getCont());
	}

	public void incrementar() {
		setCont(getCont() + 1);
	}

	public void decrementar() {
		Integer c = getCont() - 1;
		if (c < 0)
			c = 0;

		setCont(c);
	}

	public Integer getCont() {
		return cont;
	}

	public void setCont(Integer cont) {
		this.cont = cont;
	}

}
