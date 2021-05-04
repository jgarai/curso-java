package com.ipartek.formacion.supermercado.presentacionconsola;

import com.ipartek.formacion.supermercado.accesodatos.DaoProducto;
import com.ipartek.formacion.supermercado.entidades.Producto;

public class PresentacionConsolaProductos {

	public static void main(String[] args) {
		mostrarTodos();

		Producto p2 = new Producto(null, "tomates", 100, 5);
		DaoProducto.insertar(p2);
		DaoProducto.modificar(new Producto(2, "tomato", 50, 6));

		DaoProducto.borrar(4);
		Producto p = DaoProducto.obtenerPorId(4);
		System.out.println(p);

	}

	private static void mostrarTodos() {
		System.out.println("LISTADO");

		for (Producto producto : DaoProducto.obtenerTodos()) {
			System.out.println(producto);
		}
	}

}
