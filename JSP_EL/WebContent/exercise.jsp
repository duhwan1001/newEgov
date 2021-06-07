<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jsp.dto.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	List<MemberVO> memberList = new ArrayList<MemberVO>();
	for (int i = 1; i < 11; i++) {
		MemberVO member = new MemberVO("du" + i, "dudu", "kdhz@kdhz.com", "010-1234-5678");
		memberList.add(member);
	}

	pageContext.setAttribute("memberList", memberList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>전화번호</td>
		</tr>
		<%
			if(memberList != null) for(MemberVO member : memberList){
			// memberList != null : memberList가 null 이 아닐때.; null 일 경우를 사전에 배제함으로써 코드의 안정성을 높임
				pageContext.setAttribute("member", member);
		
			%>
		<tr>
			<td>아이디 : ${member.id}</td>
			<td>비밀번호 : ${member.pwd}</td>
			<td>이메일 : ${member.email}</td>
			<td>전화번호 : ${member.phone}</td>
		</tr>

		<%
			}
			%>

	</table>
	<!-- el문은 get 생략 가능 -->
	<!-- map : member.key.key... -->
</body>
</html>