package BoardProgramming.Model;


import BoardProgramming.vo.Board;
import BoardProgramming.vo.BoardCRUD;
import BoardProgramming.vo.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;


public class BoardCreate implements BoardCRUD {

  private Board board;

  String query = "INSERT INTO board VALUES(null,?,?,?,?)";
  Connection connection = null;
  PreparedStatement pstmt = null;
  int result = 0;

  public BoardCreate(Board board) {
    this.board = board ;
  }

  @Override
  public void execute() {
    try {
      connection = ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      pstmt.setString(1, board.getBtitle());
      pstmt.setString(2, board.getBcontent());
      pstmt.setString(3, board.getBwriter());
      pstmt.setString(4, board.getDate());

      result = pstmt.executeUpdate();
      if (result == 1) {
        //System.out.println("게시판에 등록되었습니다.");
      } else if (result == 0) {
        System.out.println("게시판 입력에 실패하였습니다.");
      }

      pstmt.close();
      connection.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

