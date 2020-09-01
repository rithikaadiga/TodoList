DROP TABLE IF EXISTS task_details;
DROP TABLE IF EXISTS user_login_details;



CREATE TABLE user_login_details (
  user_name VARCHAR(250) PRIMARY KEY,
  password VARCHAR(250) NOT NULL
);

CREATE TABLE task_details (
  task_id INT AUTO_INCREMENT PRIMARY KEY,
  task_name VARCHAR(250) NOT NULL,
  task_desc VARCHAR(2500) DEFAULT NULL,
  status BOOLEAN NOT NULL DEFAULT FALSE,
  last_update TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  user_name VARCHAR(250) NOT NULL,
  CONSTRAINT fk_user_name 
  FOREIGN KEY(`user_name`) 
  REFERENCES `user_login_details` (`user_name`)
);

