<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>학생 등록</title>
</head>
<body>
학생을 등록했습니다.
<br>
${ctxPath = pageContext.request.contextPath ; ''}
<a href="${ctxPath}/student/list.do">[학생목록보기]</a>
<a href="${ctxPath}/article/read.do?no=${newArticleNo}">[게시글내용보기]</a>
<br />
<br />
<form action="${ctxPath}/student/list.do" method="GET">
	<select name="subject">
	 	<option value="영어">영어</option>
	 	<option value="수학">수학</option>
	 	<option value="과학">과학</option>
	 	<option value="국사">국사</option>
	 	<option value="전산">전산</option>
	</select>
	<input type="submit" value="학생목록보기">
</form>
</body>
</html>