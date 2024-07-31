package controller;

import controller.Controller;
import controller.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.dao.MemberDAO;
import model.vo.Member;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class ModelAndView {
	
	private String path;
	private boolean isRedirect;
	
	public ModelAndView(String path) {
		this.path = path;
		this.isRedirect = false;
	}


}