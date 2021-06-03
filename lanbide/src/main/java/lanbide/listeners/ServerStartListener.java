package lanbide.listeners;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import lanbide.modelo.Cliente;

@WebListener
public class ServerStartListener implements ServletContextListener {

	public ServerStartListener() {
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

	public void contextInitialized(ServletContextEvent sce) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("lanbide");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		// Creamos un par de cliente de ejemplo
		Cliente c1 = new Cliente(null, "tomás", "rodriguez", "600 567 809", "tomasrodriguez@gmail.com",
				new BigDecimal("1000.00"));
		Cliente c2 = new Cliente(null, "john", "doe", "670 310 345", "johndoe@gmail.com", new BigDecimal("349.25"));

		entityManager.persist(c1);
		entityManager.persist(c2);

		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}
