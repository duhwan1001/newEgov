<%@page import="com.servlet.dto.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
	function move() {
		location.href = "create";
	}
</script>

</head>
<body>
	<div class="container">
		<br><br>
		<h1>정보 조회 페이지</h1>
		<br>
		<button type="button" onclick="move()" class="btn btn-primary">회원등록</button>
		<br><br>
		<table class="table">
			<thead>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이메일</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${memberList}" var="memberList">
					<tr>
						<td><a href="detail?userId=${memberList.userId}">${memberList.userId}</a></td>
						<td>${memberList.userPw}</td>
						<td>${memberList.userEmail}</td>
						<td>${memberList.userPhone}</td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>
	</div>
</body>
</html>