package com.ipartek.guessnumber;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.io.IOException;
//import java.util.concurrent.ThreadLocalRandom;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/guess")
public class Guess extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String valorCookie = null;
		request.setAttribute("message", "Introduce número");
		request.setAttribute("tries", 0);

		// re-start game updating the cookie to new value
		if (request.getParameter("reset") != null && request.getParameter("reset").equals("true")) {
			Cookie c = new Cookie("randomnumber", getRandomNumber());
			response.addCookie(c);
		}

		// I look for the cookie with the random number
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if ("randomnumber".equals(c.getName())) {
					valorCookie = c.getValue();
					break;
				}
			}
		}
		// if there is no cookie, one is sent to the browser with a randon number within
		if (valorCookie == null) {
			Cookie c = new Cookie("randomnumber", getRandomNumber());
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c);
		}
		// if I get the cookie...
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
					request.setAttribute("message", "El número es menor que " + bet);
				}
				if (bet < rn) {
					request.setAttribute("message", "El número es mayor que " + bet);
				}
			}
		}
		// How many tries you played?
		try {
			Integer trys = Integer.valueOf(request.getParameter("count"));
			request.setAttribute("tries", trys + 1);
		} catch (NumberFormatException ex) {
			request.setAttribute("tries", 1);
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
