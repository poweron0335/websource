package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ToDoDao;

@WebServlet("/delete")
public class TodoDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 한글처리
        req.setCharacterEncoding("utf-8");
        // no 가져오기 (a 태그 주소창 확인)
        String no = req.getParameter("no");

        // DB 작업
        ToDoDao dao = new ToDoDao();

        int result = dao.delete(no);

        // 화면이동(list)
        // 아무것도 담지 않았다면 sendRedirect(간단한 페이지 이동이기 때문에)
        resp.sendRedirect("list");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
