package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dto.BookDto;

@WebServlet("/modify")
public class BookModifyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String code = req.getParameter("code");
        String price = req.getParameter("price");

        BookDao dao = new BookDao();
        BookDto dto = new BookDto();

        dto.setCode(Integer.parseInt(code));
        dto.setPrice(Integer.parseInt(price));

        int result = dao.update(dto);

        // 수정 성공시 list
        if (result > 0) {
            resp.sendRedirect("/list");
        } else {
            resp.sendRedirect("/view/modify.jsp");
        }
        // 실패시 modify.jsp

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
