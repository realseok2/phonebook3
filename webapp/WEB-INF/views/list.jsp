<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
</head>
<body>
	<h1>전화번호 리스트</h1>
	<p>입력한 정보의 내역입니다.</p>
	

	<c:forEach items = "${pList }" var = "personVo">

	<table border="1">
		<colgroup>
			<col style="width: 120px;">
			<col style="width: 170px;">
		</colgroup>

		<tbody>
			<tr>
				<td>이름(Name)</td>
				<td>${personVo.name }</td>
			</tr>

			<tr>
				<td>핸드폰(Hp)</td>
				<td>${personVo.hp }</td>
			</tr>

			<tr>
				<td>회사(Company)</td>
				<td>${personVo.company }</td>
			</tr>
			
			<tr>
				<td><a href="${pageContext.request.contextPath }/phone/updateForm?personId=${personVo.personId }">수정</a></td>
				<td><a href="${pageContext.request.contextPath }/phone/delete?personId=${personVo.personId }">삭제</a></td>
			</tr>

		</tbody>
	</table>
	
	<br>
	
	</c:forEach>

	<br>

		
		<p>
			<a href="${pageContext.request.contextPath }/phone/writeForm">추가번호 등록</a>
		</p>
		
</body>
</html>