<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>


<h1>Count.jsp</h1>
<%
	List<Integer> intList = (List<Integer>) request.getAttribute("intList");
							// 리턴 타입이 오브젝트라서 형변환이 필요함
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<%
			for(int i : intList){		
		%>
			<span><%=i %></span>&nbsp;
		<%
			}
		%>
	</body>
</html>