package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardReplyAction implements Action {

    private String path;

    public BoardReplyAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        String name = req.getParameter("name");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String password = req.getParameter("password");

        // 부모정보
        int bno = Integer.parseInt(req.getParameter("bno"));
        int reRef = Integer.parseInt(req.getParameter("reRef"));
        int reSeq = Integer.parseInt(req.getParameter("reSeq"));
        int reLev = Integer.parseInt(req.getParameter("reLev"));

        BoardDto replyDto = new BoardDto();

        replyDto.setBno(bno);
        replyDto.setName(name);
        replyDto.setTitle(title);
        replyDto.setContent(content);
        replyDto.setPassword(password);
        replyDto.setReRef(reRef);
        replyDto.setReSeq(reSeq);
        replyDto.setReLev(reLev);

        BoardService service = new BoardServiceImpl();

        // 실패시 댓글화면 보여주기
        if (!service.reply(replyDto)) {
            path = "/qReplyView.do?bno=" + replyDto.getBno();
        }

        return new ActionForward(path, true);
    }

}
