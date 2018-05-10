create database wolearning;
use wolearning;
create table user_account
(
  refid VARCHAR (50) PRIMARY  KEY,
  create_time  DATETIME not NULL ,
  create_refid VARCHAR (50),
  modify_time Datetime,
  modify_refid VARCHAR(50),
  deleted TINYINT(1) DEFAULT 0,
  version tinyint(2) DEFAULT 0,

  name varchar(100) not null,
  role VARCHAR (20) ,
  password VARCHAR (100) not NULL ,
  nick_name VARCHAR (100),
  authority VARCHAR (100)
)