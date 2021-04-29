package com.ipartek.formacion.poo;

import static com.ipartek.formacion.bibliotecas.Consola.escribir;

public class EjerciciosRecursividad {

	public static int powTwo(int number) {
		/*
		 * Calcular 2 elevado a n
		 * 
		 */
		if (number == 0) {
			return 1;

		}
		return 2 * powTwo(number - 1);

	}

	public static void testPowTwo(String[] args) {
		int pow = powTwo(10);
		escribir(pow);
	}

	public static int digitCounter(int number) {
		/*
		 * Contar las cifras de un numero entero de forma recursiva
		 * 
		 */
		if (number < 10)
			return 1;
		return 1 + digitCounter(number / 10);

	}

	public static void testDigitCounter(String[] args) {
		escribir(digitCounter(12345634));

	}

	public static int sum(int number) {
		/*
		 * Suma Recursiva de números desde 1 hasta N
		 */
		if (number == 1) {
			return 1;

		}
		return number + sum(number - 1);

	}

	public static void testSum(String[] args) {
		escribir(sum(3));

	}

	public static int quotient(int dividend, int divider) {
		/*
		 * Calcular el cociente de dos números enteros.
		 * 
		 */
		if (dividend < divider)
			return 0;

		return 1 + quotient(dividend - divider, divider);

	}

	public static void testQuotient(String[] args) {
		escribir(quotient(300, 3));
	}

	public static String binary(int decimal) {
		/*
		 * Pasar de Decimal a Binario de forma recursiva
		 * 
		 */
		if (decimal == 1) {
			return "1";
		}
		if (decimal == 0) {
			return "0";
		}
		if (decimal % 2 == 1) {
			return binary(decimal / 2) + "1";
		}
		if (decimal % 2 == 0) {
			return binary(decimal / 2) + "0";
		}
		return "";
	}

	public static void testBinary(String[] args) {
		escribir(binary(234));

	}
}
