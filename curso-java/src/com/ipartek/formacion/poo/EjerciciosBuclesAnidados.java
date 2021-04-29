package com.ipartek.formacion.poo;

import static com.ipartek.formacion.bibliotecas.Consola.escribir;
import static com.ipartek.formacion.bibliotecas.Consola.leerInt;
import static com.ipartek.formacion.poo.EjerciciosGenerales.findPerfectNumbersUntil1000;

public class EjerciciosBuclesAnidados {

	public static void findPerfectNumbersUntil1000_v2() {
		/*
		 * it is done in EjerciciosGenerales
		 */
		findPerfectNumbersUntil1000();
	}

	public static void findFactorial() {
		/*
		 * Leer por teclado un número entero N no negativo y mostrar el factorial de
		 * todos los números desde 0 hasta N.
		 * 
		 */
		long n = leerInt("introduca limite números a calcular el factorial");

		long f;

		while (n > 0) {
			f = n;
			for (long i = f - 1l; i > 0; i--) {
				f = f * i;
			}
			escribir(f);
			n--;
		}

	}

	public static void loopFactorialsAndSum(String[] args) {
		/*
		 * Leer por teclado un número entero N no negativo y mostrar la suma de los
		 * factoriales de todos los números desde 0 hasta N. Este ejercicio es una
		 * variante del anterior. Para resolverlo basta con añadir otra variable suma
		 * que actúe como acumulador donde sumaremos el factorial obtenido de cada
		 * número.
		 */
		long n = leerInt("introduca limite números a calcular el factorial");

		long f, suma = 0;
		/* creo que hay un error / no me saca el factorial de 0 */
		do {
			f = n;
			for (long i = f - 1l; i != 0; i--) {
				f = f * i;
			}
			escribir(f);
			suma += f;
			n--;
		} while (n != 0);
		escribir("total: " + suma);

	}

	public static void loopAlphabet(String[] args) {
		/*
		 * Como podemos ver, en este caso se trata de mostrar las letras del abecedario
		 * (sin la Ñ) en mayúsculas y en orden inverso. A continuación en cada fila
		 * mostrar una letra menos hasta llegar a mostrar solamente la A.
		 */

		for (char x = 'Z'; x >= 'A'; x--) {
			for (char y = x; y >= 'A'; y--) {
				System.out.print(y);
			}
			escribir("");
		}

	}

	public static void replaceTrees(String[] args) {
		/*
		 * Mostrar un contador de 5 digitos
		 */
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= 9; k++) {
					for (int l = 0; l <= 9; l++) {
						for (int m = 0; m <= 9; m++) {
							System.out.print(i != 3 ? i : "E");
							System.out.print(j != 3 ? j : "E");
							System.out.print(k != 3 ? k : "E");
							System.out.print(l != 3 ? l : "E");
							System.out.println(m != 3 ? m : "E");
						}
					}
				}
			}
		}

	}
}
