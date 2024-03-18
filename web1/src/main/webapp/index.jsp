<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import="member.MemberDTO"  %>
<% 

  // 세션에 담긴 값 가져오기
  MemberDTO loginDto = (MemberDTO)session.getAttribute("loginDto");

%>
<html>
<body>
<h2>Hello World!</h2>
<h3>안녕하세요</h3>
<ul>
<%-- loginDto 가 null 값이 담길 수도 있어서 get 사용하면 Nullpoint 에러 뜸 --%>
    <% 
        if(loginDto == null){ %> 
        <li><a href="/member/login.jsp">로그인</a></li>
        
    <% } 
        else { %>
        <li><a href="/logout">로그아웃</a></li>
    <% } %>
        <li><a href="/basic/add.jsp">계산기(덧셈)</a></li>
        <li><a href="/basic/add2.jsp">계산기(사칙연산)</a></li>
</ul>
</body>
</html>
