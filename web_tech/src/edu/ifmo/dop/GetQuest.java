package edu.ifmo.dop;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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
import com.google.appengine.api.datastore.Transaction;


@SuppressWarnings("serial")
public class GetQuest extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

	};

	public void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws IOException, ServletException {
		
		RequestDispatcher disp;
		HttpSession session = request.getSession(true);
		Integer[] arr_numb = {};
		String[] qwer = new String [6];
		
		  if ((request.getParameter("kol") == null)) {
			  Query find_max_id = new Query("Questions").addSort("QuestionID", SortDirection.ASCENDING);
					PreparedQuery pq_max = Question.ds.prepare(find_max_id);
					for (Entity qwst: pq_max.asIterable())
					{
						session.setAttribute("max_id", qwst.getProperty("QuestionID"));
					}
			int max = Integer.valueOf((String) session.getAttribute("max_id"));
			Random random = new Random();
			HashSet<Integer> qw_set = new HashSet<Integer>();
		
			int i = 0;
			while (i < 5) {
			    if (qw_set.add(random.nextInt(max) + 1)) {
			    	i++;
			    };
			}
			
			arr_numb = qw_set.toArray(new Integer[qw_set.size()]);   //массив с номерами вопросов на игру
			for (int k=0; k < arr_numb.length; k++) {
				System.out.print(arr_numb[k]+" ");
				session.setAttribute(String.valueOf(k), String.valueOf(arr_numb[k]));
			}
			System.out.println();
			session.setAttribute("index", "0");
		}
		
		if (request.getParameter("kol") != null) {
			if (request.getParameter("kol").equals("0")) {
				request.setAttribute("kol", null);
				resp.sendRedirect("/forma.jsp");
				return;
			}
			session.setAttribute("kolvo", request.getParameter("kol"));
		}
		
		int ind = Integer.valueOf((String) session.getAttribute("index"));  //индекс в массиве с номерами вопросов
		String id = (String) session.getAttribute(String.valueOf(ind));    //сам номер текущего вопроса
		System.out.println("Index is: "+ind);
		System.out.println("Element is: "+id);
		//ind++;
		session.setAttribute("index", String.valueOf(++ind));
		
		Transaction txnn = Question.ds.beginTransaction();
		try {
		@SuppressWarnings("deprecation")
		Query qw = new Query("Questions").addFilter("QuestionID", FilterOperator.EQUAL, id);
		PreparedQuery pq = Question.ds.prepare(qw);
		for (Entity quest1: pq.asIterable())
		{
			qwer[0]=quest1.getProperty("Question").toString();
			qwer[1]=quest1.getProperty("Answer1").toString();
			qwer[2]=quest1.getProperty("Answer2").toString();
			qwer[3]=quest1.getProperty("Answer3").toString();
			qwer[4]=quest1.getProperty("Answer4").toString();
			qwer[5]=quest1.getProperty("Right").toString();
		}
		
		txnn.commit();
		} finally {
			if (txnn.isActive()) {
				txnn.rollback();
			}
		}
		
		
		session.setAttribute("question", qwer[0]);
		session.setAttribute("answer1", qwer[1]);
		session.setAttribute("answer2", qwer[2]);
		session.setAttribute("answer3", qwer[3]);
		session.setAttribute("answer4", qwer[4]);
		session.setAttribute("right", qwer[5]);
		request.getRequestDispatcher("/test.jsp").forward(request, resp);
		
		
		//System.out.println("ID: "+qwer[0]+" Question: "+qwer[1] + " :" + qwer[2]+ " :" + qwer[3]+ " :" + qwer[4] + "ID!!!: "+qwer[5]);
	};
}