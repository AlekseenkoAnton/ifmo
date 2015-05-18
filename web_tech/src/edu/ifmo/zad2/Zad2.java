package edu.ifmo.zad2;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Zad2 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	resp.setCharacterEncoding("UTF-8");
	String action = req.getParameter("action");
	if (action.equals("1")) { action1(req, resp); }
	else if (action.equals("2")) { action2(req, resp); }
	else if (action.equals("3")) { action3(req, resp); }
	else if (action.equals("3_1")) { action3_1(req, resp); }
	else if (action.equals("4")) { action4(req, resp); }
	}


public static void action1 (HttpServletRequest req, HttpServletResponse resp) throws IOException {
	float m = Float.parseFloat(req.getParameter("m"));
	float n = Float.parseFloat(req.getParameter("n"));
	float r1 = Math.abs(10 - m);
	float r2 = Math.abs(10 - n);
	if (r1 < r2) { resp.getWriter().println(m); }
	else { resp.getWriter().println(n); };
}

public static void action2 (HttpServletRequest req, HttpServletResponse resp) throws IOException {
	int a = Integer.parseInt(req.getParameter("a"));
	int b = Integer.parseInt(req.getParameter("b"));
	int c = Integer.parseInt(req.getParameter("c"));
	int d = b*b - 4*a*c;
	if ((d>=0) && (a!=0)) {
		resp.getWriter().print("x1="+(-b + Math.sqrt(d)/(2*a)+"   x2="+(-b - Math.sqrt(d)/(2*a))));
	}
	else {
		resp.getWriter().print("Корней нет");
	}
}

public static void action3 (HttpServletRequest req, HttpServletResponse resp) throws IOException {
	int [][]arr = new int [8][5];
	Random rnd = new Random();
	for (int i=0; i<arr.length; i++) {
		for (int j=0; j<arr[i].length; j++) {
			arr[i][j] = rnd.nextInt(90)+10;
			resp.getWriter().print(arr[i][j]+"  ");
		}
		resp.getWriter().print("<br>");
	}
}

public static void action3_1 (HttpServletRequest req, HttpServletResponse resp) throws IOException {
	resp.getWriter().print(" ");
}

public static void action4 (HttpServletRequest req, HttpServletResponse resp) throws IOException {
	int [][]arr = new int [5][8];
	int max = -100;
	Random rnd = new Random();
	for (int i=0; i<arr.length; i++) {
		for (int j=0; j<arr[i].length; j++) {
			arr[i][j] = rnd.nextInt(199)-99;
			resp.getWriter().print(arr[i][j]+"  ");
			if (arr[i][j] > max) { max = arr[i][j]; }
		}
		resp.getWriter().print("<br>");
	}
	resp.getWriter().print("<br>");
	resp.getWriter().print("Максимальный элемент: "+max);
}
}