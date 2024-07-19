package com.kh.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class MemberController implements ServerInfo {

	// 싱글톤 패턴(Singleton Pattern)
	// - 디자인 패턴 중 하나로 클래스가 최대 한 번만 객체 생성되도록 하는 패턴
	
	Properties p = new Properties();
	// 1. 생성자는 private
    private MemberController () {
    	try {
			p.load(new FileInputStream("src/config/jdbc.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
     	
    // 2. 유일한 객체를 담을 static 변수
    private static MemberController instance;
    
    // 3. 객체를 반환하는 static 메서드
    public static MemberController getInstance() {
    	if(instance == null) instance = new MemberController();
    	return instance;
    }
	
	private Connection conn;

	public void dbc() {
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeAll(PreparedStatement ps, Connection conn) {
		try {
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) {
		try {
			rs.close();
			closeAll(ps, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean idCheck(String id) {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(p.getProperty("idCheck"));
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			String checkId = null;
			if(rs.next()) {
				checkId = rs.getString("id");
			}
		    closeAll(rs,ps, conn);
		    
		    if(checkId != null) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean signUp(String id, String password, String name) {
		dbc();
		try {
			if(!idCheck(id)) {
				String query = "INSERT INTO member VALUES(?,?,?)";
				PreparedStatement ps = conn.prepareStatement(query);
				ps.setString(1, id);
				ps.setString(2, password);
				ps.setString(3, name);
				ps.executeUpdate();
				closeAll(ps, conn);
				return true;
			}
			return false;

		} catch (SQLException e) {
			return false;
		}

		// 회원가입 기능 구현!
		// -> 아이디가 기존에 있는지 체크 여부!
		// -> member 테이블에 데이터 추가!

	}

	public String login(String id, String password) {
		dbc();
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT name FROM member Where id = ? AND password = ?"); // &&도 가능!
			ps.setString(1, id);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String name = rs.getString("name");
				closeAll(rs, ps, conn);
				return name;
			} else {
				closeAll(rs, ps, conn);
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		// 로그인 기능 구현!
		// -> member 테이블에서 id와 password로 멤버 정보 하나 가져오기!

	}

	public boolean changePassword(String id, String password, String newPassword) {
		dbc();
		try {
			PreparedStatement ps = conn.prepareStatement("UPDATE member SET password = ? Where id = ?");
			ps.setString(1, newPassword);
			ps.setString(2, id);
			if (login(id, password) != null) {
				ps.executeUpdate();
				closeAll(ps, conn);
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}

	}
	// 비밀번호 바꾸기 기능 구현!
	// -> login 메서드 활용 후 사용자 이름이 null이 아니면 member 테이블에서 id로 새로운 패스워드로 변경

	public void changeName(String id, String newName) {
		dbc();
		try {
			PreparedStatement ps = conn.prepareStatement(p.getProperty("changeName"));
			ps.setString(1, newName);
			ps.setString(2, id);
			ps.executeUpdate();
			closeAll(ps, conn);
		} catch (SQLException e) {
		}
		// 이름 바꾸기 기능 구현!
		// -> member 테이블에서 id로 새로운 이름으로 변경

	}

}
