package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDeleteDAO {
	public boolean deleteTask(int deleteId) throws SQLException, ClassNotFoundException{
		// 削除の成否が返り値になる
		boolean result = false;
		// 削除対象の指定
		String sql = "delete from t_task where task_id = ?";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, deleteId);
			
			if(pstmt.executeUpdate() > 0) {
				result = true;
			}
		}
		return result;
	}
}
