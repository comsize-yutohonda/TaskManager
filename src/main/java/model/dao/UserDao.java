package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDao {

	public boolean judge(UserBean bean)throws SQLException, ClassNotFoundException {
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement("SELECT user_name FROM m_user WHERE user_id = ? AND password = ?")) {
			
			pstmt.setString(1,bean.getUserId());
			pstmt.setString(2,bean.getPassword());
			ResultSet res = pstmt.executeQuery();
			
			while (res.next()) {

			}
			return res.next();
		}
		
	
	}

}

