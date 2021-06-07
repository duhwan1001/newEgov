<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.6.0.js""></script>
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
	
	function idConfirm() {
		if($("#exampleInputId").val() == ""){
			alert("아이디가 입력되지 않았습니다 !")
			return;
		} else{
			confirm("생성하시겠습니까?")
			$("#form").submit()
		}
	}
</script>
</head>
<body>
	<form action="create" method="post" id="form">
		<h1>회원 생성</h1>
		<div class="form-group">
			<label for="exampleInputId">아이디</label> 
			<input type="text" class="form-control" id="exampleInputId" name="userId" aria-describedby="emailHelp" placeholder="Enter id"> 
		</div>
		<div class="form-group">
			<label for="exampleInputPassword">비밀번호</label>
			<input type="password" class="form-control" id="exampleInputPassword" name="userPw" placeholder="Password">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail">이메일</label>
			<input type="email" class="form-control" id="exampleInputEmail" name="userEmail" placeholder="Enter email">
		</div>
		<div class="form-group">
			<label for="exampleInputPhone">전화번호</label>
			<input type="text" class="form-control" id="exampleInputPhone" name="userPhone" placeholder="Enter phoneNumber">
		</div>
		<button type="button" class="btn btn-primary" onclick="idConfirm()">생성</button>
		<button type="button" class="btn btn-primary" onclick="goMain()">메인페이지로</button>
	</form>
</body>
</html>