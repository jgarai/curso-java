package com.ipartek.formacion.poo;

import java.util.Scanner;

public class EjerciciosEstructuraSecuencial {

	public static void inputTwoNumbers(String[] args) {
		/*
		 * Programa Java que lea dos nï¿½meros enteros por teclado y los muestre por
		 * pantalla.
		 */

		int numeroA, numeroB;
		Scanner input = new Scanner(System.in);
		System.out.println("Escribe primero nï¿½mero");
		numeroA = input.nextInt();

		System.out.println("Escribe segundo nï¿½mero");
		numeroB = input.nextInt();

		System.out.printf("los numeros son %d y %d", numeroA, numeroB);
	}

	public static void inputName(String[] args) {
		/*
		 * Programa Java que lea un nombre y muestre por pantalla:
		 */
		String nombre;
		Scanner input = new Scanner(System.in);
		System.out.println("Cï¿½al es tu nombre?");
		nombre = input.nextLine();
		System.out.printf("Hola %s", nombre);

	}

	public static void inputNumberAndDoMaths(String[] args) {
		/*
		 * Escribe un programa Java que lee un nï¿½mero entero por teclado y obtiene y
		 * muestra por pantalla el doble y el triple de ese nï¿½mero.
		 */
		int numero;
		Scanner input = new Scanner(System.in);
		System.out.println("introduce un nï¿½mero");
		numero = input.nextInt();
		System.out.printf("El nï¿½mero introducido es %d\n", numero);
		System.out.printf("el doble del nï¿½mero es %d\n", numero * 2);
		System.out.printf("El triple del nï¿½mero es %d\n", numero * 3);

	}

	public static void calculateFahrenheit(String[] args) {
		/*
		 * Programa que lea una cantidad de grados centï¿½grados y la pase a grados
		 * Fahrenheit. La fï¿½rmula correspondiente para pasar de grados centï¿½grados a
		 * fahrenheit es: F = 32 + ( 9 * C / 5)
		 */
		double grados;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce grados centï¿½grados");
		grados = input.nextDouble();
		System.out.printf("%s grados centï¿½grados son %s grados fahrenheit", grados, 32 + (9 * grados / 5));

	}

	public static void CircleLengthAndArea(String[] args) {
		/*
		 * Programa que lee por teclado el valor del radio de una circunferencia y
		 * calcula y muestra por pantalla la longitud y el ï¿½rea de la circunferencia.
		 * Longitud de la circunferencia = 2*PI*Radio, Area de la circunferencia =
		 * PI*Radio^2
		 */
		double radio;

		Scanner input = new Scanner(System.in);
		System.out.println("Cï¿½al es el radio?");
		radio = input.nextDouble();

		double resultLength = Math.PI * 2 * radio;
		System.out.printf("La longitud de la circunferencia es: %s\n", resultLength);
		double resultArea = Math.pow(radio, 2) * Math.PI;
		System.out.printf("El area de la circunferencia es: %s\n", resultArea);

	}

	public static void fromKMHtoMS(String[] args) {
		/*
		 * Programa que pase una velocidad en Km/h a m/s. La velocidad se lee por
		 * teclado.
		 */
		double velocity;
		Scanner input = new Scanner(System.in);
		System.out.println("Cï¿½al es la velocidad en km/h?");
		velocity = input.nextDouble();
		System.out.printf("Resultado: %s km/h %s m/s", velocity, velocity * 1000 / 3600);
	}

