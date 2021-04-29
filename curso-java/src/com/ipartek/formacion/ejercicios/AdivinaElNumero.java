package com.ipartek.formacion.ejercicios;

import static com.ipartek.formacion.bibliotecas.Consola.escribir;
import static com.ipartek.formacion.bibliotecas.Consola.leerBoolean;
import static com.ipartek.formacion.bibliotecas.Consola.leerInt;
import static com.ipartek.formacion.bibliotecas.Consola.p;

public class AdivinaElNumero {
	private static int objetivo = generarNumeroAleatorio();
	private static int numero;
	private static int rondas;

	public static void main(String[] args) {

		boolean JugarOtraVez = true;
		do {
			objetivo = generarNumeroAleatorio();
			p(objetivo);
			do {
				rondas++;
				pedirNumero();
				mostrarMensaje();
			} while (!haAcertado());
			JugarOtraVez = leerBoolean("quieres jugar otra vez?");
		} while (JugarOtraVez);
		escribir("Adios!");
	}

	private static boolean haAcertado() {
		return numero == objetivo;
	}

	private static int generarNumeroAleatorio() {
		rondas = 0;
		return 1 + (int) (Math.random() * 100);
	}

	private static void mostrarMensaje() {
		// Si el número es menor que el objetivo
		if (numero < objetivo) {
			// Mostrar que es menor
			p("El número es menor que el que hay que adivinar");
		} else {
			// Y si no, mirar si es mayor
			if (numero > objetivo) {
				// Si lo es, mostrar que es mayor
				p("El número es mayor que el que hay que adivinar");
			} else {
				// Si no es ni menor ni mayor, es igual
				p("Has acertado en " + rondas + " rondas");
			}
		}
	}

	private static int pedirNumero() {
		// Pedir número
		do {
			numero = leerInt("Introduce un número entre 1 y 100");
		} while (!esNumeroCorrecto());

		return numero;
	}

	private static boolean esNumeroCorrecto() {
		if (numero >= 1 && numero <= 100) {
			return true;
		} else {
			p("El número debe estar comprendido entre 1 y 100");
			return false;
		}
	}

}
