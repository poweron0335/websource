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

@WebServlet("/update")
public class TodoUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // DB 연동
        // 한글처리
        req.setCharacterEncoding("utf-8");

        // value 가 없는 경우 checkbox, radio 의 경우에는 on 값을 가지고 오게 됨
        String completed = req.getParameter("completed");
        String dscription = req.getParameter("dscription");
        String no = req.getParameter("no");

        // DB 작업
        ToDoDao dao = new ToDoDao();

        ToDoDto dto = new ToDoDto();

        // boolean 타입의 형변환은 Boolean.parseBoolean() 으로 한다.
        dto.setCompleted(Boolean.parseBoolean(completed));
        dto.setDscription(dscription);
        dto.setNo(Integer.parseInt(no));

        int result = dao.update(dto);

        // servlet list 경로로 이동
        resp.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
