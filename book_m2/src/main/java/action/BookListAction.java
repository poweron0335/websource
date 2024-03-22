package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookListAction implements Action {
    private String path;

    public BookListAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        BookService service = new BookServiceImpl();

        // service listAll() 호출
        List<BookDto> list = service.listAll();
        // 결과 request 에 담기
        req.setAttribute("list", list);

        return new ActionForward(path, false);
    }

}
