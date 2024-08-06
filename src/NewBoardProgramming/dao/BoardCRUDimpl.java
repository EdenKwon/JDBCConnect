package NewBoardProgramming.dao;

import NewBoardProgramming.interfaces.BoardCRUD;
import NewBoardProgramming.dto.Board;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardCRUDimpl implements BoardCRUD {

  private Board board;
  private Connection connection = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  ArrayList<Board> boardArrayList = new ArrayList<>();

  public int create(Board board) throws SQLException {
    String query = "INSERT INTO board VALUES(null,?,?,?,?)";
    int result = 0;

    connection = ConnectionFactory.getInstance().open();
    pstmt = connection.prepareStatement(query);
    pstmt.setString(1, board.getBtitle());
    pstmt.setString(2, board.getBcontent());
    pstmt.setString(3, board.getBwriter());
    pstmt.setString(4, board.getDate());

    result = pstmt.executeUpdate();

    pstmt.close();
    connection.close();

    return result;

  }

  public Board selectOne(int bno) throws SQLException {

    String query = "SELECT * FROM board WHERE bno = " + bno;
    Board newBoard = new Board();

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

    return newBoard;
  }

  public List<Board> selectAll() throws SQLException {
    String query = "SELECT bno,bwriter,date,btitle FROM board";

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

    return boardArrayList;
  }

  public int update(Board board) throws SQLException {
    String query = "UPDATE board SET btitle = ?, bcontent = ?, bwriter = ? WHERE bno = ?";
    int result = 0;

    connection = ConnectionFactory.getInstance().open();
    pstmt = connection.prepareStatement(query);

    pstmt.setString(1, board.getBtitle());
    pstmt.setString(2, board.getBcontent());
    pstmt.setString(3, board.getBwriter());
    pstmt.setInt(4, board.getBno());

    result = pstmt.executeUpdate();

    pstmt.close();
    connection.close();

    return result;
  }

  @Override
  public int delete(Board board) throws SQLException {
    String query = "DELETE FROM board WHERE bno = ?";
    int result = 0;

    connection = ConnectionFactory.getInstance().open();
    pstmt = connection.prepareStatement(query);

    pstmt.setInt(1, board.getBno());

    result = pstmt.executeUpdate();

    pstmt.close();
    connection.close();

    return result;
  }

  public int clear() throws SQLException {
    String query = "TRUNCATE board";
    int result = 0;

    connection = ConnectionFactory.getInstance().open();
    pstmt = connection.prepareStatement(query);
    result = pstmt.executeUpdate();

    pstmt.close();
    connection.close();

    return result;
  }
}
