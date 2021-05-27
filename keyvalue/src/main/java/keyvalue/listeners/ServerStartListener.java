package keyvalue.listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.eskura21.libraries.beginnersjdbc.Dao;

import keyvalue.dao.config.Config;
import keyvalue.model.Key;
import keyvalue.model.Myset;
import keyvalue.model.User;

@WebListener
public class ServerStartListener implements ServletContextListener {

	public ServerStartListener() {

	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {
		// sce contiene el contexto de la aplicaci�n
		String pathSqlite = sce.getServletContext().getRealPath("/WEB-INF/db.sqlite3");
		// Guardamos a nivel global de la aplicaci�n en la clase Config el DAO de
		// Usuario

		// different path for development purposes only
		String ipartek = "C:\\Users\\curso\\git\\curso-java\\keyvalue\\src\\main\\webapp\\WEB-INF\\db.sqlite3";
		String home  = "/home/jgarai/git/curso-java/keyvalue/src/main/webapp/WEB-INF/db.sqlite3";
		pathSqlite = home  + "?date_string_format=yyyy-MM-dd'T'HH:mm:ss.SSS";

		System.out.println(pathSqlite);
		Config.daoUser = new Dao<>(User.class, pathSqlite);
		Config.daoSet = new Dao<>(Myset.class, pathSqlite);
		Config.daoKey = new Dao<>(Key.class, pathSqlite);
	}

}
