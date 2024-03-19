package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dto.ToDoDto;

public class ToDoDao {
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;

    // JDBC 단계
    // 1. 드라이버 로드
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 2. 커넥션 얻기
    public Connection getConnection() {
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "c##test2";
        String password = "test";

        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // 3. sql 작업
    // 전체 조회 - read
    public List<ToDoDto> getList() {
        con = getConnection();
        String sql = "SELECT no, title, create_at, completed FROM todotbl order by no desc";

        List<ToDoDto> list = new ArrayList<>();

        try {
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                ToDoDto dto = new ToDoDto();
                dto.setNo(rs.getInt("no"));
                dto.setTitle(rs.getString("title"));
                dto.setCreate_at(rs.getDate("create_at"));
                dto.setCompleted(rs.getBoolean("completed"));
                list.add(dto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return list;

    }

    // 개별 조회
    public ToDoDto getRow(String no) {

        ToDoDto dto = null;
        con = getConnection();
        String sql = "SELECT * from todotbl where no = ?";

        try {
            pstmt = con.prepareStatement(sql);
            // ? 해결
            pstmt.setInt(1, Integer.parseInt(no));
            rs = pstmt.executeQuery();

            if (rs.next()) {
                dto = new ToDoDto();
                dto.setNo(rs.getInt("no"));
                dto.setTitle(rs.getString("title"));
                dto.setCreate_at(rs.getDate("create_at"));
                dto.setCompleted(rs.getBoolean("completed"));
                dto.setDscription(rs.getString("dscription"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt, rs);
        }
        return dto;

    }

    // 추가 - Create(insert)
    public int insert(ToDoDto insertDto) {

        con = getConnection();
        int result = 0;

        String sql = "INSERT INTO TODOTBL t (NO, title, dscription) VALUES(todo_seq.NEXTVAL, ?, ?)";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, insertDto.getTitle());
            pstmt.setString(2, insertDto.getDscription());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    // 수정
    public int update(ToDoDto updateDto) {

        con = getConnection();
        int result = 0;

        String sql = "UPDATE TODOTBL SET COMPLETED = ?, DSCRIPTION = ? WHERE NO = ?";
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setBoolean(1, updateDto.isCompleted());
            pstmt.setString(2, updateDto.getDscription());
            pstmt.setInt(3, updateDto.getNo());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(con, pstmt);
        }

        return result;
    }

    // 4. 자원 정리
    public void close(Connection con, PreparedStatement pstmt) {
        try {
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (pstmt != null)
                pstmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
