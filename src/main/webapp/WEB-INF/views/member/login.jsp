<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/bootStrap.jsp"></c:import>
</head>
<body>
<c:import url="../temp/header.jsp"></c:import>
<section class="container mt-5">	
	<h1 class="my-3">Login Page</h1>
	
	<form action="./login.do" method="post">
	
	
	<div class="mb-3">
	  <label for="id" class="form-label">ID</label>
	  <input type="text" name="id" class="form-control" id="id" placeholder="ID를 입력하세요">
	</div>
	
	<div class="mb-3">
	  <label for="pw" class="form-label">PASSWORD</label>
	  <input type="password" name="pw" class="form-control" id="pw" placeholder="PW를 입력하세요">
	</div>
	
	
	<div class="mb-3">
		<button class="btn btn-primary">로그인</button>
	</div>
	
	</form>
	
</body>
</html>