<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>게시글 수정</title>

<!-- https://getbootstrap.com/ CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">


<link rel="stylesheet" href="../css/main.css">
<c:set var="data" value="${article.content}"/>


</head>
<body>


	<div class="container">
		<div class="success-wrapper">
			게시물이 수정처리 완료 <br> <br>
				<form action="/index.jsp">
					<input type="submit" value="처음으로!">
				</form>
		</div>
	</div>











</body>
</html>