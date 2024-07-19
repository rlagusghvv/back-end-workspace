package com.kh.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrintRentBook {

	private int rent_no;
	private String bk_title;
	private String bk_author;
	private Date rent_date;
	private Date Adddate;
}
