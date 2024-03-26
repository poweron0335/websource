package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import dto.MemberDto;
import service.BookService;
import service.BookServiceImpl;

public class BookLeaveAction implements Action {

    private String path;

    public BookLeaveAction(String string) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        MemberDto deldDto = new MemberDto();
        deldDto.setUserid(req.getParameter("userid"));
        deldDto.setPassword(req.getParameter("password"));

        BookService service = new BookServiceImpl();

        if (service.leave(deldDto)) {
            // 탈퇴 시 기존 세션 제거
            HttpSession session = req.getSession();
            session.invalidate();
        } else {
            path = "/view/leave.jsp";
        }

        return new ActionForward(path, true);

    }

}
