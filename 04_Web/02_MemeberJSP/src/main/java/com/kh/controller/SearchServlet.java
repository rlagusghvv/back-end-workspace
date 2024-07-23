package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		MemberDAO md = new MemberDAO();
		Member member = null;

		try {
			member = md.viewSMember(id);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
		// 3. 바인딩
		request.setAttribute("mem", member);
		// 4. 네비게이션
		request.getRequestDispatcher("search.jsp").forward(request, response);

	}
}
