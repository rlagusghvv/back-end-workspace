package com.kh.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import config.ServerInfo;

public class MemberController implements ServerInfo {

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

	public boolean signUp(String id, String password, String name) {
		dbc();
		try {
			String query = "INSERT INTO member VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, password);
			ps.setString(3, name);
			ps.executeUpdate();
			closeAll(ps, conn);
			return true;

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
			PreparedStatement ps = conn.prepareStatement("SELECT name FROM member Where id = ? && password = ?");
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
			PreparedStatement ps = conn.prepareStatement("UPDATE member SET name = ? Where id = ?");
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
