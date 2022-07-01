package com.itwillbs.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

public class MysqlConnectTest {
	// jUnit4 : 테스트 할 수 있도록 만들어놓은 기능
	// * 테스트 동작은 메서드 형태로 구현
	
	// @Test - 테스트 동작이 포함되어 있는 메서드 위에 표시
	// @Before - @Test 동작이 수행되기 전에 실행해야하는 동작 표시
	// @After - 테스트 동작이 끝난 후에 실행되는 동작
//	@Test
	public void test() {
		System.out.println("테스트 실행!");
	}
	
	// 디비연결 테스트
//	@Test
	public void 디비연결테스트() {
		System.out.println("테스트 시작");
		
		final String DRIVER="com.mysql.cj.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3306/springdb";
		final String DBID="root";
		final String DBPW="1234";
		
		try {
			// 1. 드라이버 로드
			Class.forName(DRIVER);
			
			System.out.println(" 드라이버 로드 성공! ");
			// 2. 디비연결
			Connection con = DriverManager.getConnection(URL, DBID, DBPW);
			
			System.out.println(" 연결 성공 ! ");
			System.out.println(con);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("테스트 끝!");
	}
	
	@Test
	public void 테스트1_8() throws ClassNotFoundException {
		final String DRIVER="com.mysql.cj.jdbc.Driver";
		final String URL="jdbc:mysql://localhost:3306/springdb";
		final String DBID="root";
		final String DBPW="1234";
		
		Class.forName(DRIVER);
		
		// try-with(jdk1.7~) 구문 : 자동으로 자원해제 수행
		//		AutoCloseable 인터페이스를 구현하는 모든 객체는 사용가능
		try(Connection con = DriverManager.getConnection(URL, DBID, DBPW)){
			
			System.out.println(con);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