	public static void getHipotenusa(String[] args) {
		/*
		 * Programa lea la longitud de los catetos de un triï¿½ngulo rectï¿½ngulo y
		 * calcule la longitud de la hipotenusa segï¿½n el teorema de Pitï¿½goras.
		 */
		double catetoA, catetoB;
		Scanner input = new Scanner(System.in);
		System.out.println("introduzca un cateto");
		catetoA = input.nextDouble();
		System.out.println("introduzca el otro cateto");
		catetoB = input.nextDouble();
		double result = Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2));

		System.out.printf("La hipoyenusa es: %s", result);

	}

	public static void sphereVolume(String[] args) {
		/*
		 * Programa que tome como dato de entrada un nï¿½mero que corresponde a la
		 * longitud del radio una esfera y nos calcula y escribe el volumen de la esfera
		 * que se corresponden con dicho radio. La fï¿½rmula para calcular el volumen de
		 * la esfera esv = (4/3)*PI*r^3
		 */

		double radio;
		Scanner input = new Scanner(System.in);
		System.out.println("Cï¿½al es el radio?");
		radio = input.nextDouble();
		double resultVolume = (4.0 / 3) * Math.PI * Math.pow(radio, 3);
		System.out.printf("La volumen de la esfera es: %s\n", resultVolume);

	}

	public static void triangleArea(String[] args) {
		/*
		 * Programa Java que calcule el ï¿½rea de un triï¿½ngulo en funciï¿½n de las
		 * longitudes de sus lados (a, b, c), segï¿½n la siguiente fï¿½rmula:
		 * 
		 * Area = RaizCuadrada(p*(p-a)*(p-b)*(p-c)) donde p = (a+b+c)/2 Para calcular la
		 * raï¿½z cuadrada se utiliza el mï¿½todo Math.sqrt()
		 */
		double ladoA;
		Scanner input = new Scanner(System.in);
		double ladoB;
		double ladoC;
		System.out.println("Introduzca un lado del triï¿½ngulo:");
		ladoA = input.nextDouble();
		System.out.println("Introduzca un segundo lado del triï¿½ngulo:");
		ladoB = input.nextDouble();
		System.out.println("Introduzca el ï¿½ltimo lado del triï¿½ngulo:");
		ladoC = input.nextDouble();
		double p, result;
		p = (ladoA + ladoB + ladoC) / 2;
		result = Math.sqrt(((p - ladoA) * (p - ladoB) * (p - ladoC) * p));
		System.out.printf("El ï¿½rea del triangulo es: %s", result);

	}

	public static void extractFigures(String[] args) {
		/*
		 * Programa Java que lea un nï¿½mero entero de 3 cifras y muestre por separado
		 * las cifras del nï¿½mero.
		 */
		int numero;
		Scanner input = new Scanner(System.in);
		System.out.println("introduzca un nÃºmero de 3 cifras:");
		numero = input.nextInt();
		System.out.printf("%s centenas, ", (numero / 100));
		System.out.printf("%s decenas, ", (numero / 10) % 10);
		System.out.printf("%s unidades.", (numero % 10));

	}

	public static void showNumberFiveDigitsStairs(String[] args) {
		/*
		 * Programa que lea un nï¿½mero entero N de 5 cifras y muestre sus cifras igual
		 * que en el ejemplo. Por ejemplo para un nï¿½mero N = 12345 La salida debe ser:
		 * 1 1 2 123 1234 12345
		 */
		int numero;
		Scanner input = new Scanner(System.in);
		System.out.println("introduzca número de 5 cifras:");
		numero = input.nextInt();
		int i = 10000;
		while (i != 0) {
			System.out.println(numero / i);
			i /= 10;

		}

	}

	public static void showNumberFiveDigitsStairsButInversed(String[] args) {
		/*
		 * Programa Java que lea un número entero N de 5 cifras y muestre sus cifras al
		 * la inversa que en el ejemplo. Por ejemplo para un número N = 12345 La salida
		 * debe ser:
		 */

		int numero;
		Scanner input = new Scanner(System.in);

		System.out.println("introduzca número de 5 cifras:");
		numero = input.nextInt();
		int divisor = 1;
		do {
			System.out.println(numero % (divisor * 10));
			divisor *= 10;
		} while (divisor < numero);
	}

	public static void lukyNumberFromBornDay(String[] args) {
		/*
		 * Programa que pida por teclado la fecha de nacimiento de una persona (dia,
		 * mes, año) y calcule su número de la suerte. El número de la suerte se calcula
		 * sumando el día, mes y año de la fecha de nacimiento y a continuación sumando
		 * las cifras obtenidas en la suma. Por ejemplo: Si la fecha de nacimiento es
		 * 12/07/1980 Calculamos el número de la suerte así: 12+7+1980 = 1999 1+9+9+9 =
		 * 28 Número de la suerte: 28
		 */
		int day, month, year;
		Scanner input = new Scanner(System.in);
		// input
		System.out.println("Introduzca el día nacimiento:");
		day = input.nextInt();
		System.out.println("Introduzca el mes de nacimiento:");
		month = input.nextInt();
		System.out.println("introduzca el año de nacimiento:");
		year = input.nextInt();
		// cálculo
		int parcial = day + month + year;
		int result = 0;
		while (parcial > 10) {
			result += (parcial % 10);
			parcial /= 10;
		}
		result += parcial;
		System.out.printf("El número de la suerte es: %s\n", result);

	}

	public static void invoiceRow(String[] args) {
		/*
		 * Programa que calcule el precio de venta de un producto conociendo el precio
		 * por unidad (sin IVA) del producto, el número de productos vendidos y el
		 * porcentaje de IVA aplicado. Los datos anteriores se leerán por teclado.
		 */
		int precioProducto;
		double iva;
		int numeroProductosVendidos;
		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca el precio del producto:");
		precioProducto = input.nextInt();
		System.out.println("Introduza el IVA a aplicar:");
		iva = input.nextDouble();
		iva = (iva / 100) + 1;
		System.out.println("Introduca el número de productos vendidos:");
		numeroProductosVendidos = input.nextInt();
		System.out.println("precio de venta: " + ((precioProducto * numeroProductosVendidos) * iva));
	}

	public static void cutLastFiguresFonNumber(String[] args) {
		/*
		 * Programa que lea dos variables enteras N y m y le quite a N sus m últimas
		 * cifras. Por ejemplo, si N = 123456 y m = 2 el nuevo valor de N será 1234.
		 */
		int numero, corte;
		Scanner input = new Scanner(System.in);
		System.out.println("introzduca número");
		numero = input.nextInt();
		System.out.println("introzduca corte");
		corte = input.nextInt();
		while (corte != 0) {
			numero /= 10;
			corte--;
		}
		System.out.println("resultado: " + numero);
	}

	public static void celsiusToReamurToKelvin() {
		/*
		 * Programa que lee una temperatura en grados centígrados y nos calcula y
		 * muestra por pantalla su valor equivalente en grados Reamur y Kelvin. Las
		 * fórmulas para realizar la conversión de grados centígrados a grados Kelvin y
		 * Reamur son las siguientes: r =80* C /100 k= C + 273
		 */
		double centigrados, reamur, kelvin;
		Scanner input = new Scanner(System.in);
		System.out.println("introduce los grados centígrados:");
		centigrados = input.nextDouble();

		reamur = 80 * (centigrados / 100);
		kelvin = centigrados + 273;

		System.out.printf("%.2f grados centígrados equivalen a\n%.2f grados reamur y a \n%.2f grados kelvin",
				centigrados, reamur, kelvin);
	}
	public static void main(String[] args) {
		celsiusToReamurToKelvin();
	}
}
