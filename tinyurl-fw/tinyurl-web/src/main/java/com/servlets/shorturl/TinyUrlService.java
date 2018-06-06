package com.servlets.shorturl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tinyurl.tasks.Task;

public class TinyUrlService extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlpathinfo = request.getRequestURI().substring(1);
		Task t = new Task();
		String s = t.decideTheTaskAndDo(urlpathinfo);
		response.sendRedirect(request.getContextPath()+"/"+s);
	}

}
