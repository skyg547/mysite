package com.bit2020.mysite.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2020.mvc.util.MVCUtil;
import com.bit2020.mysite.repository.GuestbookRepository;
import com.bit2020.mysite.vo.GuestbookVo;

/**
 * Servlet implementation class GuestbookController
 */
public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("a");
		
		if("insert".equals(action)) {
			GuestbookVo vo = new GuestbookVo();
			
			
			vo.setName(request.getParameter("name"));
			vo.setPassword(request.getParameter("pass"));
			vo.setMessage(request.getParameter("content"));
			
			new GuestbookRepository().insert(vo);
			
			MVCUtil.redirect(request.getContextPath(), request, response);
			
		}
		
		MVCUtil.forward("guestbook/list", request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
