<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/news/delete/1">删除</a>
	<form action="/news/save" method="post">
		标题<input name="title"/>
		内容<input name="content"/>
		<input type="hidden" name="list" value="123"/>
		<input type="hidden" name="list" value="223"/>
		<input type="hidden" name="list" value="333"/>
		<input type="hidden" name="list" value="455"/>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>