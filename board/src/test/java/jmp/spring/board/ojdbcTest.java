package jmp.spring.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zaxxer.hikari.HikariDataSource;

import jmp.spring.mapper.BoardMapper;
import jmp.spring.service.BoardService;
import jmp.spring.vo.BoardVo;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class ojdbcTest {

	@Autowired
	BoardService service;
	
	@Autowired
	BoardMapper mapper;
	
	@Autowired
	HikariDataSource datasource;
	
	@Test
	public void service() {
		
		log.info("srvice=======" + service.getList());
		//log.info("service========" + service.getList());
	}
	
	@Test
	public void mapper() {
		BoardVo vo = new BoardVo();
		vo.setContent("내용-mapperTest");
		vo.setTitle("제목-mapperTest");
		vo.setWriter("작성자-mapperTest");
		
		int res = mapper.insertBoard(vo);
		
		//log.info("mapper.insert.test======" + res);
		log.info("service.insertBoard======" + service.insertBoard(vo));
	}
	
	@Test
	public void hikaricpTest() {
		try {
			log.info(datasource);
			Connection conn = datasource.getConnection();
			
			log.info("hikaricpTest : " + conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void ojdbcTest() {
		try {
			Connection conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe", "spring", "spring");
			
			log.info(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
