package NewBoardProgramming.interfaces;

import NewBoardProgramming.vo.Board;
import java.util.List;

public interface CRUD {

  Board selectOne(Board board);

  List<Board> selectAll();

  int create();

  int update();

  int clear();
}
