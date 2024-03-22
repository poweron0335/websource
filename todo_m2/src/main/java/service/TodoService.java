package service;

import java.util.List;

import dto.ToDoDto;

// DAO 의 CRUD 메소드를 호출하는 곳

public interface TodoService {
    List<ToDoDto> list();

    ToDoDto getRow(String no);

    boolean insert(ToDoDto insertDto);

    boolean update(ToDoDto updateDto);

    boolean delete(String no);

}
