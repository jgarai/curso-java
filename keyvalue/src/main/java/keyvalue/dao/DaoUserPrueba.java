package keyvalue.dao;

import java.util.ArrayList;

import keyvalue.entidades.User;

public class DaoUserPrueba {

	public static void main(String[] args) {
		// User u = new User(null, "mail@server.net", "123");

		ArrayList<User> users = DaoUser.getUsers();
		if (users != null) {
			for (User user : users) {
				System.out.println(user);
			}
		}

		User u1 = DaoUser.getUserById(1);
		System.out.println(u1);
		User u2 = DaoUser.getUserByEmail("admin@example.com");
		System.out.println(u1);
		User u3 = new User(null, "mail@server.net", "123");
		DaoUser.insert(u3);
		users = DaoUser.getUsers();
		if (users != null) {
			for (User user : users) {
				System.out.println(user);
			}
		}

	}

}
