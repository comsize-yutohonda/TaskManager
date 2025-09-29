package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

class TaskDAOTest {

	@Test
	
	void registration_test_成功(){
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		int categoryList = 0;
		List<String> list = null;
		
		
		//実行
		
		try {
			
			list = dao.categoryList(categoryList);
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		//検証
		
		assertNotNull(list);
		
		
	}
	
	
	@Test
	
	void registration_test_成功2() {
		
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		int userList = 0;
		List<String> list = null;
		
		
		//実行
		
		try {
			
			list = dao.userList(userList);
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//検証
			
		assertNotNull(list);
	}
	
	
	@Test
	
	void registration_test_成功3() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		int statusList = 0;
		List<String> list = null;
		
		//実行
		
		try {
			
			list = dao.statusList(statusList);
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//検証
			
		assertNotNull(list);
		
		
	}
	
	
	@Test
	
	void registration_test_成功4() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		String categoryName = "新商品A:開発プロジェクト";
		int categoryId = 0;
		
		
		//実行
		
		try {
			
			categoryId = dao.categoryId(categoryName);
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		//検証
		
		assertEquals(1,categoryId);
		
	}
	
	
	@Test
	
	void registration_test_成功5() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		String userName = "好井朝香";
		String userId = null;
		
		
		//実行

		try {
			
			userId = dao.userId(userName);
				
		}catch (ClassNotFoundException | SQLException e) {
		// TODO 自動生成された catch ブロック
		e.printStackTrace();
		}
		
		
		//検証
		
		assertEquals("yoshii",userId);

	}
	
	@Test
	
	void registration_test_成功6() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		String statusName = "着手";
		String statusCode = null;
		
		
		//実行
		
		try {
			
			statusCode = dao.statusCode(statusName);
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//検証
		
		assertEquals("50",statusCode);
		
		
	}

}
