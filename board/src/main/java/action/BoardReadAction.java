package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardReadAction implements Action {

    private String path;

    public BoardReadAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));

        BoardService service = new BoardServiceImpl();
        BoardDto dto = service.getRow(bno);
        req.setAttribute("dto", dto);

        return new ActionForward(path, false);
    }

}
