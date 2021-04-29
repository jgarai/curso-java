package com.ipartek.formacion.poo;

import static com.ipartek.formacion.bibliotecas.Consola.escribir;
import static com.ipartek.formacion.bibliotecas.Consola.leerDouble;
import static com.ipartek.formacion.bibliotecas.Consola.leerInt;

import java.util.Random;

public class EjerciciosBasicosArrays {

	public static void getMeanOfTenNumbers(String[] args) {
		/*
		 * Programa que lea por teclado 10 números enteros y los guarde en un array. A
		 * continuación calcula y muestra la media de los valores positivos y la de los
		 * valores negativos.
		 */
		int[] array = { 3, 4, -5, 6, 7, -7, 8, -3, 5, 1 };
		for (int i = 0; i < 10; i++) {
			array[i] = leerInt("introduce número");
		}
		int mediaPositivos = 0;
		int numeroPositivo = 0;
		int mediaNegativos = 0;
		int numeroNegativo = 0;

		for (int i : array) {
			if (i > 0) {
				mediaPositivos += i;
				numeroPositivo++;
			}
			if (i < 0) {
				mediaNegativos += i;
				numeroNegativo++;
			}
		}
		escribir("Media positivos: " + mediaPositivos / numeroPositivo);
		escribir("Media negativos: " + mediaNegativos / numeroNegativo);
	}

	public static void getMeanOfEvens(String[] args) {
		/*
		 * Programa Java que lea 10 números enteros por teclado y los guarde en un
		 * array. Calcula y muestra la media de los números que estén en las posiciones
		 * pares del array. Considera la primera posición del array (posición 0) como
		 * par.
		 * 
		 */
		int[] array = { 5, 4, 5, 6, 5, -7, 5, -3, 5, 1 };
		for (int i = 0; i < 10; i++) {
			array[i] = leerInt("introduce número");
		}
		int suma = 0;
		for (int i = 0; i < 10; i += 2) {
			suma += array[i];
		}
		escribir("Media pares: " + suma / 5);

	}

	public static void meanOfClassroom(String[] args) {
		/*
		 * Programa que lee por teclado la nota de los alumnos de una clase y calcula la
		 * nota media del grupo. También muestra los alumnos con notas superiores a la
		 * media. El número de alumnos se lee por teclado.
		 */

		int numeroAlumnos = leerInt("Introduce número de alumnos en la clase");
		double[] notas = new double[numeroAlumnos];
		double suma = 0;
		for (int i = 0; i < notas.length; i++) {
			notas[i] = leerDouble("introduce nota alumno [" + i + "]");
			suma += notas[i];

		}

		double media = suma / numeroAlumnos;
		escribir("La nota media de la clase es" + media);
		int i = 0;
		for (Double nota : notas) {

			if (nota > media) {
				escribir("Alumno [" + i + "] tiene nota superior a la media: " + nota);
			}
			i++;
		}

	}

	public static void ShowEvens(String[] args) {
		/*
		 * Programa que crea un array de 20 elementos llamado Pares y guarde los 20
		 * primeros números pares. Mostrar por pantalla el contenido del array creado.
		 * 
		 */
		int ARRAY_LENGTH = 20;

		int[] pares = new int[ARRAY_LENGTH];
		int number = 0;
		int index = 0;
		while (index < pares.length) {
			if (number % 2 == 0) {
				pares[index] = number;
				index++;
			}
			number++;

		}
		for (int value : pares) {
			System.out.printf("%s ", value);
		}
	}

	public static void findFromArrayZerosEvensAndOdds(String[] args) {
		/*
		 * Programa Java que guarda en un array 10 números enteros que se leen por
		 * teclado. A continuación se recorre el array y calcula cuántos números son
		 * positivos, cuántos negativos y cuántos ceros.
		 */
		int[] numeros = new int[10];
		int positivos = 0, negativos = 0, ceros = 0;
		for (int i = 0; i < 10; i++) {
			numeros[i] = leerInt("Introduce numero " + i);

		}
		for (int value : numeros) {
			if (value > 0) {
				positivos++;
			}
			if (value < 0) {
				negativos--;
			}
			if (value == 0) {
				ceros++;
			}

		}
		System.out.printf("Hay %d positivos / %d negativos / %d ceros", positivos, negativos, ceros);

	}

	public static void findMeanFromArrayElements(String[] args) {
		/*
		 * Programa Java que llene un array con 10 números enteros que se leen por
		 * teclado. A continuación calcula y muestra la media de los valores positivos y
		 * la de los valores negativos del array.
		 * 
		 */
		// es cero positivo?
		int[] numeros = new int[10];
		int positivos = 0, negativos = 0, ceros = 0;
		int sumaPositivos = 0, sumaNegativos = 0;
		for (int i = 0; i < 10; i++) {
			numeros[i] = leerInt("Introduce numero " + i);

		}
		for (int value : numeros) {
			if (value > 0) {
				sumaPositivos += value;
				positivos++;
			}
			if (value < 0) {
				sumaNegativos += value;
				negativos++;
			}
			if (value == 0) {
				ceros++;
			}
		}
		System.out.printf("La media de los %d positivos es %s\n", positivos, sumaPositivos / positivos);
		System.out.printf("La media de los %d negativos es %s\n", negativos, sumaNegativos / negativos);
	}

	public static void findHeightMean(String[] args) {
		/*
		 * Programa Java para leer la altura de N personas y calcular la altura media.
		 * Calcular cuántas personas tienen una altura superior a la media y cuántas
		 * tienen una altura inferior a la media. El valor de N se pide por teclado y
		 * debe ser entero positivo.
		 */
		int numeroPersonas = leerInt("Introduce número de personas");
		double[] alturas = new double[numeroPersonas];
		double sumaAlturas = 0;
		for (int i = 0; i < alturas.length; i++) {
			alturas[i] = leerDouble("introduce altura alumno [" + i + "]");
			sumaAlturas += alturas[i];

		}
		int sobreMedia = 0;
		int bajoMedia = 0;
		double alturaMedia = sumaAlturas / numeroPersonas;
		for (double altura : alturas) {
			if (altura > alturaMedia) {
				sobreMedia++;
			} else
				bajoMedia++;

		}
		System.out.printf("La altura media es %s\n", alturaMedia);
		System.out.printf("%d personas son más altas que la media y %d son más bajas\n", sobreMedia, bajoMedia);

	}

	public static void staffWages(String[] args) {
		/*
		 * Leer nombre y sueldo de 20 empleados y mostrar el que más gana
		 * http://puntocomnoesunlenguaje.blogspot.com/2013/02/arrays-java-empleado-que-
		 * mas-gana.html
		 */
	}

	public static void RandomNumber(String[] args) {
		/*
		 * Llenar un array con números aleatorios
		 */
		Random rnd = new Random();
		escribir(rnd.nextInt(100));

	}
}
