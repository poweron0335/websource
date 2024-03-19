<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>

<%@ page import ="dao.ToDoDao"%>
<%@ page import ="dto.ToDoDto"%>
<%
    // 한글처리
    request.setCharacterEncoding("utf-8");
    // 제목 클릭 시 no 가져오기
    String no = request.getParameter("no");

    // DB 작업
    ToDoDao dao = new ToDoDao();
    // ToDodto getRow 메서드 받아올 객체 생성
    ToDoDto todo = dao.getRow(no);


    request.setAttribute("todo", todo);
    // 화면이동(modify)
    pageContext.forward("modify.jsp");

%>