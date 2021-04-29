package com.ipartek.formacion.poo;

import static com.ipartek.formacion.bibliotecas.Consola.escribir;
import static com.ipartek.formacion.bibliotecas.Consola.leerBoolean;
import static com.ipartek.formacion.bibliotecas.Consola.leerInt;
import static com.ipartek.formacion.bibliotecas.Consola.leerString;

import java.util.ArrayList;

public class EjerciciosGenerales {
	public static void SwapIntegers(String[] args) {
		/*
		 * Intercambiar el contenido de dos variables en Java
		 */
		int numeroA = leerInt("introduce un n�mero");
		int numeroB = leerInt("introduce otro n�mero");
		escribir("los n�meros son " + numeroA + " y " + numeroB);

		int aux = numeroB;
		numeroB = numeroA;
		numeroA = aux;
		escribir("los numeros intercambiados son " + numeroA + " y " + numeroB);

	}

	public static void swapWithoutAuxiliarVariable(String[] args) {
		/*
		 * INTERCAMBIO DE VALORES ENTRE DOS VARIABLES SIN UTILIZAR VARIABLE AUXILIAR.
		 * Tambi�n se puede intercambiar el valor de dos variables sin utilizar una
		 * variable auxiliar.
		 */

		int numeroA = leerInt("introduce un n�mero");
		int numeroB = leerInt("introduce otro n�mero");
		escribir("los n�meros son " + numeroA + " y " + numeroB);

		numeroA = numeroA + numeroB;
		numeroB = numeroA - numeroB;
		numeroA = numeroA - numeroB;

		escribir("los numeros intercambiados son " + numeroA + " y " + numeroB);

	}

	public static void countNumberOfFigures() {
		/*
		 * Contar las cifras de un n�mero entero en Java
		 */
		int cifras;
		int numero;
		do {
			cifras = 0;
			numero = leerInt("introduce un n�mero");
			do {
				numero /= 10;
				cifras++;

			} while (numero > 0);
			escribir("El n�mero tiene " + cifras);
		} while (leerBoolean("Continuar"));
		escribir("Adios!");

	}

	public static void multiplicationTable(String[] args) {
		/*
		 * Mostrar la tabla de multiplicar de un n�mero en Java
		 */
		int numero = leerInt("introduce un n�mero");
		for (int i = 1; i != 11; i++) {
			System.out.printf("%d * %d = %d\n", numero, i, numero * i);
		}

	}

	public static void TwoEndedNumbers(String[] args) {
		/*
		 * Programa que lea una serie de n�meros por teclado hasta que se lea un n�mero
		 * negativo. El programa indicar� cu�ntos n�meros acabados en 2 se han le�do.
		 */
		ArrayList<Integer> lista = new ArrayList<Integer>();
		int numero = 0;
		int contador = 0;
		while (numero >= 0) {
			numero = leerInt("introduce un n�mero (negativo para salir)");
			lista.add(numero);
		}
		for (Integer i : lista) {
			if (i % 10 == 2) {
				escribir(i);
				contador++;
			}
		}
	}

	public static void isPerfectNumber(String[] args) {
		/*
		 * Un n�mero es perfecto si es igual a la suma de todos sus divisores positivos
		 * sin incluir el propio n�mero.
		 * 
		 */
		int numero = leerInt("introduce un n�mero");
		int match = 0;
		String plus = new String(" + ");
		String msg = new String();
		for (int i = 1; i < numero; i++) {
			if (numero % i == 0) {
				match += i;
				if (numero / 2 == i)
					plus = "";
				msg = msg + i + plus;
			}
		}
		if (numero == match) {
			System.out.printf("El n�mero %d es un n�mero perfecto porque %s = %d\n", numero, msg, numero);
		} else {
			System.out.printf("El n�mero %d no es un n�mero perfecto\n", numero);
		}
	}

	public static void findPerfectNumbersUntil1000() {
		/*
		 * Utilizando el algoritmo anterior vamos a escribir ahora el programa Java que
		 * muestre los n�meros perfectos entre 1 y 1000
		 * 
		 */
		int numero;
		int match;

		numero = 1;
		do {
			match = 0;
			for (int i = 1; i < numero; i++) {
				if (numero % i == 0) {
					match += i;
				}
			}
			if (numero == match) {
				System.out.printf("El n�mero %d es perfecto\n", numero);
			}
		} while (numero++ < 1000);
	}

