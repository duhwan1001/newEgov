<%@page import="com.servlet.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<html>
<head>
<script>
	function updateUser() {
		location.href = "update?userId=${detailList.get(0).userId }";
	}
	function deleteUser() {
		location.href = "delete?userId=${detailList.get(0).userId }";
	}
	function goMain() {
		location.href = "main";
	}
</script>

</head>
<body>
	<h1>상세정보 페이지</h1>
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId" readonly="readonly"
				value="${detailList.get(0).userId }"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" name="userPw" readonly="readonly"
				value="${detailList.get(0).userPw }"></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="text" name="userEmail" readonly="readonly"
				value="${detailList.get(0).userEmail }"></td>
		</tr>
		<tr>
			<td>전화번호</td>
			<td><input type="text" name="userPhone" readonly="readonly"
				value="${detailList.get(0).userPhone }"></td>
		</tr>
	</table>
	<button type="button" onclick="updateUser()">정보 수정</button>
	<button type="button" onclick="deleteUser()">삭제</button>
	<button type="button" onclick="goMain()">메인페이지로</button>
</body>
</html>