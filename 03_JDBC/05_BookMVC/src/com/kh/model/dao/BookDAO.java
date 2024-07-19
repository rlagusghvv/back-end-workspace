package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.Book;

/*
 * DAO(Data Access Object)
 * - DB에 접근하는 역할을 하는 객체 (CRUD)
 * 
 */

public class BookDAO {

	public BookDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "qwer1234");
	}

	public void close(PreparedStatement ps, Connection conn) {
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			rs.close();
			close(ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 1. 전체 책 조회

	public ArrayList<Book> printBookAll() {
		try {
			Connection conn = connect();
			ArrayList<Book> list = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM book JOIN publisher ON (bk_pub_no = pub_no)");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Book(rs.getInt("bk_no"),
						rs.getString("bk_title"), 
						rs.getString("bk_author"), 
						rs.getInt("bk_price"), 
						new Publisher(rs.getInt("pub_no"), rs.getString("pub_name"), rs.getString("phone"))));
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 해당 부분부터는 컨트롤러 영역
	
	private Book dao = new Book();
	
	public ArrayList<Book> printBookall() {
		try {
		return dao.printBookAll();}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 해당 부분부터는 어플리케이션 영역
	public void printBookAll() {
		for(Book book : bc.printBookAll()) {
			System.out.println(book);
		}
	}
}
