package com.lonru.blog.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lonru.blog.domain.user.User;
import com.lonru.blog.domain.user.dto.JoinReqDto;
import com.lonru.blog.domain.user.dto.LoginReqDto;
import com.lonru.blog.service.UserService;
import com.lonru.blog.util.Script;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		
		UserService userService = new UserService();
		// http://localhost:8080/blog/user?cmd=loginForm
		
		if (cmd.equals("loginForm")){
			RequestDispatcher dis = request.getRequestDispatcher("user/login.jsp");
		dis.forward(request, response); 
			}else if (cmd.equals("login")) {
			 //서비스 호출
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				LoginReqDto dto = new LoginReqDto();
				dto.setUsername(username);
				dto.setPassword(password);
				User userEntity = userService.로그인(dto);
				if(userEntity != null) {
					HttpSession session = request.getSession();
					session.setAttribute("principal", userEntity); // 인증주체
					response.sendRedirect("index.jsp");
				}else {
					Script.back(response, "로그인실패");
				}
			}else if(cmd.equals("joinForm")) {
				RequestDispatcher dis = request.getRequestDispatcher("user/join.jsp");
				dis.forward(request, response); 
			}else if(cmd.equals("join")) {
				// 서비스 호출
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String email = request.getParameter("email");
				JoinReqDto dto = new JoinReqDto();
				dto.setUsername(username);
				dto.setPassword(password);
				dto.setEmail(email);
				int result = userService.회원가입(dto);
				if(result == 1) {
					response.sendRedirect("index.jsp");
				}else {
					// Script.back();
					Script.back(response, "회원가입 실패");
				}
			}else if(cmd.equals("usernameCheck")) {
				BufferedReader br = request.getReader();
				String username = br.readLine();
				System.out.println(username);
				int result = userService.유저네임중복체크(username);
				PrintWriter out = response.getWriter();
				if(result == 1) {
					out.print("ok");
				}else {
					out.print("fail");
				}
				out.flush();
			}else if(cmd.equals("logout")) {
				HttpSession session = request.getSession();
				session.invalidate();
				response.sendRedirect("index.jsp");
		}else if(cmd.equals("userList")) {
			List<User> userList = userService.유저목록();
			request.setAttribute("userList", userList);
			RequestDispatcher dis = request.getRequestDispatcher("user/userList.jsp");
			dis.forward(request, response); 
		}else if(cmd.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			int result = userService.유저삭제(id);
			if(result == 1) {
				response.sendRedirect("user?cmd=logout");
			}else {
				Script.back(response, "유저 삭제 실패");
			}

		}
	}
}