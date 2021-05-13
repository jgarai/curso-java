package com.ipartek.guestnumber;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guest")
public class guest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valorCookie = null;
		request.setAttribute("message", "Introduce n�mero");
		request.setAttribute("trys", 0);

		// re-start game updating the cookie to new value
		if (request.getParameter("reset") != null && request.getParameter("reset").equals("true")) {
			Cookie c = new Cookie("randomnumber", getRandomNumber());
			response.addCookie(c);
			request.getRequestDispatcher("/guestV.jsp").forward(request, response);
		}

		// find the cookie with our random number
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("randomnumber".equals(c.getName())) {
					valorCookie = c.getValue();
					break;
				}
			}
		}
		// if no cookie, one is sent to the browser with a randon number within
		if (valorCookie == null) {
			Cookie c = new Cookie("randomnumber", getRandomNumber());
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c);
		}
		// if we have a cookie
		if (valorCookie != null) {
			Integer rn = Integer.valueOf(valorCookie);
			Integer bet = null;
			if (request.getParameter("bet") != null) {
				bet = Integer.valueOf(request.getParameter("bet"));

				if (bet == rn) {
					request.setAttribute("message", "Acertaste!!! <a href=\"guest?reset=true\">Juega de nuevo</a>");
					request.setAttribute("disabled", "disabled");
				}
				if (bet > rn) {
					request.setAttribute("message", "El n�mero es menor que " + bet);
				}
				if (bet < rn) {
					request.setAttribute("message", "El n�mero es mayor que " + bet);
				}
			}
		}
		// How many trys?
		try {
			Integer trys = Integer.valueOf(request.getParameter("count"));
			request.setAttribute("trys", trys + 1);
		} catch (NumberFormatException ex) {
			request.setAttribute("trys", 1);
			request.getRequestDispatcher("/guestV.jsp").forward(request, response);
		}

		// finally data is sent to myself
		request.getRequestDispatcher("/guestV.jsp").forward(request, response);

	}

	private String getRandomNumber() {
		Integer rn = ThreadLocalRandom.current().nextInt(1, 99 + 1);
		return rn.toString();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
