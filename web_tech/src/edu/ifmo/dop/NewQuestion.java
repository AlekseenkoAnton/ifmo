package edu.ifmo.dop;

import java.io.IOException;
import java.lang.reflect.Array;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;


@SuppressWarnings("serial")
public class NewQuestion extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	};
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
	RequestDispatcher disp;
	boolean flag;
		String quest=req.getParameter("question");
		String questionid = "-3";
		//String a1 =" ";
		//String[] qwer = new String [6];
		
		Query max_id = new Query("Questions").addSort("QuestionID", SortDirection.ASCENDING);
		PreparedQuery pq_max = Question.ds.prepare(max_id);
		for (Entity qwst: pq_max.asIterable())
		{
			questionid=qwst.getProperty("QuestionID").toString();		
		}
		int cur_id = Integer.valueOf(questionid);
		if (cur_id == -3) cur_id = 0;  // проверка на "пустоту"
		cur_id++;
		questionid=String.valueOf(cur_id);		
		String answ1=req.getParameter("a1");
		String answ2=req.getParameter("a2");
		String answ3=req.getParameter("a3");
		String answ4=req.getParameter("a4");
		String right_answ=req.getParameter("rt_answ");
		//session.setAttribute("rt_answer", qwer[5]);
		System.out.println(quest);
		flag=Question.createQuestion(questionid, quest ,answ1, answ2, answ3, answ4, right_answ);
		System.out.println(flag);
		
		
		if (flag)
		{
			disp=getServletContext().getRequestDispatcher("/forma.jsp");
			disp.forward(req, resp);
		}
		//System.out.println("ID: "+questionid+" Question: "+a1);
		//System.out.println("ID: "+qwer[0]+" Question: "+qwer[1] + " :" + qwer[2]+ " :" + qwer[3]+ " :" + qwer[4]);
	}
	}