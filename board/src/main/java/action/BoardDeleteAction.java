package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardDeleteAction implements Action {

    private String path;

    public BoardDeleteAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        int bno = Integer.parseInt(req.getParameter("bno"));
        String password = req.getParameter("password");

        BoardDto dto = new BoardDto();

        dto.setPassword(password);
        dto.setBno(bno);

        BoardService service = new BoardServiceImpl();

        if (!service.delete(dto)) {
            path = "/view/qna_board_pwdCheck.jsp?bno=" + dto.getBno();
        }
        return new ActionForward(path, true);
    }

}
