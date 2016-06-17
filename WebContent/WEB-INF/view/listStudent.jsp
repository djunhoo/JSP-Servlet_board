<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>학생 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="4"><a href="insert.do">[학생 추가]</a>
		</tr>
		<tr>
			<td>과목</td>
			<td>학번</td>
			<td>전공</td>
			<td>이름</td>
			<td>총점</td>
			<td>평균</td>
			<td></td>
		</tr>
		<c:if test="${studentPage.hasNoStudent()}">
			<tr>
				<td colspan="4">해당 과목에 학생이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="student" items="${studentPage.content}">
			<tr>
				<td>${student.subject}</td>
				<td>${student.student_number}</td>
				<td>${student.department}</td>
				<td>${student.name}</td>
				<td>${student.total}</td>
				<td>${student.average}</td>
				<td><a href="delete.do?no=${student.number}">[삭제]</a></td>
			</tr>
		</c:forEach>
	</table>
	<p>${studentPage.total}</p>
	<form action="result.do" method="POST">
		<input type="hidden" name="subject" value="${student.subject}">
		<input type="submit" value="성적 처리">
	</form>
</body>
</html>