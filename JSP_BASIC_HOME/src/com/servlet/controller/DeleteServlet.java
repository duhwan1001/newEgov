package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/views/delete.jsp";

		// 입력
		String userId = request.getParameter("userId");

		// 처리
		int cnt = 0;
		try {
			cnt = memberService.deleteMember(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("cnt", cnt);
		String redirectUrl = request.getContextPath() + "/main";
		response.sendRedirect(redirectUrl);
	}
}
