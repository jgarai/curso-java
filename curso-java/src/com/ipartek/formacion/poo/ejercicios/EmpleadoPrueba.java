package com.ipartek.formacion.poo.ejercicios;

public class EmpleadoPrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Empleado e = new Empleado();
		e.setNif("30666123X");
		e.setNombre("Pepe Perez");
		e.setSueldo(1150.0);
		e.setHorasExtra(4);
		e.setIrpf(15.0);
		e.setEstaCasado(true);
		e.setNumeroHijos(2);


		System.out.println(e);
	}

}
