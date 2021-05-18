package keyvalue.dao;

import java.util.ArrayList;

import keyvalue.model.User;

public class DaoUserPrueba {

	public static void main(String[] args) {
		// User u = new User(null, "mail@server.net", "123");

		System.out.println("Show all users");
		ArrayList<User> users = DaoUser.getUsers();
		if (users != null) {
			for (User user : users) {
				System.out.println(user);
			}
		}

		System.out.println("find by id");
		User u1 = DaoUser.getUserById(1);
		System.out.println(u1);
		System.out.println("find by email");
		User u2 = DaoUser.getUserByEmail("admin@example.com");
		System.out.println(u2);
		User u3 = new User(null, "mail@server.net", "123");
		DaoUser.insert(u3);
		System.out.println("Show all users");
		users = DaoUser.getUsers();
		if (users != null) {
			for (User user : users) {
				System.out.println(user);
			}
		}

	}

}
