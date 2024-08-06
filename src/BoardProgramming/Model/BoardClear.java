package BoardProgramming.Model;

import BoardProgramming.vo.BoardCRUD;
import BoardProgramming.vo.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BoardClear implements BoardCRUD {

  String query = "TRUNCATE board";

  private Connection connection = null;
  private PreparedStatement pstmt = null;
  int result = 0;

  @Override
  public void execute() {
    connection = ConnectionFactory.getInstance().open();

    try {
      connection = ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      result = pstmt.executeUpdate();

      if (result == 0) {
        System.out.println("게시판 비우기에 실패하였습니다.");
      }

      pstmt.close();
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
