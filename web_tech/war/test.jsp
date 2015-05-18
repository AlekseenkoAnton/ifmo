<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    String q=(String) session.getAttribute("question");
	String a1=(String) session.getAttribute("answer1");
	String a2=(String) session.getAttribute("answer2");
	String a3=(String) session.getAttribute("answer3");
	String a4=(String) session.getAttribute("answer4");
	String a5=(String) session.getAttribute("right");
	String k= (String) session.getAttribute("kolvo");
	String tmp = "";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
 <style type="text/css">
 td.radial {
 	background: white;
	border-radius: 6px;
	width: 200px;
	height: 60px;
	text-align: center;
 }
 
 table.qwestion {
 	width: 90%;
 	margin: 15px auto;
 	border: 0px;
 	background: none;
 	opacity: 0.7;
 }
 
 h3.qwestion {
 	height: 80px;
 	margin: 10px;
 	text-align: center;
 	font-size: 20pt;
 }
 
 #content {
 	background-image: url('http://art-on.ru/wp-content/uploads/2013/06/Magic_Paris_02.jpg');
 	margin: auto;
 	align: center;
 	height: 340px;
 	width: 50%;
 	padding: 10px;
 }
 
 #results_list {
 	margin: 5px auto auto 10px
 }
</style>
     
<script src="js/jquery-2.1.0.min.js"></script>

<script  type="text/javascript">
	 $( function() {
		document.getElementById("kolich").innerHTML = <%=k%>;
		document.getElementById("right").innerHTML = <%=a5%>;
	} ); 
	
	var second = 80;
	var flag = true;
	var c = 0;
	
	function check(id) {
		    if (id == <%=a5%>) {            									//верно
			//document.getElementById("result").innerHTML = "Верно!";
		 	flag = false;
		 	document.getElementById("kolich").innerHTML = <%=k%> + 1;
		 	document.getElementById("kol").value = <%=k%> + 1;
		 	document.getElementById(id).style.backgroundColor = "#32CD32";
		 	setTimeout(coloring, 500, id);

		 	
		 	
			
			if (<%=k%> + 1 == 5) {
				setTimeout("win()", 1700);
			}
			else {
			setTimeout("next()", 1700);	
			}
		}
		
		else { 																	// неверно
			//document.getElementById("result").innerHTML = "Неверно!";
			document.getElementById(id).style.backgroundColor = "red";
			setTimeout(coloring, 400, <%=a5%>);
			setTimeout(alert, 1600, "Вы проиграли! Ответили правильно на " + <%=k%> + " вопроса(ов)");
			document.getElementById("kol").value = "0";
			setTimeout("next()", 1600);
		}
	}
	
	function next() {
		document.getElementById("proverka").action = "/get_quest";
		document.getElementById("proverka").method = "POST";
		document.getElementById("proverka").submit();
		} 
	
	function win() {
		alert ("Поздравляем! Вы выиграли!");
		document.getElementById("kol").value = null;
		document.getElementById("proverka").action = "/forma.jsp";
		document.getElementById("proverka").method = "POST";
		document.getElementById("proverka").submit();
		} 
	
     function timer()
     {
    	if (flag == false) {return false};
      	document.getElementById("timer").innerHTML=second;
       	if(second == 00) {
       		alert("Вы проиграли");
			document.getElementById("kol").value = "0";
			setTimeout("next()", 1000);
       		return false;
       		}
       	second--;
       	setTimeout("timer()", 1000);
     }
     
     function coloring(x) {
			if (c == 6) {return false};
	 		if (document.getElementById(x).style.backgroundColor == "rgb(238, 232, 170)") {
				document.getElementById(x).style.backgroundColor = "#32CD32";
				c++;
				setTimeout(coloring, 200, x);
			}
	 		else {
	 			document.getElementById(x).style.backgroundColor = "rgb(238, 232, 170)";
	 			c++;
	 			setTimeout(coloring, 200, x);
			}
	 	}
</script>

<body onload="timer()">
<div id="content">
<p align="right" style="margin: 0px">Оставшееся время: <span id="timer"></span></p>
<h3 class="qwestion"><%=q%></h3>
<table class="qwestion">
<tr>
	<td id="1" onclick="check(1)" style="cursor: pointer" class="radial" ><%=a1%></td>
	<td id="2" onclick="check(2)" style="cursor: pointer" class="radial" ><%=a2%></td>
</tr>
<tr>
	<td id="3" onclick="check(3)" style="cursor: pointer" class="radial" ><%=a3%></td>
	<td id="4" onclick="check(4)" style="cursor: pointer" class="radial" ><%=a4%></td>
</tr>
</table>
<!-- <form action="get_quest" method="post" charset="UTF-8">
<button type="submit">ghg</button>
</form> -->

 <form id = "proverka">
 	<input type="hidden" name="kol" id="kol">
	<!-- <input type="text" name="cur_answ" id="cur_answ">
	<button type="button" onclick="check()"  id="but" >press me</button> -->
</form>
<hr width="90%"> 
<br>
<table id="results_list">
<tr><td>Правильный ответ: <span id="right"></span></td></tr>
<tr><td>Правильных ответов: <span id="kolich"></span></td></tr>
</table>
</div>
</body>
</html>