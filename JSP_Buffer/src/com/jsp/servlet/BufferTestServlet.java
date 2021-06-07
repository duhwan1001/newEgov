package com.jsp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BufferTestServlet")
public class BufferTestServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String url = "/WEB-INF/views/out.jsp";
		
		request.getRequestDispatcher(url).forward(request, response);
		
/*		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		out.println("<script>alert('네이버로 이동합니다.');	"
				+ "location.href='https://www.naver.com';"
				+ "</script>");

		//new Scanner(System.in).nextLine(); 메서드가 끝나지 않아서 페이지가 로딩되지 않음
		
		//response.sendRedirect("https://www.naver.com");
*/		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
