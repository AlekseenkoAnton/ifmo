<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	session.setAttribute("kolvo", "0");
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/my_style.css"
	media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Get Question</title>
</head>
<body>
	<center>
		<form action="get_quest" method="post" charset="UTF-8">
			<h3>Кто хочет стать миллионером!</h3>
			<br />
			<table>
				<!-- <tr><td>Number</td><td><input type="text" name="numb"/></td></tr> -->
				<tr>
					<td colspan="3"><input type="submit" value="Начать игру!"
						align="right" class="modern" /></td>
				</tr>
			</table>
		</form>
		<p></p>
		<a href="newquestion.jsp" class="metro" style="width: 10%;">Add
			Question</a>
	</center>
	<div style="position: fixed; left: 30px; bottom: 20px">
		<a href="index.html" class="metro">Назад</a>
	</div>
</body>
</body>
</html>