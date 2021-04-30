package com.ipartek.formacion.poo.ejercicios;

public class Fecha {
	/*
	 * Crear una Clase Fecha en Java. La clase tendrá tres atributos privados dia,
	 * mes y año de tipo int. La clase contendrá los siguientes métodos: Constructor
	 * por defecto. Constructor con tres parámetros para crear objetos con valores
	 * iniciales. Métodos set y get para asignar y obtener los valores de los
	 * atributos de la clase. Método fechaCorrecta() que comprueba si la fecha es
	 * correcta. Devuelve un valor de tipo boolean indicando si la fecha es correcta
	 * o no. Este método a su vez utilizará un método privado de la clase llamado
	 * esBisiesto que calcula si el año es o no bisiesto. El método esBisiesto
	 * devuelve true si el año es bisiesto y false si no lo es. Método
	 * diaSiguiente() que cambia la fecha actual por la del día siguiente. El objeto
	 * de la clase Fecha al que se le aplique este método deberá quedar siempre en
	 * un estado consistente, es decir, la nueva fecha deberá ser correcta.
	 * Modificar el método toString() heredado de Object para mostrar las fechas de
	 * la forma dd-mm-aaaa. El día y el mes se deben mostrar con dos cifras. Si el
	 * dia o el mes tienen solo una cifra se escribirá un cero delante. Por ejemplo
	 * si la fecha es dia=1, mes=6, año= 2015 la fecha que se mostrará será:
	 * 01-06-2015 Escribe un programa para probar la clase Fecha. El método
	 * diaSiguiete() pruébalo dentro de un bucle que imprima la fecha durante cada
	 * iteración del bucle.
	 */
	private int dia;
	private int mes;
	private int ano;

	public Fecha(int dia, int mes, int ano) {
		setDia(dia);
		setMes(mes);
		setAno(ano);
	}

	@Override
	public String toString() {
		return "Fecha [dia=" + dia + ", mes=" + mes + ", ano=" + ano + "]";
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public Fecha() {

	}

	public boolean fechaCorrecta() {
		return false;

	}

	private boolean esBisiesto() {
		return false;

	}

}
