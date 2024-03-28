package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import dto.PageDto;
import dto.SearchDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardListAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {
        BoardService service = new BoardServiceImpl();

        // BoardService list 호출
        int page = Integer.parseInt(req.getParameter("page"));
        int amount = Integer.parseInt(req.getParameter("amount"));

        String criteria = req.getParameter("criteria");
        String keyword = req.getParameter("keyword");

        SearchDto dto = new SearchDto(page, amount, criteria, keyword);
        PageDto pageDto = new PageDto(dto, service.getRows(criteria, keyword));

        List<BoardDto> list = service.list(dto);

        // req 결과 담기
        req.setAttribute("list", list);
        req.setAttribute("pageDto", pageDto); // pageDto 에 searchDto 가 포함되어 있음

        return new ActionForward(path, false);
    }

}
