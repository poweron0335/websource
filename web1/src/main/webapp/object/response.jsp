<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<% 

    // JSP 내장객체
    // 1) HttpServletRequest    변수명이 request 로 고정
    // 2) HttpServletResponse    변수명이 response 로 고정
    // 3) JspWriter out
    // 4) PageContext : jsp 페이지에 대한 정보를 저장하고 있는 객체(변수명 : pageContext) 
    //       1) forward()
    //       2) include("포함할 페이지 경로") : ex) 디자인 템플릿 구성 시 사용

    // sendRedirect(경로)
    // http://localhost:8080/object/response.jsp 요청
    // 다른 경로로 이동
    // response.sendRedirect("/basic/input.html"); 페이지가 보여짐
    // url 도 이동된 주소로 변경됨
    response.sendRedirect("https://www.naver.com");

%>