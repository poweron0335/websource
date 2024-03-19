<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file = "../include/header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1 class="mt-5">JSTL</h1>

<%-- 
    EL : jsp 에서 사용
        getAttribute("name") == ${name}
        getAttribute("loginDto"), <%=loginDto.getName()%> == ${loginDto.name}
 --%>
 
<%-- c:if => else 개념 없음 --%>
<%-- <c:url value="/js/dashboard.js" /> --%>
<c:if test="${5<10}">
    <h4>5는 10보다 작다</h4>
</c:if>
<c:if test="${6+3 == 9}">
    <h4>6+9은 9이다</h4>
</c:if>
<%-- c:choose : if ~ else 개념 --%>
<c:choose>
    <c:when test="${5+10 == 50}">
        <h4>5+10은 50이다</h4>
    </c:when>
    <c:otherwise>
        <h4>5+10은 50이 아니다</h4>
    </c:otherwise>
</c:choose>
<%-- c:forEach --%>
<c:forEach var="test" begin="1" end="10" step="2">
    <b>${test}</b>
</c:forEach>
<%-- c:out => 화면 출력(조건 부여 가능, 삼항연산자와 모습이 비슷함) --%>
<c:out value="${flag?"OK":"Error"}"></c:out>
<%-- 닫는 태그가 무조건 있어야 하는데 사이에 넣을 값이 없으면 /> <= 이런식으로 닫아도 됨 --%>
<c:out value="${flag?'OK':'Error'}" />
<%@ include file = "../include/footer.jsp"%>