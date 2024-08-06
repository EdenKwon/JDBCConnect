package BoardProgramming.Model;

import BoardProgramming.vo.BoardCRUD;
import BoardProgramming.vo.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardUpdate implements BoardCRUD {

  String query = "UPDATE board SET btitle = ?, bcontent = ?, bwriter = ? WHERE bno = ?";

  private Connection connection = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  @Override
  public void execute() {
    try {
      connection = ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      //pstmt.setString(1, );


    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
