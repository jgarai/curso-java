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
		 * ArrayList de tipo Double. A continuación el programa calculará la altura
		 * media de todos los alumnos, cuantos alumnos hay más altos que la media y
		 * cuantos más bajos.
		 */
		int numeroAlumnos = leerInt("Introduce número de alumnos");
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
		System.out.printf("%d alumnos son más altos que la media y %d son más bajas\n", sobreMedia, bajoMedia);

	}

	public static void MeanOfArrayList(String[] args) {
		/*
		 * Programa Java que lea una serie de valores numéricos enteros desde el teclado
		 * y los guarde en un ArrayList de tipo Integer. La lectura de números enteros
		 * termina cuando se introduzca el valor -99. Este valor no se guarda en el
		 * ArrayList. A continuación el programa mostrará por pantalla el número de
		 * valores que se han leído, su suma y su media. Por último se mostrarán todos
		 * los valores leídos, indicando cuántos de ellos son mayores que la media.
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
		System.out.printf("\nSe han leído %s\n", cuantos);
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
		 * Método para desplazar todos los componentes de un Array un lugar a la
		 * derecha. El último elemento pasará a la primera posición.
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
		 * Calcular la cadena más larga en un ArrayList de Strings
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
		escribir("La cadena más larga es: " + strLonger + " y tiene " + strLonger.length() + " caracteres");

	}

}
