package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskBean;



public class TaskDAO {

	
	//登録フォームのカテゴリ選択
	
	public List<String> categoryList()throws SQLException, ClassNotFoundException{
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement()) {

			String sql = "SELECT * FROM m_category";
			ResultSet res = stmt.executeQuery(sql);
			
			List<String> list = new ArrayList<>();
			
			while(res.next()) {
				
				String categoryName = res.getString("category_name");
				
				list.add(categoryName);
				
			}
			
			return list;
			
		}
		
		
	}
	
	//登録フォームの担当者情報選択
	
	public List<String> userList() throws SQLException, ClassNotFoundException{
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement()) {

			String sql = "SELECT * FROM m_user";
			ResultSet res = stmt.executeQuery(sql);
			
			List<String> list = new ArrayList<>();
			
			while(res.next()) {
				
				String userName = res.getString("user_name");
				
				list.add(userName);
			}
			
			return list;
		}
		
	}
	
	
	//登録画面のステータス情報選択
	
	public List<String> statusList() throws SQLException, ClassNotFoundException{
		
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement()) {

			String sql = "SELECT * FROM m_status";
			ResultSet res = stmt.executeQuery(sql);
			
			List<String> list = new ArrayList<>();
			
			while(res.next()) {
				
				String statusName = res.getString("status_name");
				
				list.add(statusName);
				
			}
			
			return list;
			
		}
	}
	
	
	//カテゴリー名からカテゴリIDを出す
	
	public int categoryId(String categoryName) throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * FROM m_category WHERE category_name = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
		
			//？
			pstmt.setString(1, categoryName);
			
			//表を出してカテゴリIDを出す
			ResultSet res = pstmt.executeQuery();
			
			int categoryId = 0;
			
			while(res.next()) {
				
				categoryId = res.getInt("category_id");

			}
			
			return categoryId;
		}
		
	}
	
	
	//ユーザ名からユーザIDを出す
	
	public String userId(String userName) throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * FROM m_user WHERE user_name = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			//？
			pstmt.setString(1, userName);
			
			//表を出してユーザIDを出す
			ResultSet res = pstmt.executeQuery();
			
			String userId = null;
			
			while(res.next()) {
				
			
				userId = res.getString("user_id");
			
			}
			return userId;
	
		}
	}
	
	
	//ステータス名からステータスコードを出す
	
	public String statusCode(String statusName) throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * FROM m_status WHERE status_name = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			//？
			pstmt.setString(1,statusName);
			
			//表を出してステータスコードを出す
			ResultSet res = pstmt.executeQuery();
			
			String statusCode = null;
			
			while(res.next()) {
				
				statusCode = res.getString("status_code");
			
			}
			return statusCode;
			
		}
		
	}
	
	//登録
	
	public int insert(TaskBean bean) throws SQLException, ClassNotFoundException{
		
		String sql = "INSERT INTO t_task(task_name,category_id,limit_date,user_id,status_code,memo) VALUES(?,?,?,?,?,?)";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			//？
			pstmt.setString(1,bean.getTaskName());
			pstmt.setInt(2,bean.getCategoryId());
			pstmt.setDate(3,bean.getLimitDate());
			pstmt.setString(4, bean.getUserId());
			pstmt.setString(5, bean.getStatusCode());
			pstmt.setString(6, bean.getMemo());
			
			//登録
			/*
				
			String taskName = bean.getTaskName();
			String memo = bean.getMemo();
			
			
			if(taskName.length()>50 || memo.length()>100) {
				
				count = 0;
				
			}else {
			//
				
			}*/
			
			int count = pstmt.executeUpdate();
			
			return count;
		}
	}
	
}
