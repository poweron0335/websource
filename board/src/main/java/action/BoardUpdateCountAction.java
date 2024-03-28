package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardUpdateCountAction implements Action {

    private String path;

    public BoardUpdateCountAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));

        BoardService service = new BoardServiceImpl();
        // 조회수 업데이트
        service.updateCount(bno);

        path += "?bno=" + bno;

        return new ActionForward(path, true);
    }

}
