package transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TXCommitTest2 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kh", "root", "qwer1234");
			
			conn.setAutoCommit(false);
			
			/*
			 * 호현 -> 현호 : 1억씩 이체
			 * 호현의 잔액이 마이너스가 되면 이체 취소!!
			 */
			
			// 3개 필요! UPDATE 2개 SELECT 1개
			PreparedStatement ps1 = conn.prepareStatement("UPDATE bank SET balance = balance + 100000000 WHERE name = '김호현'");
			PreparedStatement ps2 = conn.prepareStatement("UPDATE bank SET balance = balance - 100000000 WHERE name = '김현호'");
			PreparedStatement ps3 = conn.prepareStatement("SELECT * FROM bank WHERE name = '김현호'");
			
			boolean check = true;
			while(check) {
				ps1.executeUpdate();
				ps2.executeUpdate();
				ResultSet rs = ps3.executeQuery();
				
				if (rs.next() && rs.getInt("balance") >= 0 ){
					System.out.println("잔액이 있음으로 이체 성공!");
					conn.commit();
				}
				else {
					System.out.println("잔액이 없어서 이체 취소!");
					conn.rollback();
					check = false;
				}
			}
			// 잔액이 없으므로 이체 취소!
			// 잔액이 있으므로 이체 성공!
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
