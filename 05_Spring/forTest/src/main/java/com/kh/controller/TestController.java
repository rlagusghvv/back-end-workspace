package com.kh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.kh.model.vo.User;
import com.kh.service.TestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@GetMapping("/")
	public String mainPage() {
		return "index";
	}
	
	@PostMapping("/register")
	public String register(User vo, Model model) {
		testService.register(vo);
		List<User> list = testService.view();
		model.addAttribute("User", list);
		return "view";
	}
	
	
}
