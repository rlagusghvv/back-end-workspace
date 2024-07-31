package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.vo.Member;

public class MemberDAO {

	public MemberDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/member", "root", "qwer1234");
	}
	
	public void close(PreparedStatement ps, Connection conn) throws SQLException {
		ps.close();
		conn.close();
	}
	
	public void close( ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		rs.close();
		close(ps, conn);
	}
	
	// DAO 개발할 때 중요한 건
	// 매개변수(파라미터) 뭘 가지고 와야 되는지, 리턴타입 결과 출력이 어떤 게 필요한지
	
	// 회원가입
	public void register(Member member) throws SQLException {
		Connection conn = connect();
		
		String query = "INSERT INTO member VALUES(?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, member.getId());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getName());
		
		ps.executeUpdate();
		close(ps, conn);
	}
	
	// 로그인
	public Member login(String id, String password) throws SQLException {
		Connection conn = connect();
		
		String query = "SELECT * FROM member WHERE id = ? AND password = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		Member member = null;
		
		if(rs.next()) {
			member = new Member(id, password, rs.getString("name"));
		}
		
		close(rs, ps, conn);
		
		return member;
	}
	
	// 로그인
		public Member search(String id) throws SQLException {
			Connection conn = connect();
			
			String query = "SELECT * FROM member WHERE id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			Member member = null;
			
			if(rs.next()) {
				member = new Member(id, rs.getString("password"), rs.getString("name"));
			}
			
			close(rs, ps, conn);
			
			return member;
		}
		
		// 전체회원보기
		public List<Member> all() throws SQLException {
			Connection conn = connect();
			
			String query = "SELECT * FROM member";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			List<Member> memberList = new ArrayList<>();
			
			while(rs.next()) {
				memberList.add(new Member(rs.getString("id"), 
										  rs.getString("password"), 
										  rs.getString("name")));
			}
			
			close(rs, ps, conn);
			
			return memberList;
		}
}
