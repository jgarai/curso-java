package com.ipartek.formacion.poo;

import java.util.Scanner;

public class EjerciciosEstructuraAIterativa {

	public static void countUntil100While(String[] args) {
		/*
		 * Ejemplo de uso de while: Programa Java que muestre los n�meros del 1 al 100
		 * utilizando la instrucci�n while.
		 */
		int i = 1;
		while (i < 101) {
			System.out.printf("%d \n", i);
			i++;
		}
	}

	public static void countUntil100DoWhile(String[] args) {
		/*
		 * Ejemplo de uso de do-while. Programa Java que muestre los n�meros del 1 al
		 * 100 utilizando la instrucci�n do..while.
		 */
		int i = 1;
		do {
			System.out.printf("%d \n", i);
			i++;
		} while (i <= 100);
	}

	public static void countUntil100For(String[] args) {
		/*
		 * Ejemplo de uso de for. Programa Java que muestre los n�meros del 1 al 100
		 * utilizando la instrucci�n for. /
		 */
		for (int i = 1; i <= 100; i++) {
			System.out.printf("%d \n", i);
		}

	}

	public static void countFrom100To1WithWhile(String[] args) {
		/*
		 * Ejemplo de uso de while. Programa Java que muestre los n�meros del 100 al 1
		 * utilizando la instrucci�n while.
		 */
		int i = 100;
		while (i > 0) {
			System.out.printf("%d \n", i);
			i--;
		}
	}

	public static void countFrom100To1WithDoWhile(String[] args) {
		/*
		 * Ejemplo de uso de do-while. Programa Java que muestre los n�meros del 100 al
		 * 1 utilizando la instrucci�n do..while.
		 */
		int i = 100;
		do {
			System.out.printf("%d \n", i);
			i--;
		} while (i >= 1);

	}

	public static void countFrom100To1WithFor(String[] args) {
		/*
		 * Ejemplo de for. Programa Java que muestre los n�meros del 100 al 1 utilizando
		 * la instrucci�n for.
		 */
		for (int i = 100; i >= 1; i--) {
			System.out.printf("%d \n", i);

		}

	}

	public static void countUntilNWhile(String[] args) {
		/*
		 * Escribe un programa Java que pida por teclado el valor de un n�mero N y
		 * muestre por pantalla todos los n�meros desde 1 hasta N Utilizando la
		 * estructura for
		 */
		int i = 1;
		int end;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce numero:\n");
		end = input.nextInt() + 1;

		while (i < end) {
			System.out.printf("%d \n", i);
			i++;
		}

	}

	public static void countUntilNDoWhile() {
		/*
		 * Escribe un programa Java que pida por teclado el valor de un n�mero N y
		 * muestre por pantalla todos los n�meros desde 1 hasta N Utilizando la
		 * estructura do while
		 */
		int i = 1;
		int end;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce numero:\n");
		end = input.nextInt();

		do {
			System.out.printf("%d \n", i);
			i++;
		} while (i <= end);
	}

	public static void countUntilNFor(String[] args) {
		/*
		 * Escribe un programa Java que pida por teclado el valor de un n�mero N y
		 * muestre por pantalla todos los n�meros desde 1 hasta N Utilizando la
		 * estructura do for
		 */
		int i = 1;
		int end;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce numero:\n");
		end = input.nextInt();

		for (; i <= end; i++) {
			System.out.printf("%d \n", i);
		}
	}

	public static void countFromNTo1WithWhile() {
		/*
		 * Ejemplo de uso de while. N�meros desde N hasta 1 utilizando la estructura
		 * while.
		 */
		int i;

		Scanner input = new Scanner(System.in);
		System.out.println("Introduce numero:\n");
		i = input.nextInt();
		while (i > 0) {
			System.out.printf("%d \n", i);
			i--;

		}

	}

	public static void countFromNTo1WithDoWhile() {
		/*
		 * N�meros desde N hasta 1 utilizando la estructura do .. while.
		 */
		int i;

		Scanner input = new Scanner(System.in);
		System.out.println("Introduce numero:\n");
		i = input.nextInt();
		do {
			System.out.printf("%d \n", i);
			i--;
		} while (i > 0);

	}

	public static void countFromNTo1WithFor() {
		/*
		 * N�meros desde N hasta 1 utilizando la estructura for.
		 */
		int i;

		Scanner input = new Scanner(System.in);
		System.out.println("Introduce numero:\n");
		i = input.nextInt();

		for (; i >= 1; i--) {
			System.out.printf("%d \n", i);
		}

	}

