<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>성적 입력</title>
</head>
<body>
<form action="insert.do" method="post">
	<p>
	 	<select name="subject">
	 		<option value="영어">영어</option>
	 		<option value="수학">수학</option>
	 		<option value="과학">과학</option>
	 		<option value="국사">국사</option>
	 		<option value="전산">전산</option>
	 	</select>
 	</p>
 	<input type="text" name="student_number" value="${param.title}" placeholder="학번">
 	<c:if test="${errors.title}">학번 을 입력하세요.</c:if>
 	&nbsp;
 	<input type="text" name="department"  value="${param.title}" placeholder="학과">
 	&nbsp;
 	<input type="text" name="name"  value="${param.title}" placeholder="이름">
 	&nbsp;
 	<input type="text" name="attend"  value="${param.title}" placeholder="출석 점수" size="5">
 	&nbsp;
 	<input type="text" name="assignment"  value="${param.title}" placeholder="과제 점수" size="5">
 	&nbsp;
 	<input type="text" name="mid_term"  value="${param.title}" placeholder="중간 고사" size="5">
 	&nbsp;
 	<input type="text" name="final_term"  value="${param.title}" placeholder="기말 고사" size="5">
 	&nbsp;
	<br/>
	<br/>
	<input type="submit" value="학생 추가">
</form>
</body>
</html>