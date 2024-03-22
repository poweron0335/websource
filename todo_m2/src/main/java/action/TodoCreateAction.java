package action;

import javax.servlet.http.HttpServletRequest;

import dto.ToDoDto;
import service.TodoService;
import service.TodoServiceImpl;

public class TodoCreateAction implements Action {

    private String path;

    public TodoCreateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        TodoService service = new TodoServiceImpl();

        String title = req.getParameter("title");
        String dscription = req.getParameter("dscription");
        // DB 작업
        ToDoDto insertDto = new ToDoDto();
        // 사용자의 데이터를 넘긴다.
        insertDto.setTitle(title);
        insertDto.setDscription(dscription);

        // result 에 넘기는 데이터를 담는다.
        boolean result = service.insert(insertDto);

        return new ActionForward(path, true);
    }

}
