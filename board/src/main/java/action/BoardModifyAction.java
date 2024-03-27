package action;

import javax.servlet.http.HttpServletRequest;

import dto.BoardDto;
import service.BoardService;
import service.BoardServiceImpl;

public class BoardModifyAction implements Action {

    private String path;

    public BoardModifyAction(String path) {
        this.path = path;
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        // 수정작업
        BoardDto updateDto = new BoardDto();
        // NumberFormatException : Cannot parse null string
        updateDto.setBno(Integer.parseInt(req.getParameter("bno")));
        updateDto.setTitle(req.getParameter("title"));
        updateDto.setContent(req.getParameter("content"));
        updateDto.setPassword(req.getParameter("password"));

        // 비밀번호가 일치하면 수정완료
        BoardService service = new BoardServiceImpl();

        if (!service.update(updateDto)) {
            // 수정 실패시 수정화면으로 되돌아가기
            // jsp 파일이 연결된 곳이 qModify 이기 때문에 거기로 이동함.
            // readAction 에서 bno 를 가져오라는 구문이 있기 때문에 ?bno 도 붙음
            path = "/qModfiy.do?bno=" + updateDto.getBno();
        } else {
            // /qRead.do
            path += "?bno=" + updateDto.getBno();
        }

        return new ActionForward(path, true);
    }

}
