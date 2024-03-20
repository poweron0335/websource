package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ToDoDao;
import dto.ToDoDto;

@WebServlet("/modify")
public class TodoModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB 연동
        // 한글처리
        req.setCharacterEncoding("utf-8");
        // 제목 클릭 시 no 가져오기
        String no = req.getParameter("no");

        // DB 작업
        ToDoDao dao = new ToDoDao();
        // ToDodto getRow 메서드 받아올 객체 생성
        ToDoDto todo = dao.getRow(no);

        // todo 를 read.jsp 에 보여주기
        // request 와 forward 세트메뉴
        req.setAttribute("todo", todo);

        // todo를 modfiy.jsp 에 보여주기
        // 이동할 곳 지정 (어디로 가서 보여줄 것이냐)
        RequestDispatcher rd = req.getRequestDispatcher("/view/modify.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
