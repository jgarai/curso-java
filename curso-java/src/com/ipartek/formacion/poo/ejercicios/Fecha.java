package com.ipartek.formacion.poo.ejercicios;

public class Fecha {
	/*
	 * Crear una Clase Fecha en Java. La clase tendr� tres atributos privados dia,
	 * mes y a�o de tipo int. La clase contendr� los siguientes m�todos: Constructor
	 * por defecto. Constructor con tres par�metros para crear objetos con valores
	 * iniciales. M�todos set y get para asignar y obtener los valores de los
	 * atributos de la clase. M�todo fechaCorrecta() que comprueba si la fecha es
	 * correcta. Devuelve un valor de tipo boolean indicando si la fecha es correcta
	 * o no. Este m�todo a su vez utilizar� un m�todo privado de la clase llamado
	 * esBisiesto que calcula si el a�o es o no bisiesto. El m�todo esBisiesto
	 * devuelve true si el a�o es bisiesto y false si no lo es. M�todo
	 * diaSiguiente() que cambia la fecha actual por la del d�a siguiente. El objeto
	 * de la clase Fecha al que se le aplique este m�todo deber� quedar siempre en
	 * un estado consistente, es decir, la nueva fecha deber� ser correcta.
	 * Modificar el m�todo toString() heredado de Object para mostrar las fechas de
	 * la forma dd-mm-aaaa. El d�a y el mes se deben mostrar con dos cifras. Si el
	 * dia o el mes tienen solo una cifra se escribir� un cero delante. Por ejemplo
	 * si la fecha es dia=1, mes=6, a�o= 2015 la fecha que se mostrar� ser�:
	 * 01-06-2015 Escribe un programa para probar la clase Fecha. El m�todo
	 * diaSiguiete() pru�balo dentro de un bucle que imprima la fecha durante cada
	 * iteraci�n del bucle.
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
