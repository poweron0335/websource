package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.BookCreateAction;
import action.BookDeleteAction;
import action.BookListAction;
import action.BookReadAction;
import action.BookUpdateAction;

@WebServlet("*.do")
public class BookControllerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 한글처리
        req.setCharacterEncoding("utf-8");

        // URI 분리작업
        String requestUri = req.getRequestURI();
        String contextPath = req.getContextPath();
        String cmd = requestUri.substring(contextPath.length());

        System.out.println("cmd " + cmd);
        // cmd를 가지고 액션 생성
        Action action = null;
        if (cmd.equals("/list.do")) {

            // 작업이 끝난 후 보여줄 페이지 경로
            action = new BookListAction("/view/list.jsp");

        } else if (cmd.equals("/create.do")) {

            action = new BookCreateAction("list.do");

        } else if (cmd.equals("/read.do")) {
            action = new BookReadAction("/view/read.jsp");
        } else if (cmd.equals("/update.do")) {
            action = new BookUpdateAction("read.do");
        } else if (cmd.equals("/delete.do")) {
            action = new BookDeleteAction("list.do");
        }

        // 생성된 action 에게 일 시키기(서블릿(~pro)이 해야했던 일)
        // ActionForward 로 받아야하기 때문에 af 객체 생성
        ActionForward af = null;

        // action 에서 시킨 일을 af 로 받는다는 의미
        try {
            af = action.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 이동방식과 경로에 따라 움직이기
        if (af.isRedirect()) {
            resp.sendRedirect(af.getPath());
        } else {
            RequestDispatcher rd = req.getRequestDispatcher(af.getPath());
            rd.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
