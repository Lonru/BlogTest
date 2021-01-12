
#서버프로그램 구현

github.com/Lonru/BlogTest.git

##환경
-window
-jdk1.8
-tomcat9.0
-sts tool
-mysql 8.0
-lombok
-인코딩 utf-8
-jstl 1.2

##MySQL 데이터베이스 생성 및 사용자 생성

```sql
    
CREATE TABLE user(
    id int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    email varchar(100) not null,
    userRole varchar(20) default 'user' check (userRole IN ('user','admin'))
) engine=InnoDB default charset=utf8mb4;
```

## 