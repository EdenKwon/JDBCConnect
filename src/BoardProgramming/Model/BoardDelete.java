package BoardProgramming.Model;

import BoardProgramming.vo.BoardCRUD;
import JDBCMemberManagement.vo.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BoardDelete implements BoardCRUD {

  private int bno;

  private Connection connection = null;
  private Statement stmt = null;
  int result = 0;

  @Override
  public void execute() {

    String query = "DELETE FROM board WHERE bno = " + bno;
    connection = ConnectionFactory.getInstance().open();
    try {
      stmt = connection.prepareStatement(query);
      result = stmt.executeUpdate(query);

      if (result == 1) {
        System.out.println("삭제가 완료되었습니다.");
      } else if (result == 0) {
        System.out.println("삭제에 실패하였습니다.");
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
