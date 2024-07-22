package servlet.http;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPWd");
		String gender = request.getParameter("gender");
		String[] menu = request.getParameterValues("menu");

		PrintWriter out = response.getWriter();
		out.println("<html> <title>실습 1</title><body>");
		out.println("<h1>당신의 아이디는 " + userId);
		out.println("<h1>당신의 비밀번호 " + userPwd);
		String genderResult = gender.equals("M") ? "남자" : "여자";
		out.println("<h1>당신의 성별은 " + genderResult);
		out.println("<h1></h1>");
		for(String m : menu) {
			out.println("<li>" + m + "</li>");
		}
		out.println("</body></html>");
		out.close();
	}

}
