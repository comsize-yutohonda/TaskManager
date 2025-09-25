package model.entity;

import java.io.Serializable;
import java.util.Date;

public class TaskDisplayBean implements Serializable {

	private int taskId;
	private String taskName;
	private int categoryId;
	private String categoryName;
	private Date limitDate;
	private String userId;
	private String userName;
	private String statusCode;
	private String statusName;
	private String memo;
	
	public TaskDisplayBean() {
		
	}

	public TaskDisplayBean(int taskId, String taskName, int categoryId, String categoryName, Date limitDate,
			String userId, String userName, String statusCode, String statusName, String memo) {
		this.taskId = taskId;
		this.taskName = taskName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.limitDate = limitDate;
		this.userId = userId;
		this.userName = userName;
		this.statusCode = statusCode;
		this.statusName = statusName;
		this.memo = memo;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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
