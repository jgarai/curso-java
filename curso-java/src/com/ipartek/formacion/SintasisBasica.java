package com.ipartek.formacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Clase para demostraci�n de sintaxis b�sica de Java
 * 
 * @author Curso
 *
 */

public class SintaxisBasica {
	/**
	 * Metodo de entrada para la aplicaci�n
	 * 
	 * @param args argumentos introducidos por consola
	 */
	@SuppressWarnings("unused")
	public static void mainExpresiones(String[] args) {
		// TODO Hacer ejemplos de variables
		int x = 5;

		long l = 6L;

		char c = 'a';
		char enter = '\n';
		boolean encendido = true;
		double dato = 1234.34E234;
		int datoInt = (int) dato;

		// +, - *, /, %
		int restoDivisionEntero = 5 % 3;
		System.out.println(restoDivisionEntero);

		int xor = 5 ^ 2;

		System.out.println(xor);

		double potencia = Math.pow(5, 2);

		System.out.println(potencia);

		// <, >, <=, =>, ==, !=

		System.out.println(1 + x + 10);
		// System.out.println(1 <= x <= 10);

		System.out.println(1 <= x && x <= 10);

		// &&, &, ||, |, !

		// +=, *=, /=, -=,
		x = x + 1;
		x += 1;

		++x;
		x++;
		--x;
		x--;

		// >>, >>, >>>, &, | ^, ~ a nivel de bits
		System.out.println("BITS");
		System.out.println(10 >> 2);
		System.out.println(10 << 2);
		
		// ? :
		boolean b = true;
		System.out.println(b ? "VERDADERO" : "FALSO");
		x = 5;
		int y = 7;
		int max = x > y ? x : y;
		System.out.println(max);

	}

	public static void mainString(String[] args) {
		String s = "" + 5;
		System.out.println(s);
		
	}
	public static void main(String[] args) {
		ArrayList<String> nombres = new ArrayList<>();
		nombres.add("jose");
		
		HashMap<String, Integer> numeros = new HashMap<>();
		
		HashSet<String> conjunto = new HashSet<>();
		
		GregorianCalendar gc = new GregorianCalendar();
		
		LocalDate ld;
		
		
	
		
	}
}
