package lanbide.vista;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lanbide.modelo.Cliente;


@WebServlet("/borrarcliente")
public class BorrarClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	try {
			String clienteIdReq = request.getParameter("clienteid");
			Long clienteId = Long.parseLong(clienteIdReq);
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");

			EntityManager entityManager = entityManagerFactory.createEntityManager();

			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			Cliente cliente = entityManager.find(Cliente.class, clienteId);

			if(cliente != null){
				
				entityManager.remove(cliente);
			}
			entityManager.getTransaction().commit();
			entityManager.close();
			System.out.println(clienteId);
			
			request.setAttribute("mensaje", "La ficha del cliente ha sido borrada con éxito.");
			request.getRequestDispatcher("/").forward(request, response);
		} catch (NumberFormatException e) {
			request.setAttribute("error", "Ha habido un error tratando de borrar la ficha del cliente.");
			request.getRequestDispatcher("/").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
