package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TaskDeleteDAO {
	public boolean deleteTask(int taskId) throws SQLException, ClassNotFoundException{
		boolean result = false;
		String sql = "delete from t_task where task_id = ?";
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, taskId);
			
			if(pstmt.executeUpdate() > 0) {
				result = true;
			}
		}
		return result;
	}
}
