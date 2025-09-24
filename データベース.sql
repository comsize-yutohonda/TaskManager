SHOW databases;
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

CREATE TABLE t_task(
task_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
task_name VARCHAR(50) UNIQUE KEY NOT NULL,
category_id INT NOT NULL FOREIGN KEY (category_id) REFERENCES m_category(category_id),
limit_date DATE,
user_id VARCHAR(24)NOT NULL,
status_code CHAR(2)NOT NULL,
memo VARCHAR(100),
create_datetime TIMESTAMP NOT NULL default current_timestamp, 
update_datetime TIMESTAMP NOT NULL default current_timestamp on update current_timestamp,,
FOREIGN KEY(user_id) REFERENCES m_user(user_id),
 FOREIGN KEY(status_code) REFERENCES m_status(status_code)
);