	public static void countFromAtoB(String[] args) {
		/*
		 * Programa que pida que se introduzcan dos n�meros enteros por teclado y
		 * muestre los n�meros desde el menor hasta el mayor de los n�meros
		 * introducidos. Los dos n�meros introducidos deben ser distintos. Si son
		 * iguales se mostrar� un mensaje indic�ndolo y se vuelven a introducir.
		 */
		int numeroA, numeroB;
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Introduce numero:\n");
			numeroA = input.nextInt();
			System.out.println("Introduce numero:\n");
			numeroB = input.nextInt();
			if (numeroA == numeroB) {
				System.out.println("Los numeros han de ser distintos!");
			}
		} while (numeroA == numeroB);
		int menor = Math.min(numeroA, numeroB);
		int mayor = Math.max(numeroA, numeroB);

		do {
			System.out.println(menor);
		} while (menor++ != mayor);
	}

	public static void countFromAtoBSteppingEven(String[] args) {
		/*
		 * Programa que pida que se introduzcan dos n�meros enteros A y B por teclado y
		 * muestre los n�meros pares que hay entre A y B. A debe ser menor que B. Si no
		 * es as� se mostrar� un mensaje indic�ndolo y se vuelven a introducir.
		 */
		int numeroA, numeroB;
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Introduce n�mero:\n");
			numeroA = input.nextInt();
			System.out.println("Introduce n�mero:\n");
			numeroB = input.nextInt();
			if (numeroA == numeroB) {
				System.out.println("Los n�meros han de ser distintos!");
			}
		} while (numeroA == numeroB);
		int menor = Math.min(numeroA, numeroB);
		int mayor = Math.max(numeroA, numeroB);

		for (; mayor >= menor; menor++) {
			if (menor % 2 == 0) {
				System.out.println(menor);
			}
		}
	}

	public static void findMultiplesFromNtoM(String[] args) {
		/*
		 * Programa que lea dos n�meros enteros positivos N y M y muestre los m�ltiplos
		 * de N que hay desde 1 hasta M. Por ejemplo si N = 4 y M = 500 el programa
		 * mostrar� los m�ltiplos de 4 desde 1 hasta 500. El valor de N deber� ser menor
		 * que el valor de M. Si no se introducen valores v�lidos para N o M se mostrar�
		 * el mensaje correspondiente y se vuelven a pedir.
		 */
		int N, M;
		do {
			Scanner input = new Scanner(System.in);
			System.out.println("Introduce n�mero N:\n");
			N = input.nextInt();
			System.out.println("Introduce n�mero M:\n");
			M = input.nextInt();
			if (N > M) {
				System.out.println("El n�mero N ha de ser menor que M!");
			}
		} while (N > M);

		for (int i = 1; M >= i; i++) {
			if (i % N == 0) {
				System.out.println(i);
			}
		}

	}

	public static void ShowNegativePositiveAndEvenOdd(String[] args) {
		/*
		 * Leer n�meros y comprobar si son positivos o negativos y pares o impares En la
		 * primera versi�n se utilizar� un bucle while. La lectura de n�meros finalizar�
		 * cuando se introduzca un cero.
		 * 
		 */
		int numero = 1; // flag to something diferent to zero
		Scanner input = new Scanner(System.in);
		while (numero != 0) {
			System.out.println("Introduce n�mero:");
			numero = input.nextInt();
			if (numero != 0) {

				if (numero < 0) {
					System.out.printf("El n�mero %d es negativo\n", numero);
				} else {
					System.out.printf("El n�mero %d es positivo\n", numero);
				}
				if (numero % 2 == 0) {
					System.out.printf("El n�mero %d es par\n", numero);
				} else {
					System.out.printf("El n�mero %d es impar\n", numero);
				}
			}
		}
		System.out.printf("Adios!\n");
	}

	public static void fromMilesToKilometers(String[] args) {
		/*
		 * El programa pide que se introduzca una cantidad de millas y calcula y muestra
		 * su equivalente en Kil�metros. El proceso se repite hasta que se introduzca un
		 * 0 como valor para las millas.
		 */
		double millas = 1;
		Scanner input = new Scanner(System.in);
		do {
			System.out.println("Introduce millas;");
			millas = input.nextDouble();
			if (millas != 0) {
				System.out.printf("%.2f millas son %.2f kilometros\n", millas, millas * 1.6093);
			}
		} while (millas != 0);
		System.out.println("Adios!");
	}

	public static void main(String[] args) {

	}
}
