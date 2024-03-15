<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<% 

    // info.jsp a 태그가 보낸 : id, name, age 갖고오기 ★
    String id = (String)request.getParameter("id");
    String name = (String)request.getParameter("name");
    String age = (String)request.getParameter("age");

    // Type mismatch: cannot convert from Object to String
    // 형변환 해라
    // String id = (String)session.getAttribute("id");
    // String name = (String)session.getAttribute("name");
    // String age = (String)session.getAttribute("age");
    
%>
<h3>next.jsp</h3>
<h3>id : <%=id%></h3>
<h3>name : <%=name%></h3>
<h3>age : <%=age%></h3>

<h3>
    <a href="next2.jsp">다음페이지</a>
</h3>