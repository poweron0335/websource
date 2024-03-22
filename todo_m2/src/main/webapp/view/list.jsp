<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ include file = "/include/header.jsp"%>

<h1 class="mt-5">Todo List</h1>
<table class="table">
  <thead>
    <tr>
      <th scope="col">번호</th>
      <th scope="col">제목</th>
      <th scope="col">작성일</th>
      <th scope="col">완료여부</th>
    </tr>
  </thead>
  <tbody>
  <%-- var="변수명" --%>
  <%-- items="${setAttribute 안에 선언한 이름 삽입}" --%>
  <c:forEach var="dto" items="${list}">
  <%-- 반복할 구문 삽입하는 곳 --%>
    <tr>
      <th scope="row">${dto.no}</th>
      <%-- <a href='<c:url value="/read?no=${dto.no}" />' --%>
      <td><a href='<c:url value="/read.do?no=${dto.no}" />' class="text-decoration-none text-reset">${dto.title}</a></td>
      <td>${dto.create_at}</td>
      <td>
        <input type="checkbox" name="completed" id="completed" class= "form-check-input" name="completed" value="true" <c:out value="${dto.completed?'checked':''}" />>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<%@ include file = "/include/footer.jsp"%>
