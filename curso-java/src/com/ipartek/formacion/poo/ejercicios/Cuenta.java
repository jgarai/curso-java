package com.ipartek.formacion.poo.ejercicios;

public class Cuenta {
	private String nombre;
	private String cc;
	private double interes;
	private double saldo;

	public Cuenta() {
	}

	public Cuenta(String nombre, String cc, double interes, double saldo) {
		setNombre(nombre);
		setCc(cc);
		setInteres(interes);
		setSaldo(saldo);
	}

	public Cuenta(String nombre, String cc, double i, int s) {
		this(nombre, cc, i, (double) s);
	}

	public Cuenta(Cuenta c) {
		this(c.getNombre(), c.getCc(), c.getInteres(), c.getSaldo());

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cc == null) ? 0 : cc.hashCode());
		long temp;
		temp = Double.doubleToLongBits(interes);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		temp = Double.doubleToLongBits(saldo);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cuenta other = (Cuenta) obj;
		if (cc == null) {
			if (other.cc != null)
				return false;
		} else if (!cc.equals(other.cc))
			return false;
		if (Double.doubleToLongBits(interes) != Double.doubleToLongBits(other.interes))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(saldo) != Double.doubleToLongBits(other.saldo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cuenta [nombre=" + nombre + ", cc=" + cc + ", interes=" + interes + ", saldo=" + saldo + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public boolean ingreso(double i) {
		/*
		 * Un ingreso consiste en aumentar el saldo en la cantidad que se indique. Esa
		 * cantidad no puede ser negativa
		 * 
		 */
		if (i < 0) {
			return false;
		}
		setSaldo(getSaldo() + i);
		return true;
	}

	public boolean reintegro(double r) {
		/*
		 * Un reintegro consiste en disminuir el saldo en una cantidad pero antes se
		 * debe comprobar que hay saldo suficiente. La cantidad no puede ser negativa
		 */
		if (r < 0) {
			return false;
		}
		if (getSaldo() - r < 0) {
			return false;
		}
		setSaldo(getSaldo() - r);
		return true;

	}

	public boolean transferencia(Cuenta c, double i) {
		if (i < 0) {
			return false;
		}

		if (getSaldo() - i < 0) {
			return false;
		}
		reintegro(i);
		c.ingreso(i);
		return true;

	}

}
