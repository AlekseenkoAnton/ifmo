package edu.ifmo.dop;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Transaction;

@SuppressWarnings("serial")
public class Question extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
	}
	public static DatastoreService ds=DatastoreServiceFactory.getDatastoreService();
	public static boolean createQuestion(String question_id, String quest, String answ1, String answ2, String answ3, String answ4, String right) {
		
		Entity question = new Entity ("Questions", question_id);
		question.setProperty("QuestionID", question_id);
		question.setProperty("Question", quest);
		question.setProperty("Answer1", answ1);
		question.setProperty("Answer2", answ2);
		question.setProperty("Answer3", answ3);
		question.setProperty("Answer4", answ4);
		question.setProperty("Right", right);
		ds.put(question);
		System.out.println("ID: "+question.getKey()+" Question: "+question.getKind());
		return true;
	}
	}

