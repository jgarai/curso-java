package com.ipartek.formacion.poo.ejercicios;

public class Empleado {
//	Nif.
//	Nombre.
//	Sueldo base.
//	Horas extra realizadas en el mes.
//	Tipo de IRPF (%).
//	Casado o no.
//	Número de hijos.
//	Importe de la hora extra. Este será un atributo static o atributo de clase.

	private static Double precioHoraExtra;

	private String nif;
	private String nombre;
	private Double sueldo;
	private Integer horasExtra;
	private Double irpf;
	private Boolean estaCasado;
	private Integer numeroHijos;

	public Empleado(String nif, String nombre, Double sueldo, Integer horasExtra, Double irpf, Boolean estaCasado,
			Integer numeroHijos) {
		this.nif = nif;
		this.nombre = nombre;
		this.sueldo = sueldo;
		this.horasExtra = horasExtra;
		this.irpf = irpf;
		this.estaCasado = estaCasado;
		this.numeroHijos = numeroHijos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estaCasado == null) ? 0 : estaCasado.hashCode());
		result = prime * result + ((horasExtra == null) ? 0 : horasExtra.hashCode());
		result = prime * result + ((irpf == null) ? 0 : irpf.hashCode());
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numeroHijos == null) ? 0 : numeroHijos.hashCode());
		result = prime * result + ((sueldo == null) ? 0 : sueldo.hashCode());
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
		Empleado other = (Empleado) obj;
		if (estaCasado == null) {
			if (other.estaCasado != null)
				return false;
		} else if (!estaCasado.equals(other.estaCasado))
			return false;
		if (horasExtra == null) {
			if (other.horasExtra != null)
				return false;
		} else if (!horasExtra.equals(other.horasExtra))
			return false;
		if (irpf == null) {
			if (other.irpf != null)
				return false;
		} else if (!irpf.equals(other.irpf))
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numeroHijos == null) {
			if (other.numeroHijos != null)
				return false;
		} else if (!numeroHijos.equals(other.numeroHijos))
			return false;
		if (sueldo == null) {
			if (other.sueldo != null)
				return false;
		} else if (!sueldo.equals(other.sueldo))
			return false;
		return true;
	}

	public static Double getPrecioHoraExtra() {
		return precioHoraExtra;
	}

	public static void setPrecioHoraExtra(Double precioHoraExtra) {
		Empleado.precioHoraExtra = precioHoraExtra;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getSueldo() {
		return sueldo;
	}

	public void setSueldo(Double sueldo) {
		this.sueldo = sueldo;
	}

	public Integer getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(Integer horasExtra) {
		this.horasExtra = horasExtra;
	}

	public Double getIrpf() {
		return irpf;
	}

	public void setIrpf(Double irpf) {
		this.irpf = irpf;
	}

	public Boolean getEstaCasado() {
		return estaCasado;
	}

	public void setEstaCasado(Boolean estaCasado) {
		this.estaCasado = estaCasado;
	}

	public Integer getNumeroHijos() {
		return numeroHijos;
	}

	public void setNumeroHijos(Integer numeroHijos) {
		this.numeroHijos = numeroHijos;
	}

	@Override
	public String toString() {
		return "Empleado [nif=" + nif + ", nombre=" + nombre + ", sueldo=" + sueldo + ", horasExtra=" + horasExtra
				+ ", irpf=" + irpf + ", estaCasado=" + estaCasado + ", numeroHijos=" + numeroHijos + "]";
	}

}
