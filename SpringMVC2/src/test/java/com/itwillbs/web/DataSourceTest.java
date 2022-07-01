package com.itwillbs.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
// => 스프링으로 테스트하겠다(실행할 때 springjunit정보를 가져오겠다)
//@ContextConfiguration(
//		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
//		)


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"}
		)
public class DataSourceTest {
	
	// DataSource 객체가 필요함 => 의존하고 있다. (의존관계)
	// => 의존관계 주입
	
	// @Inject => 의존관계에 있는 객체를 자동으로 연결
	@Inject
	private DataSource ds;
	
	
//	@Test -> 있어야지만 jUnit 실행가능
	public void test() {
		System.out.println("실행체크");
	}
	
	@Test
	public void testConnect() {
		System.out.println("연결정보 : "+ds);
		try {
			Connection con = ds.getConnection();
			
			System.out.println("연결 성공 : "+con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
