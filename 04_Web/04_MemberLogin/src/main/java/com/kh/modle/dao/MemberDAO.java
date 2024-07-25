package com.kh.modle.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.modle.vo.Member;

public class MemberDAO {

	
	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "qwer1234");
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	public void close(PreparedStatement ps, Connection conn, ResultSet rs) throws SQLException {
		close(ps,conn);
		rs.close();
	}
	
	
	// DAO 개발시 중요한 점
	// 매개변수(파라미터) 뭘 가지고 와야할까?
	// 리턴타입 결과 출력이 어떤게 필요할까?
	
	// 회원가입
	public void register(Member member) throws SQLException {
		Connection conn = connect();
		PreparedStatement ps = conn.prepareStatement("INSERT INTO member VALUES (?,?,?)");
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getPwd());
		ps.setString(3, member.getName());
		
		ps.executeUpdate();
		close(ps, conn);
	}
}
