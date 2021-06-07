<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>

<%
	out.println();
%>
<%=""%>

<%
	for (int dan = 2; dan <= 9; dan++) {
%>

<h3><%=dan%>단 입니다.
</h3>

<%
	for (int i = 1; i <= 9; i++) {
			int sum = dan * i;
%>

<p><%=dan%>*<%=i%>=<%=sum%></p>

<%
	}
%>
<br/>
<%
	}
%>
