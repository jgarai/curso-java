package keyvalue.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;

import keyvalue.model.User;

public class DaoUser extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String URL = "jdbc:sqlite:C:\\Users\\curso\\git\\curso-java\\keyvalue\\src\\main\\webapp\\WEB-INF\\db.sqlite3?date_string_format=yyyy-MM-dd";
	private static final String USUARIO = "";
	private static final String PASSWORD = "";

	private static final String SQL_SELECT = "SELECT id, email, password, name FROM users";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id = ?";
	private static final String SQL_SELECT_EMAIL = SQL_SELECT + " WHERE email = ?";
	private static final String SQL_INSERT = "INSERT INTO users (email, password, name) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE users SET email = ?, password = ?, name = ? WHERE id = ?";
	private static final String SQL_DELETE = "DELETE FROM users WHERE id = ?";

	static {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<User> getUsers() {

		try (Connection con = connectDB();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery();) {
			ArrayList<User> users = new ArrayList<>();
			while (rs.next()) {
				users.add(new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"),
						rs.getString("name")));
			}
			return users;

		} catch (Exception e) {
			throw new AccesoDatosException("No se han podido obtener todos los userss", e);

		}

	}

	public static User getUserById(Integer id) {
		try (Connection con = connectDB(); PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);) {

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			User user = null;

			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("name"));
			}

			return user;
		} catch (Exception e) {
			throw new AccesoDatosException("La operación de obtener user por id ha fallado", e);
		}
	}

	public static User getUserByEmail(String email) {
		try (Connection con = connectDB(); PreparedStatement ps = con.prepareStatement(SQL_SELECT_EMAIL);) {

			ps.setString(1, email);

			ResultSet rs = ps.executeQuery();

			User user = null;

			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("email"), rs.getString("password"), rs.getString("name"));
			}

			return user;
		} catch (Exception e) {
			throw new AccesoDatosException("La operación de obtener user por email ha fallado", e);
		}
	}

	public static User insert(User user) {
		try (Connection con = connectDB();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);) {
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());

			ps.setString(3, user.getName());

			ps.executeUpdate();

			ResultSet rs = ps.getGeneratedKeys();

			rs.next();

			user.setId(rs.getInt(1));

			return user;
		} catch (Exception e) {
			throw new AccesoDatosException("La operación de insertar user ha fallado", e);
		}
	}

	public static User update(User user) {
		try (Connection con = connectDB(); PreparedStatement ps = con.prepareStatement(SQL_UPDATE);) {
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getId());

			ps.executeUpdate();

			return user;
		} catch (Exception e) {
			throw new AccesoDatosException("La operación de modificar user ha fallado", e);
		}
	}

	public static void delete(Integer id) {
		try (Connection con = connectDB(); PreparedStatement ps = con.prepareStatement(SQL_DELETE);) {
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (Exception e) {
			throw new AccesoDatosException("La operación de borrar user ha fallado", e);
		}
	}

	private static Connection connectDB() {

		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USUARIO, PASSWORD);
		} catch (Exception e) {
			throw new AccesoDatosException("Error en la conexión a users", e);
		}

		return con;
	}

}
