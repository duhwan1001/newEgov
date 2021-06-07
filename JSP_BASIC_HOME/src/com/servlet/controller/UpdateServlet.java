package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.util.URLEncoder;

import com.servlet.dto.MemberVO;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/views/update.jsp";

		// 입력
		String userId = request.getParameter("userId");

		// 처리
		List<MemberVO> member = new ArrayList<MemberVO>();
		try {
			member = memberService.detailMember(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("detailList", member);
		request.getRequestDispatcher(view).forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		
		MemberVO memberVO = new MemberVO();
		memberVO.setUserId(userId);
		memberVO.setUserPw(userPw);
		memberVO.setUserEmail(userEmail);
		memberVO.setUserPhone(userPhone);
		
		int cnt = 0;
		try {
			cnt = memberService.updateMember(memberVO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("cnt", cnt);
		String redirectUrl = request.getContextPath() + "/main";
		response.sendRedirect(redirectUrl);
	}
}
