package action;

import javax.servlet.http.HttpServletRequest;

import dao.BookDao;
import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookCreateAction implements Action {

    private String path;

    public BookCreateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        BookService service = new BookServiceImpl();

        // 도서추가 화면에서 넘어오는 데이터 가져오기
        int code = Integer.parseInt(req.getParameter("code"));
        String title = req.getParameter("title");
        String writer = req.getParameter("writer");
        int price = Integer.parseInt(req.getParameter("price"));
        String description = req.getParameter("description");
        BookDto insertDto = new BookDto(code, title, writer, price, description);

        // 서비스 호출 create
        boolean result = service.create(insertDto);

        return new ActionForward(path, true);
    }

}
