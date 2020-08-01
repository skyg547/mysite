package com.bit2020.web.util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MVCUtil {

	public static void forward(String viewname, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/" + viewname + ".jsp");
		rd.forward(request, response);
	}

	public static void redirect(String url, HttpServletRequest request, HttpServletResponse response) throws IOException {

		response.sendRedirect(url);
		// TODO Auto-generated method stub

	}
}
