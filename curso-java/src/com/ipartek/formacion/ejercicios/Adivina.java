package com.ipartek.formacion.ejercicios;

import static com.ipartek.formacion.bibliotecas.Consola.*;

public class Adivina {

	private static int objetivo, numero;
	
	public static void main(String[] args) {
		
		generarNumeroAleatorio();
		
		mostrarObjetivo();
		
		do {
			pedirNumero();
			
			mostrarMensaje();
		} while(!haAcertado());
	}

	private static void mostrarMensaje() {
		if(numero < objetivo) {
			p("El n�mero es menor que el objetivo");
		} else {
			if(numero > objetivo) {
				p("El n�mero es mayor que el objetivo");
			} else {
				p("Has acertado");
			}
		}
	}

	private static void pedirNumero() {
		do {
			numero = leerInt("Introduce un n�mero entre 1 y 100");
		}while(!esNumeroCorrecto());
	}

	private static boolean esNumeroCorrecto() {
		if(numero >= 1 && numero <= 100) {
			return true;
		} else {
			p("El n�mero debe estar comprendido entre 1 y 100");
			return false;
		}
	}

	private static boolean haAcertado() {
		return numero == objetivo;
	}

	private static void mostrarObjetivo() {
		p(objetivo);
	}

	private static void generarNumeroAleatorio() {
		objetivo = 1 + (int) (Math.random() * 100);
	}
}
