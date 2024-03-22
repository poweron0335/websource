package action;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookReadAction implements Action {

    private String path;

    public BookReadAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        BookService service = new BookServiceImpl();

        // code 가져오기

        int code = Integer.parseInt(req.getParameter("code"));

        // 서비스 read()
        BookDto dto = service.read(code);
        req.setAttribute("dto", dto);

        return new ActionForward(path, false);
    }

}
