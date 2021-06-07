<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%!
	public int total(int kor, int eng, int math, int science){
		return kor+eng+math+science;
	}
%>
<%
	String korParam = request.getParameter("kor");
	String engParam = request.getParameter("eng");
	String mathParam = request.getParameter("math");
	String scienceParam = request.getParameter("science");
	float avg = 0.0f;
	try{
		
		int kor = Integer.parseInt(korParam);
		int eng = Integer.parseInt(engParam);
		int math = Integer.parseInt(scienceParam);
		int science = Integer.parseInt(scienceParam);
		
		int total = total(kor,eng,math,science);
		
		avg = total / 4.0f;
		
		
	} catch(Exception e){
		out.println("입력값이 올바르지 않습니다.");
		return;
	}
	
	pageContext.setAttribute("avg", avg);
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<script>
			alert('국어 : ${param.kor}, 영어 : ${param.eng}')
			alert('평균 : ${avg}')
		</script>
	</head>
	<body>
	</body>
</html>