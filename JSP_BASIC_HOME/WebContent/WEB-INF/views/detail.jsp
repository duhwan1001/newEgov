<%@page import="com.servlet.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
	<div class="container">
		<br><br>
		<h1>상세정보 페이지</h1>
		<br>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" class="form-control" name="userId" readonly="readonly"
					value="${detailList.get(0).userId }"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" class="form-control" name="userPw" readonly="readonly"
					value="${detailList.get(0).userPw }"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" class="form-control" name="userEmail" readonly="readonly"
					value="${detailList.get(0).userEmail }"></td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td><input type="text" class="form-control" name="userPhone" readonly="readonly"
					value="${detailList.get(0).userPhone }"></td>
			</tr>
		</table>
		<br>
		<button type="button" class="btn btn-primary" onclick="updateUser()">정보 수정</button>
		<button type="button" class="btn btn-primary" onclick="deleteUser()">삭제</button>
		<button type="button" class="btn btn-primary" onclick="goMain()">메인페이지로</button>
	</div>
</body>
</html>