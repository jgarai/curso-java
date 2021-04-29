package com.ipartek.formacion.poo;

import static com.ipartek.formacion.bibliotecas.Consola.escribir;
import static com.ipartek.formacion.bibliotecas.Consola.leerDouble;
import static com.ipartek.formacion.bibliotecas.Consola.leerInt;
import static com.ipartek.formacion.bibliotecas.Consola.leerString;

import java.util.ArrayList;
import java.util.Arrays;

public class EjerciciosArrayList {
	public static void FindHeightMeanArraList(String[] args) {
		/*
		 * Calcular la altura media de los alumnos de una clase Programa Java que pida
		 * por teclado las alturas de N alumnos de una clase y las guarde en un
		 * ArrayList de tipo Double. A continuaci�n el programa calcular� la altura
		 * media de todos los alumnos, cuantos alumnos hay m�s altos que la media y
		 * cuantos m�s bajos.
		 */
		int numeroAlumnos = leerInt("Introduce n�mero de alumnos");
		// double[] alturas = new double[numeroAlumnos];
		ArrayList<Double> alturas = new ArrayList<>();
		double suma = 0l;

		for (int i = 0; i < numeroAlumnos; i++) {
			alturas.add(leerDouble("introduce altura alumno [" + i + "]"));
			suma += alturas.get(i);
		}
		double alturaMedia = suma / numeroAlumnos;
		int sobreMedia = 0;
		int bajoMedia = 0;

		for (double altura : alturas) {
			if (altura > alturaMedia)
				sobreMedia++;
			else
				bajoMedia++;
		}
		System.out.printf("La altura media es %s\n", alturaMedia);
		System.out.printf("%d alumnos son m�s altos que la media y %d son m�s bajas\n", sobreMedia, bajoMedia);

	}

	public static void MeanOfArrayList(String[] args) {
		/*
		 * Programa Java que lea una serie de valores num�ricos enteros desde el teclado
		 * y los guarde en un ArrayList de tipo Integer. La lectura de n�meros enteros
		 * termina cuando se introduzca el valor -99. Este valor no se guarda en el
		 * ArrayList. A continuaci�n el programa mostrar� por pantalla el n�mero de
		 * valores que se han le�do, su suma y su media. Por �ltimo se mostrar�n todos
		 * los valores le�dos, indicando cu�ntos de ellos son mayores que la media.
		 * 
		 */
		ArrayList<Integer> numeros = new ArrayList<>();
		int entradaInt = 0;
		int cuantos = 0;
		while (entradaInt != -99) {

			entradaInt = leerInt("introduce numero");
			if (entradaInt != -99) {
				numeros.add(entradaInt);
				cuantos++;
			}

		}
		System.out.printf("\nSe han le�do %s\n", cuantos);
		int suma = 0;
		for (int i : numeros) {
			suma += i;
		}
		double media = suma / cuantos;
		System.out.printf("La suma de todos ellos es: %s\n", suma);
		System.out.printf("La media de todos ellos es: %s\n", media);
		for (int i : numeros) {
			System.out.printf("\n%s", i);
			if (i > media) {
				System.out.printf(" es superior a la media");
			}
		}

	}

	public static void rotateArrayOneRight(String[] args) {
		/*
		 * M�todo para desplazar todos los componentes de un Array un lugar a la
		 * derecha. El �ltimo elemento pasar� a la primera posici�n.
		 */
		Integer[] aux = { 3, 5, 6, 7, 8, 4, 9 };

		ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(aux));

		Integer temporal;
		Integer izquierda;
		temporal = numeros.get(numeros.size() - 1);
		for (int i = numeros.size() - 1; i != 0; i--) {
			izquierda = numeros.get(i - 1);
			numeros.set(i, izquierda);
		}
		numeros.set(0, temporal);

		for (Integer i : numeros) {
			escribir(i);
		}

	}

	public static void leerArray(ArrayList<String> strings) {
		String str = leerString("introduce cadena de texto");
		while (!str.equalsIgnoreCase("FIN")) {
			strings.add(str);
			str = leerString("introduce cadena de texto");
		}

	}

	public static void findLongestStringInArray(String[] args) {
		/*
		 * Calcular la cadena m�s larga en un ArrayList de Strings
		 */
		ArrayList<String> strings = new ArrayList<String>();
		leerArray(strings);
		String strLonger = "";

		for (String str : strings) {
			if (str.length() > strLonger.length()) {
				strLonger = str;
			}
			escribir(str);
		}
		escribir("La cadena m�s larga es: " + strLonger + " y tiene " + strLonger.length() + " caracteres");

	}

}
