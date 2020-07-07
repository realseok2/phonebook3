<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm</title>
</head>
<body>

	<h1>전화번호 수정폼</h1>
	
	<p>
		전화번호를 수정하려면 <br>
		아래 항목을 수정하고 "수정" 버튼을 클릭하세요.
	</p>
	
	<form action="${pageContext.request.contextPath }/phone/update" method="get">
		이름(name)	:	<input type="text"	name="name"		value="${personMap.NAME }">		<br>
		핸드폰(hp)	:	<input type="text"	name="hp"		value="${personMap.HP }">		<br>
		회사(company)	:	<input type="text"	name="company"	value="${personMap.COMPANY }">	<br>
		
						<input type="text"	name="personId"	value="${personMap.PERSON_ID }">

		<button type="submit">수정</button>
		
	</form>
	
	<h5><a href = "/pb3/phone/list">리스트 바로가기</a></h5>

</body>
</html>