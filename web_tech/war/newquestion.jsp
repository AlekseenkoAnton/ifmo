<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="newquestion" method="post" charset="UTF-8"><h3>Adding New Question</h3><br/>
			<table border="red">
				<!-- <tr><td>Question_ID</td><td><input type="text" name="questionid"/></td></tr> -->
				<tr>
					<td>Question</td>
					<td><input type="text" name="question" /></td>
				</tr>
				<tr>
					<td>Answer1</td>
					<td><input id="result" type="text" name="a1" /></td>
				</tr>
				<tr>
					<td>Answer2</td>
					<td><input type="text" name="a2" /></td>
				</tr>
				<tr>
					<td>Answer3</td>
					<td><input type="text" name="a3" /></td>
				</tr>
				<tr>
					<td>Answer4</td>
					<td><input type="text" name="a4" /></td>
				</tr>
				<tr>
					<td>RightAnswer</td>
					<td><input type="text" name="rt_answ" /></td>
				</tr>
				<tr>
					<td colspan="3"><input type="submit" value="Send"
						align="right" /></td>
				</tr>
			</table>
		</form>
</center>
</body>
</html>