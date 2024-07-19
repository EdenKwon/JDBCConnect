package NewBoardProgramming.dao;
import JDBCMemberManagement.vo.ConnectionFactory;
import NewBoardProgramming.interfaces.CRUD;
import NewBoardProgramming.vo.Board;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardCRUD implements CRUD {

  private Board board;
  private Connection connection = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;
  int result = 0;

  ArrayList<Board> boardArrayList = new ArrayList<>();

  public Board selectOne(Board board) {

    String query = "SELECT * FROM board WHERE bno = " + board.getBno();
    Board newBoard = new Board();

    try {

      connection = ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      rs = pstmt.executeQuery();

      while (rs.next()) {

        newBoard.setBno(rs.getInt("bno"));
        newBoard.setBtitle(rs.getString("btitle"));
        newBoard.setBcontent(rs.getString("bcontent"));
        newBoard.setBwriter(rs.getString("bwriter"));
        newBoard.setDate(rs.getString("date"));
      }

      pstmt.close();
      connection.close();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return newBoard;
  }

  public List<Board> selectAll() {
    String query = "SELECT bno,bwriter,date,btitle FROM board";

    try {
      connection = ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        Board board = new Board();

        board.setBno(rs.getInt("bno"));
        board.setBtitle(rs.getString("btitle"));
        board.setBwriter(rs.getString("bwriter"));
        board.setDate(rs.getString("date"));

        boardArrayList.add(board);
      }

      pstmt.close();
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return boardArrayList;
  }

  public int create() {
    String query = "INSERT INTO board VALUES(null,?,?,?,?)";

    try {
      connection = BoardProgramming.vo.ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      pstmt.setString(1, board.getBtitle());
      pstmt.setString(2, board.getBcontent());
      pstmt.setString(3, board.getBwriter());
      pstmt.setString(4, board.getDate());

      result = pstmt.executeUpdate();

      pstmt.close();
      connection.close();

      return result;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public int update() {
    String query = "UPDATE board SET btitle = ?, bcontent = ?, bwriter = ? WHERE bno = ?";

    try {
      connection = ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      //업데이트 해야지

      pstmt.close();
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return 0;
  }

  public int clear() {
    String query = "TRUNCATE board";

    connection = BoardProgramming.vo.ConnectionFactory.getInstance().open();

    try {
      connection = BoardProgramming.vo.ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      result = pstmt.executeUpdate();

      pstmt.close();
      connection.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return result;
  }
}
