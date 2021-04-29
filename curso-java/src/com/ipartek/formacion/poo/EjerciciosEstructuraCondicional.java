package com.ipartek.formacion.poo;

import java.util.Scanner;

public class EjerciciosEstructuraCondicional {
	public static void isEvenOrOdd(String[] args) {
		/*
		 * Relación Nº 1: Ejercicios 1, 2 y 3 1. Programa Java que lea un número entero
		 * por teclado y calcule si es par o impar. Podemos saber si un número es par si
		 * el resto de dividir el número entre 2 es igual a cero. En caso contrario el
		 * número es impar El operador Java que calcula el resto de la división entre
		 * dos números enteros o no es el operador % El programa que calcula si un
		 * número entero es par o impar es el siguiente:
		 */
		int entero, resto;
		Scanner input = new Scanner(System.in);
		System.out.println("Dame un múmero y te digo si es par o inpar:");
		entero = input.nextInt();
		resto = entero % 2;
		if (resto == 0) {
			System.out.println("El numero es par!!!");

		} else {
			System.out.println("el número es impar!!!");
		}

	}

	public static void isDivisibleByTen(String[] args) {
		/*
		 * 2. Programa que lea un número entero y muestre si el número es múltiplo de
		 * 10. Podemos comprobar si un número entero es múltiplo de 10 si al dividirlo
		 * por 10 el resto de esta división es cero.
		 */
		int entero, decima;
		Scanner input = new Scanner(System.in);
		System.out.println("Dame un múmero y te digo si es multiplo de 10:");
		entero = input.nextInt();
		decima = entero % 10;
		if (decima == 0) {
			System.out.println("El numero SÍ es multiplo de 10!!!");

		} else {
			System.out.println("l numero NO es multiplo de 10!!!");
		}
	}

	public static void isUpperOrLowerCase(String[] args) {
		/*
		 * Programa que lea un carácter por teclado y compruebe si es una letra
		 * mayúscula
		 */
		char caracter;
		Scanner input = new Scanner(System.in);
		System.out.println("introduce una letra del alfabeto");
		caracter = input.next().charAt(0);

		if (caracter >= 'a' && caracter <= 'z' || caracter == 'ñ') {
			System.out.println("la letra es minuscula");
		} else if (caracter >= 'A' && caracter <= 'Z' || caracter == 'Ñ') {
			System.out.println("la letra es mayuscula");
		} else {
			System.out.println("No sé que es!");
		}

	}

	public static void areEqual(String[] args) {
		/*
		 * Ejercicio 4: Programa que lea dos caracteres y compruebe si son iguales.
		 */
		char caracterA;
		Scanner input = new Scanner(System.in);
		System.out.println("introduce una letra del alfabeto");
		caracterA = input.next().charAt(0);
		char caracterB;
		System.out.println("introduce otra letra del alfabeto");
		caracterB = input.next().charAt(0);
		if (caracterA == caracterB) {
			System.out.println("Sí son iguales!");
		} else {
			System.out.println("No son iguales");
		}
	}

	public static void areBothLowerCase(String[] args) {
		/*
		 * Programa java que lea dos caracteres por teclado y compruebe si los dos son
		 * letras minúsculas
		 */
		char caracterA;
		Scanner input = new Scanner(System.in);
		System.out.println("introduce una letra del alfabeto");
		caracterA = input.next().charAt(0);
		char caracterB;
		System.out.println("introduce otra letra del alfabeto");
		caracterB = input.next().charAt(0);
		if (Character.isLowerCase(caracterA) && Character.isLowerCase(caracterB)) {
			System.out.println("Ambos carcateres son letras minusculas");
		} else {
			System.out.println("No son ambos letras minusculas");
		}
	}

	public static void isCharacterDigit(String[] args) {
		/*
		 * Programa java que lea un carácter por teclado y compruebe si es un dígito
		 * numérico (cifra entre 0 y 9). Vamos a escribir dos soluciones a este
		 * ejercicio. La primera consiste en comprobar si el carácter es un dígito
		 * mediante el método isDigit de la clase Character. Este método devuelve true
		 * si el carácter que se le pasa como parámetro es una cifra entre 0 y 9:
		 */
		char caracterA;
		Scanner input = new Scanner(System.in);
		System.out.println("introduce un digito:");
		caracterA = input.next().charAt(0);
		if (caracterA >= 47 && caracterA <= 57) {
			System.out.println("el carácter es un dígito");
		} else {
			System.out.println("el caráter no es un dígito");
		}

	}

	public static void divideBy(String[] args) {
		/*
		 * Programa que lea dos números por teclado y muestre el resultado de la
		 * división del primer número por el segundo. Se debe comprobar que el divisor
		 * no puede ser cero.
		 */
		int numeroA, numeroB;
		double result;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un número:");
		numeroA = input.nextInt();
		System.out.println("Introduce otro número");
		numeroB = input.nextInt();
		try {
			result = numeroA / numeroB;
			System.out.printf("El resultado es %.2f", result);
		} catch (ArithmeticException e) {
			System.out.println("Error dividiendo por 0");
		}

	}

	public static void getMaxOfThee(String[] args) {
		/*
		 * Calcular el mayor de tres números enteros en Java. El programa lee por
		 * teclado tres números enteros y calcula y muestra el mayor de los tres.
		 */
		int numeroA, numeroB, numeroC;
		int result;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un número:");
		numeroA = input.nextInt();
		System.out.println("Introduce otro número");
		numeroB = input.nextInt();
		System.out.println("Introduce el tercer número");
		numeroC = input.nextInt();

		result = Math.max(numeroC, Math.max(numeroA, numeroB));
		System.out.printf("El número mayor de los tres es %s", result);

	}

	public static void isValidTime(String[] args) {
		/*
		 * Programa que lea por teclado tres números enteros H, M, S correspondientes a
		 * hora, minutos y segundos respectivamente, y comprueba si la hora que indican
		 * es una hora válida. Supondremos que se leemos una hora en modo 24 Horas, es
		 * decir, el valor válido para las horas será mayor o igual que cero y menor que
		 * 24. El valor válido para los minutos y segundos estará comprendido entre 0 y
		 * 59 ambos incluidos
		 */
		int hora, minutos, segundos;
		int result;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce horas [0-23]:");
		hora = input.nextInt();
		System.out.println("Introduce minutos [0-59]:");
		minutos = input.nextInt();
		System.out.println("Introduce segundos [0-59]:");
		segundos = input.nextInt();

		if (hora >= 0 && hora <= 23 && minutos >= 0 && minutos <= 59 && segundos >= 0 && minutos <= 59) {
			System.out.println("la hora es válida");

		} else {
			System.out.println("la hora No es válida");
		}
	}

	public static void daysMonth(String[] args) {
		/*
		 * Programa que lea una variable entera mes y compruebe si el valor corresponde
		 * a un mes de 30 días, de 31 o de 28. Supondremos que febrero tiene 28 días. Se
		 * mostrará además el nombre del mes. Se debe comprobar que el valor introducido
		 * esté comprendido entre 1 y 12.
		 */
		int mes;
		int[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca el mes:");
		mes = input.nextInt();

		if (mes >= 1 && mes <= 12) {
			System.out.printf("el mes tiene %d días", diasMes[mes]);

		} else {
			System.out.println("el mes no es válido");
		}

	}
}
