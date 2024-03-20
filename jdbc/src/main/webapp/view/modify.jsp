<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import ="dto.ToDoDto"%>
<%@ include file = "../include/header.jsp"%>
<%-- EL 표현식을 사용하면 request 불러오기 안해도 됨 --%>
<%

//    ToDoDto todo = (ToDoDto)request.getAttribute("todo");

%>

<h1 class="mt-5">Todo Modify</h1>
<form action="${pageContext.request.contextPath}/update" method="post">
    <div class="mb-3">
        <label for="title" class="form-label">title</label>
                <%-- <input type="text" class="form-control" id="title" placeholder="title" name="title" value ="<%=todo.getTitle()%>"> --%>
        <input type="text" class="form-control" id="title" placeholder="title" name="title" value ="${todo.title}" readonly>
    </div>
    <div class="mb-3">
        <label for="create_at" class="form-label">create_at</label>
        <%-- <input type="text" class="form-control" id="create_at" placeholder="create_at" name="create_at" value ="<%=todo.getCreate_at()%>"> --%>
        <input type="text" class="form-control" id="create_at" placeholder="create_at" name="create_at" value ="${todo.create_at}" readonly>
    </div>
    <div class="mb-3">
        <label for="completed" class="form-check-label">completed</label>
        <%-- completed 가 true 면 check 표시 --%>
        <%-- completed 를 value 값 없이 전송하면 "on" 으로 보내지기 때문에 value 값을 추가해주면 된다. --%>
        <input type="checkbox" name="completed" id="completed" class= "form-check-input" name="completed" value="true" <c:out value="${todo.completed?'checked':''}" /> >
    </div>
    <div class="mb-3">
        <label for="dscription" class="form-label">dscription</label>
        <%-- <textarea class="form-control" id="dscription" rows="3" name="dscription"><%=todo.getDscription()%></textarea> --%>
        <textarea class="form-control" id="dscription" rows="3" name="dscription" >${todo.dscription}</textarea>
    </div>
    <div>
        <button class="btn btn-primary" type="submit">수정</button>
        <a class="btn btn-danger" href='<c:url value="/delete?no=${todo.no}" />'>삭제</a>
        <a class="btn btn-success" href='<c:url value="/list" />'>목록</a>
    </div>
    <%-- 화면에는 안 보이나 데이터는 따라가게끔 하는 강제 코드 --%>
    <input type="hidden" name="no" value="${todo.no}">
</form>
<%@ include file = "../include/footer.jsp"%>

