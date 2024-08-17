package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;



@Controller
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/")
	public String index() {
		return "index";
	}

	public void fileUpload(MultipartFile file) throws IllegalStateException, IOException {
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid.toString());
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();

		File copyFile = new File(
				"/Users/kimhyeonho/Desktop/developer/start_2024.05.28/back-end-workspace/05_Spring/Upload/" + fileName);
		file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치로 저장

	}

	@PostMapping("/upload")
	public String upload(MultipartFile file) throws IllegalStateException, IOException {
		System.out.println("upload!");
		System.out.println("파일이름 : " + file.getOriginalFilename());
		System.out.println("파일 사이즈 : " + file.getSize());
		System.out.println("파일 파라미터명 : " + file.getName());

		// 중복 방지를 위한 UUID 적용
		fileUpload(file);
		return "redirect:/";
	}

	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) throws IllegalStateException, IOException {
		UUID uuid = UUID.randomUUID();
		for (MultipartFile mpf : files) {
			fileUpload(mpf);

		}
		return "redirect:/";
	}

	

	@GetMapping("/write")
	public String write() {
		return "write";
	}

	@PostMapping("/write")
	public String write(Board board) throws IllegalStateException, IOException {
		// TODO: process POST request
		fileUpload(board.getFile());
		System.out.println(board.getFile().getOriginalFilename());
		board.setUrl(board.getFile().getOriginalFilename());
		boardService.write(board);
		return "redirect:/list";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
	    List<Board> boardList = boardService.list();
	    System.out.println(boardList);
	    model.addAttribute("list", boardList);
	    return "list";
	}
	

}
