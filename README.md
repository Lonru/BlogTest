
# 서버프로그램 구현

github.com/Lonru/BlogTest.git

## 환경
-window
-jdk1.8
-tomcat9.0
-sts tool
-mysql 8.0
-lombok
-인코딩 utf-8
-jstl 1.2

## MySQL 데이터베이스 생성 및 사용자 생성

```sql
    
CREATE TABLE user(
    id int primary key auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    email varchar(100) not null,
    userRole varchar(20) default 'user' check (userRole IN ('user','admin'))
) engine=InnoDB default charset=utf8mb4;
```

## 로그인 화면
![image](https://user-images.githubusercontent.com/30206820/104282519-8b405500-54f2-11eb-8e3d-3d96e6695e02.png)
## 회원가입 화면
![image](https://user-images.githubusercontent.com/30206820/104282702-ce9ac380-54f2-11eb-9017-103c8d00ce13.png)
## 유저 권한의 목록
![image](https://user-images.githubusercontent.com/30206820/104285302-c6448780-54f6-11eb-8a37-8712119d3807.png)
## 어드민 권한의 목록
![image](https://user-images.githubusercontent.com/30206820/104285452-fd1a9d80-54f6-11eb-9f87-00d044c0ed77.png)
