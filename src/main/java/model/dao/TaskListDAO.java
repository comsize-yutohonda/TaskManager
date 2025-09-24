package model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.TaskListBean;

public class TaskListDAO {
	public List<TaskListBean> findAll() throws SQLException, ClassNotFoundException{
		
		List<TaskListBean> taskList = new ArrayList<>();
		String sql = "SELECT * FROM t_task";
		
		try(Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery(sql)){
			
			while (res.next()) {
                TaskListBean task = new TaskListBean();
                task.setTaskId(res.getInt("task_id"));
                task.setTaskName(res.getString("task_name"));
                task.setCategoryId(res.getInt("category_id"));
                task.setLimitDate(res.getDate("limit_date"));
                task.setUserId(res.getString("user_id"));
                task.setStatusCode(res.getString("status_code").charAt(0));
                task.setMemo(res.getString("memo"));
                task.setCreateDatetime(res.getTimestamp("create_datetime"));
                task.setUpdateDatetime(res.getTimestamp("update_datetime"));
                taskList.add(task);
            }
		}
		return taskList;
	}
}
