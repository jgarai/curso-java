package com.ipartek.formacion.supermercado.presentacionconsola;

import com.ipartek.formacion.supermercado.accesodatos.DaoUsuario;
import com.ipartek.formacion.supermercado.entidades.Usuario;

public class PresentacionConsola {

	public static void main(String[] args) {
		Usuario u = DaoUsuario.obtenerPorId(1);
		System.out.println(u);

		mostrarTodos();
		
		DaoUsuario.insertar(new Usuario(null, "email1@email.net", "contraseña", "Prueba", "Pruebez"));
		
		mostrarTodos();
		
		DaoUsuario.modificar(new Usuario(4, "modificado@email.net", "cambiadacontra", "Modificado", "Modificadez"));
		
		mostrarTodos();
		
		DaoUsuario.borrar(4);
		
		mostrarTodos();
	}

	private static void mostrarTodos() {
		System.out.println("LISTADO");
		
		for(Usuario usuario: DaoUsuario.obtenerTodos()) {
			System.out.println(usuario);
		}
	}

}
