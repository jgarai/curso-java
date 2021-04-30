package com.ipartek.formacion.poo.ejercicios;

public class Contador {
	/*
	 * Crea una clase llamada Contador que contenga un �nico atributo entero llamado
	 * cont. La clase tendr� los siguientes constructores: Constructor por defecto
	 * Constructor con par�metros para inicializar el contador con un valor no
	 * negativo. Si el valor inicial que se recibe es negativo el contador tomar� el
	 * valor cero como valor inicial. Constructor copia. Adem�s de los m�todos
	 * getter y setter, la clase contendr� los m�todos: incrementar: incrementa el
	 * contador en una unidad. decrementar: decrementa el contador en una unidad. El
	 * contador nunca podr� tener un valor negativo. Si al decrementar se alcanza un
	 * valor negativo el contador toma el valor cero. Una vez creada la clase,
	 * escribe un m�todo main para probar la clase.
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
