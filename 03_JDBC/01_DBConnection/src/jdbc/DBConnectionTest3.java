package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest3 {

	
	public static void main(String[] args) {
		
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 완료");
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("데이터베이스 연결 완료");
			
			// 3. PreparedStatemnet - 쿼리 : UPDATE (emp_id 선택 후 emp_name 변경)
			String query = "UPDATE employee SET emp_name = ? where emp_id = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, "김현호");
			ps.setInt(2, 200);
			
			
			// 4. 쿼리문 실행
			System.out.println(ps.executeUpdate() + "명을 수정!");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}


	}
	
	
}