	public static void areFriendNumbers(String[] args) {
		/*
		 * Dos n�meros enteros positivos A y B son n�meros amigos si la suma de los
		 * divisores propios de A es igual a B y la suma de los divisores propios de B
		 * es igual a A.
		 * 
		 * Un ejemplo de n�meros amigos son los n�meros 220 y 284. Los divisores propios
		 * de 220 son 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 y 110. La suma de los divisores
		 * propios de 220 da como resultado 284 Los divisores propios de 284 son 1, 2,
		 * 4, 71 y 142. La suma de los divisores propios de 284 da como resultado 220.
		 * Por lo tanto 220 y 284 son amigos.
		 */
		int numeroA = leerInt("introduce un n�mero");
		int numeroB = leerInt("introduce un n�mero");

		int matchB = 0;
		int matchA = 0;
		for (int i = 1; i < numeroA; i++) {
			if (numeroA % i == 0) {
				matchA += i;
			}
		}
		for (int i = 1; i < numeroB; i++) {
			if (numeroB % i == 0) {
				matchB += i;
			}
		}

		if (matchA == numeroB && matchB == numeroA)
			escribir("Son n�meros amigos");
		else
			escribir("No son tan amigos");
		escribir("Adios!");

	}

	public static void fibonacci(String[] args) {
		/*
		 * Vamos a escribir el programa java que muestra los N primeros n�meros de la
		 * serie. El valor de N se lee por teclado.
		 * 
		 * El primer t�rmino de la serie es el n�mero 1 El segundo t�rmino de la serie
		 * es el n�mero 1 Los siguientes t�rminos de la serie de fibonacci se obtienen
		 * de la suma de los dos anteriores:
		 * 
		 * 1, 1, 2, 3, 5, 8, 13, .....
		 */
		int last = leerInt("introduce un n�mero");

		int fib1 = 1;
		int fib2 = 1;
		do {
			escribir(fib1);
			escribir(fib2);
			fib1 = fib1 + fib2;
			fib2 = fib1 + fib2;
		} while (fib2 < last);

	}

	public static void fromDecimalToBinary(String[] args) {
		/*
		 * En esta entrada vamos a escribir el programa java para convertir un n�mero de
		 * decimal a binario.
		 * 
		 */
		int numero = leerInt("Introduce un n�mero");
		String result = new String("");

		while (numero > 0) {
			result = (numero % 2) + result;
			numero /= 2;

		}
		if (result.length() == 0)
			result = "0";
		escribir(result);

	}

	public static void fromBinaryToDecimal123(String[] args) {
		/*
		 * CONVERTIR UN N�MERO DE BINARIO A DECIMAL EN JAVA
		 */
		String binary = leerString("Introduce un n�mero binario");
		int c, pow, acu = 0;
		for (int i = 0; i != binary.length(); i++) {
			c = binary.charAt(binary.length() - i - 1) - 48;
			acu = acu + (c * (int) Math.pow(2, i));
		}
		escribir(acu);

	}

	public static void toRoman(String[] args) {
		/*
		 * Convertir a n�meros romanos en Java
		 * http://puntocomnoesunlenguaje.blogspot.com/2014/12/convertir-numeros-romanos-
		 * en-java.html
		 * 
		 */

	}

	public static void CaesarEncryption(String[] args) {
		/*
		 * Cifrado C�sar en Java
		 * http://puntocomnoesunlenguaje.blogspot.com/2016/02/cifrado-cesar-java.html
		 */

	}

	public static void isCapicua() {
		/*
		 * N�mero capic�a en Java
		 * 
		 * It woks with palindomes too!
		 */
		String str = leerString("Introduce un n�mero binario");
		// String str = new String("12321");
		String reverse = (new StringBuilder(str)).reverse().toString();
		if (str.compareTo(reverse) == 0) {
			escribir("Es capic�a!");
		} else {
			escribir("No es capic�a!");
		}

	}

	public static void ClassroomMeanMaxMin(String[] args) {
		/*
		 * Calcular la nota media, nota mayor y nota menor de una serie de alumnos
		 * Introducir por teclado el n�mero de alumnos y para cada alumno pediremos su
		 * nota.
		 */
		int numeroAlummnos = leerInt("Introduce c�antos alumnos hay en clase");
		int max = 0, min = 10, media = 0;
		for (int i = 0, nota = 0; i < numeroAlummnos; i++) {
			nota = leerInt("Introduzca nota para el alumno " + i);
			max = Math.max(max, nota);
			min = Math.min(min, nota);
			media = media + nota;
		}
		double mediaDouble;
		mediaDouble = media / numeroAlummnos;
		escribir("nota media de la clase: " + mediaDouble);
		escribir("nota maxima de la clase: " + max);
		escribir("nota minima de la clase: " + min);

	}
}
