<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ page import ="dto.ToDoDto"%>
<%@ include file = "../include/header.jsp"%>
<%

//    ToDoDto todo = (ToDoDto)request.getAttribute("todo");

%>
<h1 class="mt-5">Todo View</h1>
<form action="" method="post">
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
        <input type="checkbox" name="completed" id="completed" class= "form-check-input" name="completed" disabled <c:out value="${todo.completed?'checked':''}" /> >
    </div>
    <div class="mb-3">
        <label for="dscription" class="form-label">dscription</label>
        <%-- <textarea class="form-control" id="dscription" rows="3" name="dscription"><%=todo.getDscription()%></textarea> --%>
        <textarea class="form-control" id="dscription" rows="3" name="dscription" readonly>${todo.dscription}</textarea>
    </div>
    <div>
        <a class="btn btn-primary" href='<c:url value="/modify.do?no=${todo.no}"/>'>수정</a>
        <a class="btn btn-success" href='<c:url value="/list.do" />'>목록</a>
        <%-- TodoListServlet 으로 이동 --%>
    </div>
</form>
<%@ include file = "../include/footer.jsp"%>

