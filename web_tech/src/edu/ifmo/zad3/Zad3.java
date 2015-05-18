package edu.ifmo.zad3;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class Zad3 extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setCharacterEncoding("UTF-8");

		try {
			int frst = Integer.valueOf(req.getParameter("first"));
			int scnd = Integer.valueOf(req.getParameter("second"));
			getSymbols(frst, scnd, resp);
		} catch (NumberFormatException e) {
			resp.getWriter().println("Некорректно введены значения!");
		}

	}

	public void getSymbols(int frst, int scnd, HttpServletResponse resp)
			throws IOException {
		int k = 0;
		if ((frst > 0) && (frst < 65535) && (scnd > 0) && (scnd < 65535)
				&& (frst < scnd)) {
			resp.getWriter().println("<table><tr>");
			for (int i = frst; i < scnd + 1; i++) {
				if (k == 15) {
					resp.getWriter().println("</tr><tr>");
					k = 0;
				}
				char ch = (char) i;
				String t = intToHex(i);
				resp.getWriter().println(
						"<td class=\"cell\" onclick=\"test(" + i + "," + t
								+ ")\" " + "title=\"Десятичное значение: " + i
								+ "\nШестнадцатиричное значение: " + t + "\">"
								+ ch + "</td>");
				k++;
			}

			resp.getWriter().println("</table></tr>");
		} else {
			resp.getWriter().println("Некорректно введены значения!");
		}
	}

	public String intToHex(int q) {
		String tmp = "";
		while (q > 0) {
			int r = q % 16;
			if (r > 9) {
				r = r + (int) 'A' - 10;
			} else {
				r = r + (int) '0';
			}
			tmp = (char) r + tmp;
			q = q / 16;
		}
		while (tmp.length() < 4) {
			tmp = "0" + tmp;
		}
		tmp = "0x" + tmp;
		return tmp;
	}

}
