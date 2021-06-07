package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.util.URLEncoder;

import com.servlet.dto.MemberVO;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/create")
public class CreateMemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/views/create.jsp";

		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 입력
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");

		// 처리
		MemberVO memberVO = new MemberVO();

		memberVO.setUserId(userId);
		memberVO.setUserPw(userPw);
		memberVO.setUserEmail(userEmail);
		memberVO.setUserPhone(userPhone);

		int cnt = 0;
		try {
			cnt = memberService.createMember(memberVO);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("cnt", cnt);
		String redirectUrl = request.getContextPath() + "/main";
		response.sendRedirect(redirectUrl);

	}

}
