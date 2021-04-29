package com.ipartek.formacion.poo;

import static com.ipartek.formacion.bibliotecas.Consola.escribir;
import static com.ipartek.formacion.bibliotecas.Consola.leerChar;
import static com.ipartek.formacion.bibliotecas.Consola.leerString;

import java.util.ArrayList;
import java.util.Arrays;

public class EjerciciosStrings {
	public static void CountWordsInString(String[] args) {
		/*
		 * Contar el número de palabras de una frase en Java resolverlo utilizando solo
		 * los métodos de la clase String. En este caso se tratará de buscar los
		 * espacios en blanco dentro de la cadena y contarlos.
		 */
		int words = 1;
		// String str = new String("Programa que cuenta el número de palabras de un
		// texto. ");
		String str = leerString("introduce una frase");
		if (str.isEmpty()) {
			words = 0;
		} else {
			// clear string
			str = str.trim();
			char[] characters = str.toCharArray();
			for (char c : characters) {
				if (c == ' ')
					words++;
			}
		}
		escribir("La frase tiene " + words + " palabras.");
	}

	public static void removeLastWordFromSentence(String[] args) {
		/*
		 * Eliminar la última palabra de un String en Java
		 */
		String str = new String("Programa que cuenta el número de palabras de un texto. ");
		// String str = leerString("introduce una frase");
		if (str.isEmpty()) {
			escribir("frase vacia");
			return;
		}

		ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.split(" ")));
		// remove last elemto
		list.remove(list.size() - 1);
		escribir(list);

	}

	public static void findCharInSentence(String[] args) {
		int counter = 0;
		int cursor = 0;
		// char c = 'c';
		String str = new String("Programa que cuenta el número de palabras de un texto. ");
		// String str = leerString("introduce una frase");
		char c = leerChar("introduce caracter");
		if (str.isEmpty()) {
			escribir("frase vacia");
			return;
		}
		while (cursor < str.length()) {
			if (str.charAt(cursor) == c) {
				counter++;
			}
			cursor++;
		}
		escribir("El cararacter <" + c + "> es encontrado " + counter + " veces.");

	}
}
