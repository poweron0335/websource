package member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 가져오는 데이터 한글 처리
        req.setCharacterEncoding("utf-8");

        // 사용자가 전송한 데이터 가져오기
        String userId = req.getParameter("userId");
        String password = req.getParameter("password");
        String name = req.getParameter("name");

        // 사용자가 가져온 데이터를 MemberDTO 객체에 담음
        // DB 작업완료 후 담긴 객체
        MemberDTO dto = new MemberDTO(userId, password, name);
        // 세션 담기
        HttpSession session = req.getSession();
        session.setAttribute("loginDto", dto);

        // 페이지 이동
        // 세션에 담으면 sendRedirect 는 무조건 따라오는 세트
        resp.sendRedirect("/index.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
