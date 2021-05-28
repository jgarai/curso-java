package keyvalue.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import keyvalue.model.User;

@WebFilter("/set/*")
public class SetFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");

		if (user != null && (user.getRol().equals("USER") || user.getRol().equals("ADMIN"))) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("error", "El usuario no tiene permiso para acceder");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
