package com.kh.model;

/*
 * VO(Value Object)
 * - 한 개 또는 그 이상의 속성들을 묶어서 특정 값을 나타내는 객체
 * 
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
	private int bk_no;
	private String bk_title;
	private String bk_author;
	private int bk_price;
	
    // DB 연결 후 테이블 자체를 변수로 설정
	// private Publisher publisher;
	private String pub_name;
	private String phone;

}
