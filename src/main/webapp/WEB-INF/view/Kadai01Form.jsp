<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録画面</title>
</head>
<body>
	<h1>以下の情報を入力してください。</h1>
	<form action = "Kadai01RegisterConfirmServlet">
	氏名:<input type = "text" name = "NAME" ><br>
	年齢:<input type = "text" name = "AGE" ><br>
	性別:
	男性:<input type = "checkbox" name = "GENDER" value = "0">
	女性:<input type = "checkbox" name = "GENDER" value = "1"><br>
	電話番号:<input type = "text" name = "TEL" ><br>
	メールアドレス:<input type = "text" name = "MAILADRESS" ><br>
	パスワード:	<input type = "password" name = "PW"><br>
	<input type = "submit" value = "登録">
	
	</form>
	<a href = "./">戻る</a>
</body>
</html>