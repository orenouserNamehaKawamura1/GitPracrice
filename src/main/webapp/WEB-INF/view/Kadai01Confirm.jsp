<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "dto.AccountRegister" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>確認画面</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
		AccountRegister account = (AccountRegister)session.getAttribute("data");
	%>
	氏名：<%=account.getName() %><br>
	年齢：<%=account.getAge() %><br>
	性別：<%=account.getGender() %><br>
	電話番号：<%=account.getTel() %><br>
	メールアドレス：<%=account.getMail() %><br>
	パスワード：********<br>
	<a href="Kadai01RegisterExeServlet">OK</a><br>
	<a href="Kadai01RegisterFormServlet">戻る</a>
</body>
</html>