package model.entity;

import java.io.Serializable;
import java.util.Date;

public class TaskDisplayBean implements Serializable {

	private int taskId;
	private String taskName;
	private String categoryName;
	private Date limitDate;
	private String userName;
	private String statusName;
	private String memo;
	
	public TaskDisplayBean() {
		
	}

	public TaskDisplayBean(int taskId, String taskName, String categoryName, Date limitDate, String userName,
			String statusName, String memo) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.categoryName = categoryName;
		this.limitDate = limitDate;
		this.userName = userName;
		this.statusName = statusName;
		this.memo = memo;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Date getLimitDate() {
		return limitDate;
	}

	public void setLimitDate(Date limitDate) {
		this.limitDate = limitDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
