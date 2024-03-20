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

@WebServlet("/create")
public class TodoCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 한글처리
        req.setCharacterEncoding("utf-8");
        // 사용자가 입력한 todo 가져오기
        String title = req.getParameter("title");
        String dscription = req.getParameter("dscription");
        // DB 작업
        ToDoDao dao = new ToDoDao();

        ToDoDto insertDto = new ToDoDto();
        // 사용자의 데이터를 넘긴다.
        insertDto.setTitle(title);
        insertDto.setDscription(dscription);

        // result 에 넘기는 데이터를 담는다.
        int result = dao.insert(insertDto);
        // 화면이동(list) 할 땐 결과를 가져갈 것만 확인
        resp.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
