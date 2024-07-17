package person.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import person.model.Person;

public class PersonController implements ServerInfo {
	
	private Connection conn;
	// 리턴 타입이나 매개변수(파라미터) 자유롭게 변경 가능!
	// 메서드 추가 가능!!
	
	/*
	 * 1. 드라이버 로딩
	 * 2. DB 연결
	 * 3. PreparedStatement - 쿼리
	 * 4. 쿼리 실행
	 */

	
	public void dbc() {
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 고정적인 반복 -- DB연결, 자원 반납 -> 공통적인 메서드 정의.. 메서드마다 호출해서 사용!
	// 5. 자원 반납
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
			closeAll(ps,conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 변동적인 반복 -- 비즈니스 로직 DAO(Database Access Object)
	// person 테이블에 데이터 추가 - INSERT
	public void addPerson(String name, int age, String addr) {
		try {
			String query = "INSERT INTO person(name, age, addr) VALUES(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setInt(2, age);
			ps.setString(3, addr);
			ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson(String name, String addr) {
		
		try {
			String query = "UPDATE person SET addr = ? where name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, addr);
			ps.setString(2, name);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson(String name) {
		try {
			String query = "DELETE FROM person where name = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public ArrayList<Person> searchAllPerson() {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM person");
			ResultSet rs = ps.executeQuery();
			ArrayList<Person> list = new ArrayList();
				
				while(rs.next()) {
					Person person = new Person();
					person.setId(rs.getInt("id"));
					person.setName(rs.getString("name"));
					person.setAge(rs.getInt("age"));
					person.setAddr(rs.getString("addr"));
					list.add(person);
				}
				
				closeAll(rs,ps,conn);
				return list;
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return null;
		}


	// person 테이블에서 데이터 한개만 가져오기 - SELECT
	public void searchPerson(String namein) {
		try {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM person WHERE name = ?");
			ps.setString(1, namein);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String addr = rs.getString("addr");
				
				System.out.println(id + " / " + name + " / " + age + " / " + addr 
						);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
