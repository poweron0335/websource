<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%@ include file = "../include/header.jsp"%>

<%-- insert 구문이 어떻게 들어왔는지 보고 화면단 생성 --%>
<h1 class="mt-5">Todo Create</h1>
<form action='<c:url value="/create" />' method="post">
    <div class="mb-3">
        <label for="title" class="form-label">title</label>
        <input type="text" class="form-control" id="title" placeholder="title" name="title">
    </div>
    <div class="mb-3">
        <label for="dscription" class="form-label">dscription</label>
        <textarea class="form-control" id="dscription" rows="3" name="dscription"></textarea>
    </div>
    <div>
        <button class="btn btn-primary">저장</button>
    </div>
</form>
<%@ include file = "../include/footer.jsp"%>

