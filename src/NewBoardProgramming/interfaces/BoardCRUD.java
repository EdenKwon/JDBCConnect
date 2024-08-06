package NewBoardProgramming.interfaces;

import NewBoardProgramming.dto.Board;
import java.sql.SQLException;
import java.util.List;

public interface BoardCRUD {

  int create(Board board) throws SQLException;

  Board selectOne(int bno) throws SQLException;

  List<Board> selectAll() throws SQLException;

  int update(Board board) throws SQLException;

  int delete(Board board) throws SQLException;

  int clear() throws SQLException;
}
