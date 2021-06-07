package com.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.dto.MemberVO;
import com.servlet.exception.InvalidPasswordException;
import com.servlet.exception.NotFoundIDException;
import com.servlet.service.MemberService;
import com.servlet.service.MemberServiceImpl;
import com.servlet.view.HTMLView;

import sun.rmi.server.Dispatcher;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private MemberService memberService = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "/WEB-INF/views/login.jsp";
		
		//HTMLView.loginView(response);
		request.getRequestDispatcher(view).forward(request, response);
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 화면 url
		String view = "/WEB-INF/views/login_success.jsp";
		
		
		// 입력
		String userId = request.getParameter("userId");
		String userPw = request.getParameter("userPw");

		// 처리
		String script = "";
		try {
			MemberVO member = memberService.login(userId, userPw);

			script = "alert('로그인 성공');" + "location.href='" + request.getContextPath() + "/main';";
		} catch (NotFoundIDException e) {
			script = "alert('" + e.getMessage() + "');" + "history.go(-1);";
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			script = "alert('" + e.getMessage() + "');" + "location.href='" + request.getContextPath() + "/login';";
			e.printStackTrace();
		} catch (SQLException e) {
			script = "alert('서버장애로 인해 불가합니다.');" + "history.go(-1);";
			e.printStackTrace();
		}

		// 출력
		//HTMLView.html(response, script);
		
		request.getRequestDispatcher(view).forward(request, response);
	}

}
