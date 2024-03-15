<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%

    // 특정 세션 제거
    session.invalidate();
    
    // 페이지 이동
    response.sendRedirect("sessionTest.jsp"); // 본인 파일명 사용, 대소문자 확인

%>