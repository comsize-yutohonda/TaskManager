package model.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.entity.TaskDisplayBean;

class TaskDisplayDAOTest {

	@Test
	void testSelectAllTask_成功() {
		TaskDisplayDAO dao = new TaskDisplayDAO();
		List<TaskDisplayBean> displayBeanList = null;
	
		try {
			displayBeanList = dao.selectAllTask();
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		assertNotNull(displayBeanList);
	}
	

}
