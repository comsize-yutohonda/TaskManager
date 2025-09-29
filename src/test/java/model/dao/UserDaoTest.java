package model.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.entity.UserBean;

class UserDaoTest {

	@Test
	void test_select_成功() {
		
		UserDao dao = new UserDao(); 
		UserBean bean = new UserBean();
		String userId ="hiraishi";
		String pass ="pass";
		boolean userbean = false;
		bean.setUserId(userId);
		bean.setPassword(pass);
		
		try {
			userbean = dao.select(bean);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		assertTrue(userbean);
	}

	
	@Test
	void test_select_失敗() {

		UserDao dao = new UserDao();
		UserBean bean = new UserBean();
		String userId ="hiraishi";
		String password ="hoge";
		boolean userbean = true;
		bean.setUserId(userId);
		bean.setPassword(password);
		
		
		try {
			userbean = dao.select(bean);
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	
		assertFalse(userbean);
	}

}
