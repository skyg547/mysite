package com.bit2020.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2020.mvc.util.MVCUtil;

/**
 * Servlet implementation class MainController
 */
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");
		Cookie[] cookies = request.getCookies();
		int visitCount = 0;

		// 쿠키읽기
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {

				String cookieName = cookie.getName();

				if ("visitCount".equals(cookieName)) {
					cookie.getValue();

					visitCount = Integer.parseInt(cookie.getValue());

				}
			}
		}
		//쿠키
		visitCount++;
		
		Cookie cookie = new Cookie("visitCount", String.valueOf(visitCount));
		
		cookie.setMaxAge(24*60*60);
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		MVCUtil.forward("main/index", request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
