package com.ipartek.formacion.poo;

public class Coche implements Comparable<Coche> {
	private String matricula;
	private String marca;
	private String modelo;
	private int km;

	Coche(String marca, String modelo, String matricula, int kilometros) {
		this.setMarca(marca);
		this.setMatricula(matricula);
		this.setModelo(modelo);
		this.setKm(kilometros);

	}

	Coche() {

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca.toLowerCase();
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo.toLowerCase();
	}

	public int getKm() {
		return km;
	}

	public void setKm(int km) {
		this.km = km;
	}

	@Override
	public String toString() {
		String template = "";
		template += template.format("Marca: %s\n", getMarca());
		template += template.format("Modelo: %s\n", getModelo());
		template += template.format("Matrícula: %s\n", getMatricula());
		template += template.format("Kilométros: %s\n", getKm());
		return template;
	}

	@Override
	// https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
	public int compareTo(Coche compareCoche) {
		int compareKm = ((Coche) compareCoche).getKm();
		/* For Ascending order */
		return this.km - compareKm;

	}

}
