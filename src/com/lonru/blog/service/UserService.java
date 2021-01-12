package com.lonru.blog.service;

import java.util.List;

import com.lonru.blog.domain.user.User;
import com.lonru.blog.domain.user.UserDao;
import com.lonru.blog.domain.user.dto.JoinReqDto;
import com.lonru.blog.domain.user.dto.LoginReqDto;

public class UserService {
	private UserDao userDao; 

	public UserService() {
		userDao = new UserDao();
	}
		public int 회원가입(JoinReqDto dto) {
			return userDao.save(dto);
		}

		public User 로그인(LoginReqDto dto) {
			return userDao.findByUsernameAndPassword(dto);
		}

		public int 유저네임중복체크(String username) {
			return userDao.findByUsername(username);
		}
		public int 유저삭제(int id) {
			return userDao.delete(id);
		}
		public List<User> 유저목록(){
			return userDao.findUserList();
		}
}
