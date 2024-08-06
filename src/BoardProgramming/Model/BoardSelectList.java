package BoardProgramming.Model;


import BoardProgramming.vo.Board;
import BoardProgramming.vo.BoardCRUD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import JDBCMemberManagement.vo.ConnectionFactory;
import java.util.ArrayList;

public class BoardSelectList implements BoardCRUD {

  public BoardSelectList() {
  }

  ArrayList<Board> boardArrayList = new ArrayList<>();
  String query = "SELECT bno,bwriter,date,btitle FROM board";

  private Connection connection = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  public void execute() {

    connection = ConnectionFactory.getInstance().open();
    try {
      pstmt = connection.prepareStatement(query);

      rs = pstmt.executeQuery(query);

      while (rs.next()) {
        Board board = new Board();

        board.setBno(rs.getInt("bno"));
        board.setBtitle(rs.getString("btitle"));
        board.setBwriter(rs.getString("bwriter"));
        board.setDate(rs.getString("date"));

        boardArrayList.add(board);
        //리스트 출력 해야함
      }

      ConnectionFactory.getInstance().close(connection);
      pstmt.close();
      rs.close();
    } /*catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }*/ catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
