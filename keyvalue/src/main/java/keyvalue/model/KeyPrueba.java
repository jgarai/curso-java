package keyvalue.model;

import java.time.LocalDateTime;

import keyvalue.dao.config.Config;

public class KeyPrueba {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		Key k = new Key(null, 23, "key", "value", now);
		System.out.println(k);

		Config.daoKey.insert(k);

	}

}
