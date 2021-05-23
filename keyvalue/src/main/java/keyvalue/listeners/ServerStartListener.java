package keyvalue.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.eskura21.libraries.beginnersjdbc.Dao;

import keyvalue.dao.config.Config;
import keyvalue.model.Myset;
import keyvalue.model.User;

@WebListener
public class ServerStartListener implements ServletContextListener {

	public ServerStartListener() {
		// TODO Auto-generated constructor stub
	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
	}

	public void contextInitialized(ServletContextEvent sce) {
		// sce contiene el contexto de la aplicaci�n
		String pathSqlite = sce.getServletContext().getRealPath("/WEB-INF/db.sqlite3");
		// Guardamos a nivel global de la aplicaci�n en la clase Config el DAO de
		// Usuario
		System.out.println(pathSqlite);
		Config.daoUser = new Dao<>(User.class, pathSqlite);
		Config.daoSet = new Dao<>(Myset.class, pathSqlite);
	}

}