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
	function goMain() {
		location.href = "main";
	}
	
	function updateConfirm() {
		confirm("생성하시겠습니까?")
		$("#form").submit()
		if(<%=request.getAttribute("cnt")%> == 0){
			alert("업데이트에 실패하였습니다.");
		} else {
			alert("업데이트에 성공하였습니다.");
		}
	}
</script>

</head>
<body>
	<div class="container">
		<br><br>
		<h1>정보 수정 페이지</h1>
		<br>
		<form action="update" method="post" id="form">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" class="form-control" name="userId"
						readonly="readonly" value="${detailList.get(0).userId }"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" class="form-control" name="userPw"
						value="${detailList.get(0).userPw }"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="text" class="form-control" name="userEmail"
						value="${detailList.get(0).userEmail }"></td>
				</tr>
				<tr>
					<td>전화번호</td>
					<td><input type="text" class="form-control" name="userPhone"
						value="${detailList.get(0).userPhone }"></td>
				</tr>
			</table>
			<br>
			<button type="button" class="btn btn-primary" onclick="updateConfirm">수정하기</button>
			<button type="button" class="btn btn-primary" onclick="goMain()">메인페이지로</button>
		</form>
	</div>
</body>
</html>