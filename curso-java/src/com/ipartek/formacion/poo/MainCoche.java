package com.ipartek.formacion.poo;

import static com.ipartek.formacion.bibliotecas.Consola.escribir;
import static com.ipartek.formacion.bibliotecas.Consola.leerInt;
import static com.ipartek.formacion.bibliotecas.Consola.leerString;

import java.util.ArrayList;
import java.util.Collections;

public class MainCoche {
	/*
	 * En esta entrada vamos a escribir un programa Java que crea un ArrayList de
	 * Objetos de tipo Coche. El programa pide por teclado los datos de los coches y
	 * los guarda en el array. A continuación utilizará el ArrayList para mostrar
	 * por pantalla lo siguiente: Todos los coches introducidos. Todos los coches de
	 * una marca determinada. Todos los coches con menos de un número determinado de
	 * Kilómetros. El coche con mayor número de Kilómetros. Todos los coches
	 * ordenados por número de kilómetros de menor a mayor.
	 */

	static ArrayList<Coche> coches = new ArrayList<Coche>();

	public static void main(String[] args) {
		// leerCoches(coches);
		coches.add(new Coche("seat", "leon", "2345asj", 30000));
		coches.add(new Coche("volfwagen", "golf", "12345gdf", 120000));
		coches.add(new Coche("citroen", "bx", "bi2345j", 23000));

		escribir("Todos los coches");
		for (Coche c : coches) {
			escribir(c);

		}
		// Todos los coches de una marca determinada.

		escribir("Todos los coches de una marca determinada");
		String marca = leerString("Introduzca marca a buscar");
		int found = 0;
		for (Coche c : coches) {
			if (c.getMarca().equalsIgnoreCase(marca.toString())) {
				escribir(c);
				found++;
			}
		}
		if (found == 0) {
			escribir("Ningun coche fue hallado con esa marca!");
		}
		// Todos los coches con menos de un número determinado de Kilómetros.
		escribir("Todos los coches con menos kilometros");
		int kilometros = leerInt("Introduzca kilometos máximos");
		found = 0;
		for (Coche c : coches) {
			if (c.getKm() <= kilometros) {
				escribir(c);
				found++;
			}
		}
		if (found == 0) {
			escribir("Ningun coche fue hallado con menos kilometros!");
		}
		// El coche con mayor número de Kilómetros.
		escribir("El coche con mayor número de Kilómetros es:");
		Coche cocheConMasKilometros = new Coche();

		found = 0;
		for (Coche c : coches) {
			if (cocheConMasKilometros != null) {
				if (c.getKm() > cocheConMasKilometros.getKm()) {
					cocheConMasKilometros = c;
				}

			}

		}
		if (cocheConMasKilometros != null) {
			escribir(cocheConMasKilometros);
		}
		// Método que muestra los coches ordenados por número de Km de menor a mayor
		// lista.sort((o1, o2) -> o1.compareTo(o2));
		escribir("Los coches ordenados por kilometros ASC!");
		Collections.sort(coches);
		for (Coche c : coches) {
			escribir(c);

		}

	}

	public static void leerCoches(ArrayList<Coche> coches) {
		int numeroCoches = leerInt("introduce numero de coches");
		for (int i = 0; i < numeroCoches; i++) {
			Coche coche = new Coche();
			escribir("Introduces datos para el coche" + (i + 1));
			coche.setMarca(leerString("introduce Marca"));
			coche.setModelo(leerString("introduce Modelo"));
			coche.setMatricula(leerString("introduce matrícula"));
			coche.setKm(leerInt("introduce Kilometros"));
			coches.add(coche);

		}
	}

}
