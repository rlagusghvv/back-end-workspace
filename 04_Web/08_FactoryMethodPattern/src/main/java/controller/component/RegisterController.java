package controller.component;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.dao.MemberDAO;
import model.vo.Member;

/*
 * 컴포넌트
 * - 인터페이스 기반으로 작성된 재사용성이 강한 자바 클래스
 * */
public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pwd = request.getParameter("password");
		String name = request.getParameter("name");
		Member member = new Member(id,pwd,name);

		MemberDAO dao = new MemberDAO();
		dao.register(member);
		
		return new ModelAndView("index.jsp");
	}

}