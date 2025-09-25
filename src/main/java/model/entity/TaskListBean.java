package model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class TaskListBean {

	//タスクID
	private int taskId;
	
	//タスク名
	private String taskName;
	
	//カテゴリーID
	private int categoryId;
	
	//期限
	private Date limitDate;
	
	//ユーザーID
	 private String userId;
	
	//ステータスコード
	 private char statusCode;
	
	//メモ
	 private String memo;
	
	//登録日時
	 private Timestamp createDatetime;
	
	//更新日時
	 private Timestamp updateDatetime;
	 
	
	//getterとsetter
	 
	//タスクID
	 public int getTaskId() {
	        return taskId;
	    }
	    public void setTaskId(int taskId) {
	        this.taskId = taskId;
	    }
	    
    //タスク名
	 public String getTaskName() {
	        return taskName;
	    }
	    public void setTaskName(String taskName) {
	        this.taskName = taskName;
	    }

    //カテゴリーID
	 public int getCategoryId() {
	        return categoryId;
	    }
	    public void setCategoryId(int categoryId) {
	        this.categoryId = categoryId;
	    }
	    
    //期限
	 public Date getLimitDate() {
	        return limitDate;
	    }
	    public void setLimitDate(Date limitDate) {
	        this.limitDate = limitDate;
	    }
	
    //ユーザーID
	 public String getUserId() {
	        return userId;
	    }
	    public void setUserId(String userId) {
	        this.userId = userId;
	    }
	    
    //ステータスコード
	 public char getStatusCode() {
	        return statusCode;
	    }
	    public void setStatusCode(char statusCode) {
	        this.statusCode = statusCode;
	    }
    
	//メモ
	 public String getMemo() {
	        return memo;
	    }
	    public void setMemo(String memo) {
	        this.memo = memo;
	    }
	   
	//登録日時
	 public Timestamp getCreateDatetime() {
	        return createDatetime;
	    }
	    public void setCreateDatetime(Timestamp createDatetime) {
	        this.createDatetime = createDatetime;
	    }
    //更新日時	
	 public Timestamp getUpdateDatetime() {
	        return updateDatetime;
	    }
	    public void setUpdateDatetime(Timestamp updateDatetime) {
	        this.updateDatetime = updateDatetime;
	    }

}
