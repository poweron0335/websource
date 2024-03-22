package action;

import javax.servlet.http.HttpServletRequest;

import dto.ToDoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoUpdateAction implements Action {

    private String path;

    public TodoUpdateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        TodoService service = new TodoServiceImpl();

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

        // sendRedirect 형식으로 보냈기 때문에 true)
        return new ActionForward(path, true);
    }

}
