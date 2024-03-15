<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<% 

    request.setCharacterEncoding("utf-8");

    //id, name, age 갖고오기
    String id = request.getParameter("id");
    String name = request.getParameter("name");
    String age = request.getParameter("age");

    // HttpServletRequest : 유효범위가 제한되어 있다.
    // request.getParameter() : 사용자의 입력값을 가지고 올 때 범위가 제한 됨
    // form action 의 값으로 사용된 페이지까지만 가능 ★

    // info.jsp 가 알고 있는 값(사용자 입력값, db값)을 다른 페이지랑 공유
    // 1) get / post 방식으로 넘겨준다.
    // 2) scope 이용
    //    (1) page : 현재 page(X)
    //    (2) request : HttpServletRequest 의 유효범위
    //    (3) session : HttpSession 의 유효범위(브라우저를 닫기 전까지 유효범위가 살아있다.)
    //    (4) application : 톰캣 서버의 범위(X)
    //    key = 무조건 String
    //    setAttribute("key", 값), getAttribute("key") => scope 전용 메소드

    //    ★★★★★★★★★★★★★★★★★★★★★★★★★★★★ 매 우 중 요
    //    request.setAttribute(), request.getAttribute()
    //    session.setAttribute(), session.getAttribute()    

%>
<%-- <h3>id : <%=id%></h3>
<h3>name : <%=name%></h3>
<h3>age : <%=age%></h3> --%>
<% 
    // request scope 사용해서 값을 담는 방법 
    request.setAttribute("id", id);
    request.setAttribute("name", name);
    request.setAttribute("age", age);

    // forward 없이 request 를 넘기는 값들은 전부 다 null 이 뜸
    // forward
    // 주소가 가르키는 페이지 != 화면에 보여지는 내용 페이지
    // info.jsp 에 부여된 request 를 next.jsp 에 넘겨주는 것
    // info.jsp에서 할 수 있는 작업들을 next.jsp에서 할 수 있게 됨
    pageContext.forward("next.jsp");


    // session scope 사용
    // session.setAttribute("id", id);
    // session.setAttribute("name", name);
    // session.setAttribute("age", age);

%>

    <%-- value : 보낼 값 --%>
    <%-- <form action="next.jsp" method="post">
      <div>
        <label for="id">id</label>
        <input type="text" name="id" id="id" value="<%=id%>" readonly/>
      </div>
      <div>
        <label for="name">name</label>
        <input type="text" name="name" id="name" value="<%=name%>" readonly/>
      </div>
      <div>
        <label for="age">age</label>
        <input type="text" name="age" id="age" value="<%=age%>" readonly/>
      </div>
      <div>
        <button type="submit">전송</button>
      </div>
    </form> --%>

<%-- get 방식을 이용해서 넘겨줌 --%>
<%-- <h3>
    <a href="next.jsp?id=<%=id%>&name=<%=name%>&age=<%=age%>">다음페이지</a>
</h3> --%>
<%-- <h3>
    <a href="next.jsp">다음페이지</a>
</h3> --%>