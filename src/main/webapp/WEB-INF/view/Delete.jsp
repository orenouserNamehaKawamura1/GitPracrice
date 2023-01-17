<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>削除するメールアドレスを入力してください。</p>
	<form action = "Kadai03DeleteConfirmServlet" method = "post">
	メールアドレス<input type = "text" name = "MAILADRESS">
	<input type = "submit" value = "削除">
	</form>
	<a href = "./">戻る</a>
</body>
</html>