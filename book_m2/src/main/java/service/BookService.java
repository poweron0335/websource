package service;

import java.util.List;

import dto.BookDto;

public interface BookService {
    // DAO CRUD 호출을 위한 추상클래스
    // CRUD = 조회, 검색, 삽입, 삭제, 수정

    // 개별 조회
    BookDto read(int code);

    // 전체 조회
    List<BookDto> listAll();

    // 검색
    List<BookDto> searchListAll(String criteria, String keyword);

    // 삽입
    boolean create(BookDto insertDto);

    // 수정
    boolean update(BookDto updateDto);

    // 삭제
    boolean delete(int code);
}
