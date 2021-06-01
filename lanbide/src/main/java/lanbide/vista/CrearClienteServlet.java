package lanbide.vista;

import java.io.IOException;
import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanbide.modelo.Cliente;

@WebServlet("/crearcliente")
public class CrearClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nombre = request.getParameter("nombre");
			String apellido = request.getParameter("apellido");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("email");
			BigDecimal saldo = new BigDecimal(request.getParameter("saldo"));
			if (nombre == null || apellido == null || telefono == null || email == null || saldo == null) {

			}

			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");

			EntityManager entityManager = entityManagerFactory.createEntityManager();

			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			Cliente cliente = new Cliente(null, nombre, apellido, telefono, email, saldo);
			entityManager.persist(cliente);

			entityManager.getTransaction().commit();
			entityManager.close();
			request.setAttribute("mensaje",
					"La ficha del cliente ha sido creada con éxito.");
			request.getRequestDispatcher("/").forward(request, response);
		} catch (Exception e) {

			e.printStackTrace();
			request.setAttribute("error", "Ha habido un error tratando de crear la ficha del cliente.");
			request.getRequestDispatcher("/").forward(request, response);
		}

	}

}
