package keyvalue.dao.config;

import com.eskura21.libraries.beginnersjdbc.Dao;

import keyvalue.model.Myset;
import keyvalue.model.User;

public class Config {
	// DAO disponible para todas las servlets inicializado mediante el
	// InicioServidorListener
	public static Dao<User> daoUser;
	public static Dao<Myset> daoSet;
}
