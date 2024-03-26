package action;

import java.io.File;
import java.util.UUID;

import javax.print.attribute.standard.Fidelity;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import dto.BoardDto;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;

@AllArgsConstructor
public class BoardWriteAction implements Action {

    private String path;

    @Override
    public ActionForward execute(HttpServletRequest req) throws Exception {

        BoardDto insertDto = new BoardDto();

        insertDto.setName(req.getParameter("name"));
        insertDto.setTitle(req.getParameter("title"));
        insertDto.setContent(req.getParameter("content"));
        insertDto.setPassword(req.getParameter("password"));
        insertDto.setAttach(req.getParameter("attach"));

        // 업로드 처리
        Part part = req.getPart("attach");
        String fileName = getFilename(part);

        String saveDir = "c:\\upload";

        if (!fileName.isEmpty()) {

            // 중복파일명은 저장을 해주지 않음 = 서버에 저장 시 다른 이름 사용
            // 고유한 값 생성 => 고유한 값_사용자가 올린 파일명
            UUID uuid = UUID.randomUUID();
            // File.separator : 역슬래쉬
            File uploadFile = new File(saveDir + File.separator + uuid + "_" + fileName);

            // c:\\upload\\filename
            part.write(uploadFile.toString()); // 서버의 디스크에 파일 저장
            insertDto.setAttach(uploadFile.toString());
        }

        System.out.println(insertDto);

        BoardService service = new BoardServiceImpl();

        if (!service.insert(insertDto)) {
            path = "/view/qna_board_write.jsp";
        }

        return new ActionForward(path, true);
    }

    private String getFilename(Part part) {
        // Content-Disposition: attachment; filename="filename.jpg"
        String header = part.getHeader("content-disposition");
        String[] arr = header.split(";");
        // ";" 를 기준으로 header 를 자르기
        for (int i = 0; i < arr.length; i++) {
            String temp = arr[i];
            // 파일 네임만 추출
            if (temp.trim().startsWith("filename")) {
                return temp.substring(temp.indexOf("=") + 2, temp.length() - 1);

            }
        }
        return "";
    }

}
