<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import ="dao.ToDoDao"%>
<%@ page import ="dto.ToDoDto"%>
<%
    // 한글처리
    request.setCharacterEncoding("utf-8");

    // value 가 없는 경우 checkbox, radio 의 경우에는 on 값을 가지고 오게 됨
    String completed = request.getParameter("completed");
    String dscription = request.getParameter("dscription");
    String no = request.getParameter("no");

    // DB 작업
    ToDoDao dao = new ToDoDao();
    
    ToDoDto dto = new ToDoDto();

    // boolean 타입의 형변환은 Boolean.parseBoolean() 으로 한다.
    dto.setCompleted(Boolean.parseBoolean(completed));
    dto.setDscription(dscription);
    dto.setNo(Integer.parseInt(no));

    int result = dao.update(dto);


    // 화면이동(list)
    // 아무것도 담지 않았다면 sendRedirect(간단한 페이지 이동이기 때문에)
    response.sendRedirect("list.jsp");

%>