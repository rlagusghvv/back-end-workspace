package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 implements ServerInfo {

	public static void main(String[] args) {
		
		try {
			
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/jdbc.properties"));
			
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			System.out.println("드라이버 로딩 완료");
			
			// 2. DB 연결
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("데이터베이스 연결 완료");
			
			// 3. PreparedStatemnet - 쿼리 : UPDATE (emp_id 선택 후 emp_name 변경)
			String query = p.getProperty("delete");
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, 900);
			
			
			// 4. 쿼리문 실행
			System.out.println(ps.executeUpdate() + "명을 수정!");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
