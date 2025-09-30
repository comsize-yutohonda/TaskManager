package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.TaskBean;

class TaskDAOTest {

	@Test
	
	void registrationform_カテゴリリスト_成功(){
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		List<String> list = null;
		
		
		//実行
		
		try {
			
			list = dao.categoryList();
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		//検証
		
		assertNotNull(list);
		
		
	}
	
	
	@Test
	
	void registrationform_ユーザ名リスト_成功() {
		
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		List<String> list = null;
		
		
		//実行
		
		try {
			
			list = dao.userList();
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		//検証
			
		assertNotNull(list);
	}
	
	
	@Test
	
	void registrationform_ステータスリスト_成功() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		List<String> list = null;
		
		//実行
		
		try {
			
			list = dao.statusList();
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//検証
			
		assertNotNull(list);
		
		
	}
	
	
	@Test
	
	void registration_カテゴリ名_成功() {
		
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
		
		assertNotNull(categoryId);
		assertEquals(1,categoryId);
		
	}
	
	@Test 
	
	void registration_カテゴリ名_失敗() {
		
		//準備 
		 TaskDAO dao = new TaskDAO();
		 
		 String categoryName = null;
		 int categoryId = 0 ;
		 
		 //実行
		 
		 try {
			 
			categoryId = dao.categoryId(categoryName);
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		 
		//検証
		 assertEquals(0,categoryId);
		
	}
	
	@Test
	
	void registration_ユーザ名_成功() {
		
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
		
		assertNotNull(userId);
		assertEquals("yoshii",userId);

	}
	
	@Test
	
	void registration_ユーザ名_失敗() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		String userName = null;
		String userId = null;
		
		//実行

			try {
					
				userId = dao.userId(userName);
						
			}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			}
				
				
		//検証
				
			assertNull(userId);

		
	}
	
	@Test
	
	void registration_ステータス名_成功() {
		
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
		
		assertNotNull(statusCode);
		assertEquals("50",statusCode);
		
		
	}
	
	@Test
	
	void registration_ステータス名_失敗() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		String statusName = null;
		String statusCode = null;
		
		
		//実行
		
		try {
			
			statusCode = dao.statusCode(statusName);
			
		}catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//検証
		
		assertNull(statusCode);
		
		
	}

	
	@Test
	
	void registration_登録_成功() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();

		String date = "2025-10-31";
		Date limitDate = Date.valueOf(date);

		TaskBean bean = new TaskBean();
		bean.setTaskName("企画書");
		bean.setCategoryId(1);
		bean.setLimitDate(limitDate);
		bean.setUserId("yoshii");
		bean.setStatusCode("50");
		bean.setMemo("資料を印刷する");
		
		int count = 1;
		
		
		//実行
		
		try {
			
			count = dao.insert(bean);
		
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		
		//検証
		
		assertNotNull(count);
		assertEquals(1,count);
	}
	
	
	void registration_登録_失敗() {
		
		//準備
		
		TaskDAO dao = new TaskDAO();
		
		String date = "2025-10-31";
		Date limitDate = Date.valueOf(date);

		TaskBean bean = new TaskBean();
		bean.setTaskName("企画書");
		bean.setCategoryId(1);
		bean.setLimitDate(limitDate);
		bean.setUserId(null);
		bean.setStatusCode("50");
		bean.setMemo("資料を印刷する");
		
		int count = 0;
		
		//実行
		
				try {
					count = dao.insert(bean);
					
				} catch (ClassNotFoundException | SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		
		
		//検証
			assertNotNull(count);
			assertEquals(0,count);
	}

}
