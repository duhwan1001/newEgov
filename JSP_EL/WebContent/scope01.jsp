<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%
	pageContext.setAttribute("msg", "ㅋㅋㅋㅋ"); // 4개를 다 활성화 할 경우 우선순위는 pageContext이다.
	request.setAttribute("msg", "zzzz");
	session.setAttribute("msg", "ㄷㄷㄷㄷ");
	application.setAttribute("msg", "eeee");

	// pageContextScope.msg
	// requestScope.msg
	// sessionScope.msg
	// applicationScope.msg
%>

<h1>${param.msg }</h1>
