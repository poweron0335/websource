package service;

import java.util.List;

import dto.BoardDto;

public interface BoardService {

    List<BoardDto> list();

    boolean insert(BoardDto insertDto);

    BoardDto getRow(int bno);
}
