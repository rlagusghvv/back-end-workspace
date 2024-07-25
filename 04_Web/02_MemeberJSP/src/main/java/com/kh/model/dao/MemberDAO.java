package com.kh.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.model.vo.Member;

public class MemberDAO {

	// 회원가입 - member 스키마의 member 테이블
	public boolean registerMember(String id, String password, String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "qwer1234");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO member VALUES(?,?,?)");
			ps.setString(1, id); 
			ps.setString(2, password);
			ps.setString(3, name);
			ps.executeUpdate();
			conn.close();
			ps.close();
			return true;
		} catch (ClassNotFoundException | SQLException e) {
			return false;
		}
	}
	
	public ArrayList<Member> viewMember() throws SQLException, ClassNotFoundException {
		ArrayList<Member> list = new ArrayList();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM member");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Member m = new Member();
			m.setId(rs.getString("id"));
			m.setPassword(rs.getString("password"));
			m.setName(rs.getString("name"));
			list.add(m);
		}
		conn.close();
		ps.close();
		rs.close();
		return list;
		
	}
	
	public Member viewSMember(String id) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "qwer1234");
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM member Where id = ?");
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Member m = new Member();
		if(rs.next()) {
			m.setId(rs.getString("id"));
			m.setPassword(rs.getString("password"));
			m.setName(rs.getString("name"));}
			conn.close();
			ps.close();
			rs.close();
			return m;
		}
		
	}

