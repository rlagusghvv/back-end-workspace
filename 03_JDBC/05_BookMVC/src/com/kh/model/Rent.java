package com.kh.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rent {

	private int rent_no;
	private int rent_mem_no; 
	private int rent_book_no; 
	private Date rent_date;
}
