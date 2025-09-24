package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TaskDAO {

	
	//カテゴリー名からカテゴリIDを出す
	
	public int categoryId(String categoryName) throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * FROM m_category WHERE category_name = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
		
			//？
			pstmt.setString(1, categoryName);
			
			//表を出してカテゴリIDを出す
			ResultSet res = pstmt.executeQuery();
			
			int categoryId = res.getInt("category_id");
			
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
			
			String userId = res.getString("user_id");
			
			return userId;
	
		}
	}
	
	
	//ステータス名からステータスコードを出す
	
	public String statusCode(String statusName) throws SQLException, ClassNotFoundException{
		
		String sql = "SELECT * FROM m_status WHERE status_name = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			//？
			pstmt.setString(1,"statusName");
			
			//表を出してステータスコードを出す
			ResultSet res = pstmt.executeQuery();
			
			String statusCode = res.getString("status_code");
			
			return statusCode;
			
		}
		
	}
	
	//登録
	
	public int insert(String taskName,int categoryId,Date limitDate,) throws SQLException, ClassNotFoundException{
		
		
		
		
	}
	
}
