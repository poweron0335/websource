package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import dto.SearchDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardSearchAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        SearchDto dto = new SearchDto();

        dto.setCriteria(req.getParameter("criteria"));
        dto.setKeyword(req.getParameter("keyword"));

        // BoardService list 호출
        BoardService service = new BoardServiceImpl();
        List<BoardDto> list = service.getSearchList(dto);

        // req 결과 담기
        req.setAttribute("list", list);
        req.setAttribute("search", dto);

        return new ActionForward(path, false);
    }

}
