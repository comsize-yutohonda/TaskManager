package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

class TaskDeleteDAOTest {

	@Test
	void testDeleteTask_成功() {
		TaskDeleteDAO dao = new TaskDeleteDAO();
		try {
			assertTrue(dao.deleteTask(3));
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testDeleteTask_失敗() {
		TaskDeleteDAO dao = new TaskDeleteDAO();
		try {
			assertFalse(dao.deleteTask(0));
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
