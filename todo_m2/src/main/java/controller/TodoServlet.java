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
import action.TodoListAction;
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

        ToDoDao dao = new ToDoDao();
        TodoService service = new TodoServiceImpl();

        Action action = null;
        if (cmd.equals("/list.do")) {
            action = new TodoListAction("/view/list.jsp");

        } else if (cmd.equals("/read.do")) {
            // TodoReadServlet 에서 했던 작업
            String no = req.getParameter("no");
            // DB 작업
            ToDoDto todo = service.getRow(no);
            req.setAttribute("todo", todo);

            // RequestDispatcher rd = req.getRequestDispatcher("/view/read.jsp");
            // rd.forward(req, resp);

        } else if (cmd.equals(("/modify.do"))) {
            // TodoModifyServlet 에서 했던 작업
            String no = req.getParameter("no");
            // DB 작업
            ToDoDto todo = service.getRow(no);
            req.setAttribute("todo", todo);

            // todo를 modfiy.jsp 에 보여주기
            // 이동할 곳 지정 (어디로 가서 보여줄 것이냐)
            // RequestDispatcher rd = req.getRequestDispatcher("/view/modify.jsp");
            // rd.forward(req, resp);

        } else if (cmd.equals("/update.do")) {
            // TodoUpdateServlet 에서 했던 작업
            // value 가 없는 경우 checkbox, radio 의 경우에는 on 값을 가지고 오게 됨
            String completed = req.getParameter("completed");
            String dscription = req.getParameter("dscription");
            String no = req.getParameter("no");

            // DB 작업
            ToDoDto dto = new ToDoDto();

            // boolean 타입의 형변환은 Boolean.parseBoolean() 으로 한다.
            dto.setCompleted(Boolean.parseBoolean(completed));
            dto.setDscription(dscription);
            dto.setNo(Integer.parseInt(no));

            boolean result = service.update(dto);

            // servlet list 경로로 이동
            // resp.sendRedirect("/list.do");

        } else if (cmd.equals("/delete.do")) {
            // TodoDeleteServlet 에서 했던 작업
            String no = req.getParameter("no");

            // DB 작업
            boolean result = service.delete(no);

            // resp.sendRedirect("/list.do");

        } else if (cmd.equals("/create.do")) {
            // TodoCreateServlet 에서 했던 작업
            // 사용자가 입력한 todo 가져오기
            String title = req.getParameter("title");
            String dscription = req.getParameter("dscription");
            // DB 작업
            ToDoDto insertDto = new ToDoDto();
            // 사용자의 데이터를 넘긴다.
            insertDto.setTitle(title);
            insertDto.setDscription(dscription);

            // result 에 넘기는 데이터를 담는다.
            boolean result = service.insert(insertDto);
            // resp.sendRedirect("/list.do");
        }

        ActionForward af = null;

        try {
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
