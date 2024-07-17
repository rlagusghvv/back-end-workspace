package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBConnectionTest2 {
	
	public static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

	public static final String URL = "jdbc:mysql://localhost:3306/kh";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234";
	
	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			System.out.println("드라이버 로딩 완료");
			
			// 2. 데이터베이스 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("데이터베이스 연결 완료");
			
			// 3, PreparedStatement - INSERT
			String query = "INSERT INTO employee(emp_id, emp_name, emp_no) VALUES(?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, 900);
			ps.setString(2, "김현호");
			ps.setString(3, "971110-1056516");
			
			// 4. 쿼리문 실행
			System.out.println(ps.executeUpdate() + "명을 추가!");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// 2. 데이터베이스 연

	}

}
