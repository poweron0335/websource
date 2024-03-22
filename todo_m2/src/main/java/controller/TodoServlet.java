package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.ActionForward;
import action.TodoCreateAction;
import action.TodoDeleteAction;
import action.TodoListAction;
import action.TodoReadAction;
import action.TodoUpdateAction;
import dao.ToDoDao;
import dto.ToDoDto;
import service.TodoService;
import service.TodoServiceImpl;

@WebServlet("*.do")
public class TodoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");

        // 경로에서 요청 찾기
        String requestUri = req.getRequestURI(); // 8080 이후의 값
        String contextPath = req.getContextPath(); // 프로젝트명
        String cmd = requestUri.substring(contextPath.length()); // /create.do 가 남음

        // System.out.println("requestUri " + requestUri);
        // System.out.println("contextPath " + contextPath);
        System.out.println("cmd " + cmd);

        Action action = null;
        if (cmd.equals("/list.do")) {
            action = new TodoListAction("/view/list.jsp");

        } else if (cmd.equals("/read.do")) {
            // TodoReadServlet 에서 했던 작업
            action = new TodoReadAction("/view/read.jsp");

        } else if (cmd.equals(("/modify.do"))) {
            // read 와 modify 는 값을 읽어와서 화면에 보여주는 동일한 작업을 하기 때문에
            // TodoReadAction 를 그대로 가져오고 path 만 다르게 받아주면 됨
            action = new TodoReadAction("/view/modify.jsp");

        } else if (cmd.equals("/update.do")) {

            action = new TodoUpdateAction("list.do");

        } else if (cmd.equals("/delete.do")) {

            action = new TodoDeleteAction("list.do");
            // resp.sendRedirect("/list.do");

        } else if (cmd.equals("/create.do")) {
            // TodoCreateServlet 에서 했던 작업
            // 사용자가 입력한 todo 가져오기
            action = new TodoCreateAction("list.do");
            // resp.sendRedirect("/list.do");
        }

        ActionForward af = null;

        try {
            // action 에서 하는 행동 시키는 구문
            af = action.execute(req);
        } catch (Exception e) {
            e.printStackTrace();
        }

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
