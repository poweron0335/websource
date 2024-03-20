<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%@ page import ="dao.ToDoDao"%>
<%@ page import ="dto.ToDoDto"%>
<%
    // 한글처리
    request.setCharacterEncoding("utf-8");
    // no 가져오기 (a 태그 주소창 확인)
    String no = request.getParameter("no");

    // DB 작업
    ToDoDao dao = new ToDoDao();
    
    int result = dao.delete(no);


    // 화면이동(list)
    // 아무것도 담지 않았다면 sendRedirect(간단한 페이지 이동이기 때문에)
    response.sendRedirect("list.jsp");

%>