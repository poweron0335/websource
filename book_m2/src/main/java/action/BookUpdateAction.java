package action;

import javax.servlet.http.HttpServletRequest;

import dto.BookDto;
import service.BookService;
import service.BookServiceImpl;

public class BookUpdateAction implements Action {

    private String path;

    public BookUpdateAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        BookService service = new BookServiceImpl();

        // modify.jsp 넘긴 값 가져오기
        int code = Integer.parseInt(req.getParameter("code"));
        int price = Integer.parseInt(req.getParameter("price"));

        BookDto updateDto = new BookDto();

        updateDto.setCode(code);
        updateDto.setPrice(price);
        // 서비스 update

        boolean result = service.update(updateDto);

        // 수정되면
        if (result) {
            // 수정 내용 보여주기 read.do
            // path 로 받아오는 값이 read.do 이기 때문에 updateDto 객체의 getCode 메서드를 사용하여 code 값을 가져옴
            path += "?code=" + updateDto.getCode();

            // 수정이 안되면
        } else {
            // path 값이 read.do 이기 때문에 수정 화면을 보여주는 /view/modfiy.jsp 를 출력
            path = "/view/modify.jsp";
        }
        return new ActionForward(path, false);
    }

    // 사용자 입력 값으로 담을 수 없는 이유는 사용자 입력 값이 정확하지 않기 때문이다.

    // BookDto read = service.read(code);
    // req.setAttribute("result", result);
    // req.setAttribute("read", read);
    // └> 이 방식은 효율적이지 않다.
    // └> 이유는 이미 BookReadAction 에서 read 를 forward 방식으로 보냈기 때문에
    // └> 그걸 이용해서 update 도 보내면 효율적 사용 가능

    // return new ActionForward(path, false)

}
