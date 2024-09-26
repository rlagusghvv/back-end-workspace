package com.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.domain.Movie;
import com.jpa.service.MovieService;

@RestController
@RequestMapping("/api/*")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	// 추가 
	@PostMapping("/movie")
	public ResponseEntity add(@RequestBody Movie vo) {
//		System.err.println(vo);
		movieService.change(vo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// 전체 조회
	@GetMapping("/movie")
	public ResponseEntity viewAll() {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.viewAll());
	}
	
	// 한개 조회
	@GetMapping("/movie/{id}")
	public ResponseEntity view(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.OK).body(movieService.view(id));
	}
	
	// 수정
	
	@PutMapping("/movie")
	public ResponseEntity update(@RequestBody Movie vo) {
		movieService.change(vo);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
	// 삭제
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity delete(@PathVariable int id) {
		movieService.delete(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}
