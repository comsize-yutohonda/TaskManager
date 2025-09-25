package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskDisplayBean;

public class TaskDisplayDAO {

	public List<TaskDisplayBean> selectAllTask() throws SQLException, ClassNotFoundException {
		List<TaskDisplayBean> beanList = new ArrayList<>();
		String sql = "select * from t_task t "
				+ "join m_user u on t.user_id = u.user_id "
				+ "join m_category c on t.category_id = c.category_id "
				+ "join m_status s on t.status_code = s.status_code "
				+ "order by task_id asc";
		
		try(Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
		
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				TaskDisplayBean bean = new TaskDisplayBean();
				bean.setTaskId(res.getInt("task_id"));
				bean.setTaskName(res.getString("task_name"));
				bean.setCategoryId(res.getInt("category_id"));
				bean.setCategoryName(res.getString("category_name"));
				bean.setLimitDate(res.getDate("limit_date"));
				bean.setUserId(res.getString("category_name"));
				bean.setUserName(res.getString("user_name"));
				bean.setStatusName(res.getString("status_name"));
				bean.setMemo(res.getString("memo"));
				beanList.add(bean);
			}
		}
		return beanList;
	}
}
