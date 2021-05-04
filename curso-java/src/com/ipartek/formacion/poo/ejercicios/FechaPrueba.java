package com.ipartek.formacion.poo.ejercicios;

public class FechaPrueba {

	public static void main(String[] args) {
		Fecha f = new Fecha(28, 12, 2015);

		System.out.println(f);
		System.out.println(f.fechaCorrecta());

		for (int i = 0; i != 10; i++) {
			f.diaSiguiente();
			System.out.println(f);

		}
	}

}
