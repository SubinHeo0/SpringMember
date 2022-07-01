package com.itwillbs.web;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" }
		)
public class MyBatisTest {
	
	// DataSource 객체
	@Inject
	private DataSource ds;

	// SqlSessionFactory 객체
	@Inject
	private SqlSessionFactory factory;

//	@Test
	public void 마이바티스연결테스트() {
		System.out.println("ds : " + ds);
		System.out.println("factory : " + factory);
	}
	
	@Test
	public void 마이바티스_연결체크() {
		SqlSession session = factory.openSession();
		
		System.out.println(session);
	}


}
