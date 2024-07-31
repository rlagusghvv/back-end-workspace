package com.kh.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.mybatis.model.vo.Member;
import com.kh.mybatis.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MemberController {
// 항상 요청 받는 것은 controller

	@Autowired
	private MemberService service;

//	public MemberController(MemberService service) {
//		this.service = service;
//	}

	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/register")
	public String register() {
		return "mypage/register"; // 해당하는("mypage/register") 페이지를 보여달라는 것. 해당 페이지로.
	}

	@PostMapping("/register")
	public String register(Member vo) {
		service.register(vo);
		return "redirect:/"; // @GetMapping("/") return "index"; 호출. redirect:/는 다시 요청
	}

	@GetMapping("/login")
	public String login() {
		return "mypage/login";
	}

	@PostMapping("/login")
	public String login(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("vo", service.login(vo));
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		if (member != null)
			session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/update")
	public String update(Member vo, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("vo");
		if (vo.getName() == null) {
			vo.setId(member.getId());

		}
		System.out.println(vo);
		service.update(vo);
		
		if(vo.getName()==null) vo.setName(member.getName());
		session.setAttribute("vo", vo);

		return "redirect:/";
//		HttpSession session = request.getSession();
//		session.setAttribute("vo", vo);
//		service.update(vo);
	}

}
