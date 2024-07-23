package com.kh.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import com.kh.model.dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memDAO = new MemberDAO();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Controller - 비즈니스 로직 작성 공간
		// index.jsp에서 /register로 요청 하여
		// 요청 받은 아이디(id), 비밀번호(pwd), 이름(name)을 받는다.
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// 1. (있으면) 폼 값 받아오기.
		String id = request.getParameter("id");
//		System.out.println(id);
		String pwd = request.getParameter("pwd");
//		System.out.println(pwd);
		String name = request.getParameter("name");
//		System.out.println(name);
		
		// 2. DAO 호출 - DB 접근 필요시
		

		boolean check = memDAO.registerMember(id, pwd, name);
		
		System.out.println(check);
	

		
//		// 중복 여부 판단 후 결과 페이지 2개 -> 회원가입 성공 시 1개, 실패 시 1개
//		//					 페이지 1개
//		// 3. 바인딩 : 결과 페이지에 서버에서 받은 값 보낼 때
//		if (check) {
		request.setAttribute("name", name);
//		
//		// 4. 네비게이션 : 결과 페이지 지정 - result.jsp
//		// response.sendRedirect("result.jsp");
//		// 만약 결과 페이지로 서버에서 받은 값 보여주려면 -> RequestDispatcher().forword 방식으로 보내야 함
//		request.getRequestDispatcher("result.jsp").forward(request, response);}
//		else {
//			response.sendRedirect("fail.jsp");
//			
//		}
		
		// 결과 페이지 1개
		request.setAttribute("check", check);
		request.getRequestDispatcher("result.jsp").forward(request, response);
		}
	}

