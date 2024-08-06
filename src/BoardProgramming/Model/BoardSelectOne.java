package BoardProgramming.Model;


import BoardProgramming.vo.Board;
import BoardProgramming.vo.BoardCRUD;
import JDBCMemberManagement.vo.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class BoardSelectOne implements BoardCRUD {

  private int bno;

  public BoardSelectOne(int bno) {
    this.bno = bno;
  }

  private Connection connection = null;
  private Statement stmt = null;
  private ResultSet rs = null;

  public void execute() {

    try {
      String query = "SELECT * FROM board WHERE bno = " + bno;
      connection = ConnectionFactory.getInstance().open();
      stmt = connection.createStatement();
      rs = stmt.executeQuery(query);

      while (rs.next()) {
        Board board = new Board();

        board.setBno(rs.getInt("bno"));
        board.setBtitle(rs.getString("btitle"));
        board.setBcontent(rs.getString("bcontent"));
        board.setBwriter(rs.getString("bwriter"));
        board.setDate(rs.getString("date"));

        System.out.println(board);
        //보드 형식에 맞게 출력 해야함
      }

      ConnectionFactory.getInstance().close(connection);
      stmt.close();
      rs.close();
    } /*catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }*/ catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
