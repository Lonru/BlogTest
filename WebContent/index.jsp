<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>

		console.log('들어는 옴?');
<c:choose>
		<c:when test="${principal.id!=null }">
		console.log("index : 로그인 되어있음");
		<%
				RequestDispatcher dis = request.getRequestDispatcher("user?cmd=userList");
				dis.forward(request, response);
		%>
		</c:when>
		<c:otherwise>		
		console.log("index : 로그인 안되어있음.");
		<%
				RequestDispatcher dis = request.getRequestDispatcher("user?cmd=loginForm");
				dis.forward(request, response);
		%>
		</c:otherwise>
		</c:choose>
</body>
</html>