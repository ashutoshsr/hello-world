package com.ashu.servlets;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FactorizationServlet
 */
@WebServlet("/FactorizationServlet")
public class FactorizationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public FactorizationServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Long i = Long.valueOf(Long.parseLong(req.getParameter("number")));
		List<Integer> factors = factors(i);
		res.getWriter().print("factors");
	}

	private List<Integer> factors(long num) {
		List<Integer> factors = new ArrayList<>();
		factors.add(1);
		for (int i = 2; i < (int) num; i++) {
			if (num % i == 0) {
				factors.add(i);
			}
		}
		return factors;
	}
}
