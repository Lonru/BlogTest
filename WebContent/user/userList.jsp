<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="../layout/header.jsp" %>
<div class="container">
  <h2>유저 목록</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>유저 아이디</th>
        <th>유저 이메일</th>
        <th>유저 권한</th>
        <th></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="user" items="${userList }">
		<tr>
			<td>${user.username}</td>
			<td>${user.email}</td>
			<td>${user.userRole}</td>	
			<td>
			<c:if test="${sessionScope.principal.id==user.id or sessionScope.principal.userRole == 'admin'}">
				<a href="user?cmd=delete&id=${user.id }" class="btn btn-danger">탈퇴</a>
			</c:if>
			</td>
		</tr>
	</c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>