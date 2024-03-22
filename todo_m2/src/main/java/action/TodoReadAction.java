package action;

import javax.servlet.http.HttpServletRequest;

import dto.ToDoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoReadAction implements Action {

    private String path;

    public TodoReadAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        TodoService service = new TodoServiceImpl();

        String no = req.getParameter("no");
        ToDoDto todo = service.getRow(no);
        req.setAttribute("todo", todo);

        // Action 에서 보내는 형식이 req.setAttribute 면 false
        return new ActionForward(path, false);
    }

}
