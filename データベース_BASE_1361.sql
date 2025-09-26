CREATE DATABASE task_db;
USE task_db;

CREATE TABLE m_user(
user_id VARCHAR(24) NOT NULL PRIMARY KEY,
password VARCHAR(32) NOT NULL,
user_name VARCHAR(20) NOT NULL UNIQUE KEY,
update_datetime TIMESTAMP NOT NULL 
);

CREATE TABLE m_category(
category_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
category_name VARCHAR(20) UNIQUE KEY NOT NULL,
update_datetime TIMESTAMP NOT NULL 
);

CREATE TABLE m_status(
status_code CHAR(2) NOT NULL PRIMARY KEY,
status_name VARCHAR(20) UNIQUE KEY NOT NULL,
update_datetime TIMESTAMP NOT NULL 
);

create index task_index on m_category(category_id);
create index task_index on m_user(user_id);
create index task_index on m_status(status_code);

CREATE TABLE t_task(
task_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
task_name VARCHAR(50) UNIQUE KEY NOT NULL,
category_id INT NOT NULL,
limit_date DATE NULL,
user_id VARCHAR(24)NOT NULL,
status_code CHAR(2)NOT NULL,
memo VARCHAR(100),
create_datetime TIMESTAMP NOT NULL default current_timestamp, 
update_datetime TIMESTAMP NOT NULL default current_timestamp on update current_timestamp,
FOREIGN KEY(user_id) REFERENCES m_user(user_id),
FOREIGN KEY (category_id) REFERENCES m_category(category_id),
FOREIGN KEY(status_code) REFERENCES m_status(status_code)
);

INSERT INTO m_user(user_id,password,user_name)VALUE('hiraishi','pass','平石龍二'),('honda','pass','本多悠人'),('yoshii','pass','好井朝香'),('sahara','pass','佐原真理子');

INSERT INTO m_category(category_name)VALUE('新商品A:開発プロジェクト'),('既存商品B:改良プロジェクト');

INSERT INTO m_status(status_code,status_name)VALUE('00','未着手'),('50','着手'),('99','完了');

INSERT INTO t_task(task_name,category_id,user_id,status_code,memo)VALUE('企画書作成',1,'honda','00',''),('市場調査',2,'hiraishi','50',''),('テスト',1,'yoshii','99',''),('発注',2,'sahara','00',''),('アンケート',1,'hiraishi','50','');



/*
show columns from m_user;
show columns from m_category;
show columns from m_status;
show coluTypeFieldmns from t_task;


SELECT * FROM m_user;
SELECT * FROM m_category;
SELECT * FROM m_status;
SELECT * FROM t_task;
*/
