package service;

import java.util.List;

import dao.ToDoDao;
import dto.ToDoDto;

public class TodoServiceImpl implements TodoService {

    ToDoDao dao = new ToDoDao();

    @Override
    public List<ToDoDto> list() {
        // 호출해서 받은 값 다시 보내준다.
        return dao.getList();
    }

    @Override
    public ToDoDto getRow(String no) {
        return dao.getRow(no);
    }

    @Override
    public boolean insert(ToDoDto insertDto) {
        // 결과가 1이면 true, 아니면 false
        // boolean flag = dao.insert(insertDto) == 1?true:false;
        // return flag;
        return dao.insert(insertDto) == 1;
    }

    @Override
    public boolean update(ToDoDto updateDto) {
        return dao.update(updateDto) == 1;
    }

    @Override
    public boolean delete(String no) {
        return dao.delete(no) == 1;
    }

}
