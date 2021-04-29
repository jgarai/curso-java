package com.ipartek.formacion.poo;

import java.util.Scanner;

public class EjerciciosEstructuraCondicional {
	public static void isEvenOrOdd(String[] args) {
		/*
		 * Relaci�n N� 1: Ejercicios 1, 2 y 3 1. Programa Java que lea un n�mero entero
		 * por teclado y calcule si es par o impar. Podemos saber si un n�mero es par si
		 * el resto de dividir el n�mero entre 2 es igual a cero. En caso contrario el
		 * n�mero es impar El operador Java que calcula el resto de la divisi�n entre
		 * dos n�meros enteros o no es el operador % El programa que calcula si un
		 * n�mero entero es par o impar es el siguiente:
		 */
		int entero, resto;
		Scanner input = new Scanner(System.in);
		System.out.println("Dame un m�mero y te digo si es par o inpar:");
		entero = input.nextInt();
		resto = entero % 2;
		if (resto == 0) {
			System.out.println("El numero es par!!!");

		} else {
			System.out.println("el n�mero es impar!!!");
		}

	}

	public static void isDivisibleByTen(String[] args) {
		/*
		 * 2. Programa que lea un n�mero entero y muestre si el n�mero es m�ltiplo de
		 * 10. Podemos comprobar si un n�mero entero es m�ltiplo de 10 si al dividirlo
		 * por 10 el resto de esta divisi�n es cero.
		 */
		int entero, decima;
		Scanner input = new Scanner(System.in);
		System.out.println("Dame un m�mero y te digo si es multiplo de 10:");
		entero = input.nextInt();
		decima = entero % 10;
		if (decima == 0) {
			System.out.println("El numero S� es multiplo de 10!!!");

		} else {
			System.out.println("l numero NO es multiplo de 10!!!");
		}
	}

	public static void isUpperOrLowerCase(String[] args) {
		/*
		 * Programa que lea un car�cter por teclado y compruebe si es una letra
		 * may�scula
		 */
		char caracter;
		Scanner input = new Scanner(System.in);
		System.out.println("introduce una letra del alfabeto");
		caracter = input.next().charAt(0);

		if (caracter >= 'a' && caracter <= 'z' || caracter == '�') {
			System.out.println("la letra es minuscula");
		} else if (caracter >= 'A' && caracter <= 'Z' || caracter == '�') {
			System.out.println("la letra es mayuscula");
		} else {
			System.out.println("No s� que es!");
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
			System.out.println("S� son iguales!");
		} else {
			System.out.println("No son iguales");
		}
	}

	public static void areBothLowerCase(String[] args) {
		/*
		 * Programa java que lea dos caracteres por teclado y compruebe si los dos son
		 * letras min�sculas
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
		 * Programa java que lea un car�cter por teclado y compruebe si es un d�gito
		 * num�rico (cifra entre 0 y 9). Vamos a escribir dos soluciones a este
		 * ejercicio. La primera consiste en comprobar si el car�cter es un d�gito
		 * mediante el m�todo isDigit de la clase Character. Este m�todo devuelve true
		 * si el car�cter que se le pasa como par�metro es una cifra entre 0 y 9:
		 */
		char caracterA;
		Scanner input = new Scanner(System.in);
		System.out.println("introduce un digito:");
		caracterA = input.next().charAt(0);
		if (caracterA >= 47 && caracterA <= 57) {
			System.out.println("el car�cter es un d�gito");
		} else {
			System.out.println("el car�ter no es un d�gito");
		}

	}

	public static void divideBy(String[] args) {
		/*
		 * Programa que lea dos n�meros por teclado y muestre el resultado de la
		 * divisi�n del primer n�mero por el segundo. Se debe comprobar que el divisor
		 * no puede ser cero.
		 */
		int numeroA, numeroB;
		double result;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un n�mero:");
		numeroA = input.nextInt();
		System.out.println("Introduce otro n�mero");
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
		 * Calcular el mayor de tres n�meros enteros en Java. El programa lee por
		 * teclado tres n�meros enteros y calcula y muestra el mayor de los tres.
		 */
		int numeroA, numeroB, numeroC;
		int result;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce un n�mero:");
		numeroA = input.nextInt();
		System.out.println("Introduce otro n�mero");
		numeroB = input.nextInt();
		System.out.println("Introduce el tercer n�mero");
		numeroC = input.nextInt();

		result = Math.max(numeroC, Math.max(numeroA, numeroB));
		System.out.printf("El n�mero mayor de los tres es %s", result);

	}

	public static void isValidTime(String[] args) {
		/*
		 * Programa que lea por teclado tres n�meros enteros H, M, S correspondientes a
		 * hora, minutos y segundos respectivamente, y comprueba si la hora que indican
		 * es una hora v�lida. Supondremos que se leemos una hora en modo 24 Horas, es
		 * decir, el valor v�lido para las horas ser� mayor o igual que cero y menor que
		 * 24. El valor v�lido para los minutos y segundos estar� comprendido entre 0 y
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
			System.out.println("la hora es v�lida");

		} else {
			System.out.println("la hora No es v�lida");
		}
	}

	public static void daysMonth(String[] args) {
		/*
		 * Programa que lea una variable entera mes y compruebe si el valor corresponde
		 * a un mes de 30 d�as, de 31 o de 28. Supondremos que febrero tiene 28 d�as. Se
		 * mostrar� adem�s el nombre del mes. Se debe comprobar que el valor introducido
		 * est� comprendido entre 1 y 12.
		 */
		int mes;
		int[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca el mes:");
		mes = input.nextInt();

		if (mes >= 1 && mes <= 12) {
			System.out.printf("el mes tiene %d d�as", diasMes[mes]);

		} else {
			System.out.println("el mes no es v�lido");
		}

	}
}
