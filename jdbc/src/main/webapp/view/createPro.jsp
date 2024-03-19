<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import ="dao.ToDoDao"%>
<%@ page import ="dto.ToDoDto"%>
<%
    // 한글처리
    request.setCharacterEncoding("utf-8");
    // 사용자가 입력한 todo 가져오기
    String title = request.getParameter("title");
    String dscription = request.getParameter("dscription");
    // DB 작업
    ToDoDao dao = new ToDoDao();

    ToDoDto insertDto = new ToDoDto();
    // 사용자의 데이터를 넘긴다.
    insertDto.setTitle(title);
    insertDto.setDscription(dscription);

    // result 에 넘기는 데이터를 담는다.
    int result = dao.insert(insertDto);
    // 화면이동(list) 할 땐 결과를 가져갈 것만 확인
    response.sendRedirect("list.jsp");


%>