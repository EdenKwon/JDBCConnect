package NewBoardProgramming.controller;

import NewBoardProgramming.dao.BoardCRUDimpl;
import NewBoardProgramming.dto.Board;
import NewBoardProgramming.exceptions.BoardException;
import NewBoardProgramming.exceptions.ErrorCode;
import NewBoardProgramming.interfaces.BoardCRUD;
import NewBoardProgramming.vo.Messages;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class SubMenu extends PrintBoard {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BoardCRUD boardCRUD = new BoardCRUDimpl();
  Board board;

  public void subMenu_read(Board board) throws IOException, SQLException {
    this.board = board;

    Messages.SUB_MENU.println();
    Messages.MENU_CHOICE.println();
    int num = 0;
    try {
      num = Integer.parseInt(br.readLine());
    } catch (NumberFormatException e) {
      throw new BoardException(ErrorCode.NOT_A_NUMBER);
    }

    switch (num) {
      case 1: //update
        update();
        break;
      case 2: //delete
        delete();
        break;
      case 3: //list
        list();
        break;
      default:
        throw new BoardException(ErrorCode.INVALID_INPUT_VALUE);
    }
  }

  public int subMenu_check() throws IOException {
    int num;
    while (true) {
      Messages.SUB_MENU_CHECK.println();

      try {
        num = Integer.parseInt(br.readLine());
        if (num == 1 || num == 2) {
          return num;
        } else {
          throw new BoardException(ErrorCode.INVALID_INPUT_VALUE);
        }
      } catch (NumberFormatException e) {
        throw new BoardException(ErrorCode.NOT_A_NUMBER);
      }
    }
  }

  public void update() throws IOException, SQLException {
    Messages.INPUT_MODIFY.println();
    Messages.INPUT_TITLE.print();
    board.setBtitle(br.readLine());
    Messages.INPUT_CONTENT.print();
    board.setBcontent(br.readLine());
    Messages.INPUT_WRITER.print();
    board.setBwriter(br.readLine());

    if (subMenu_check() == 1) {
      printResult(boardCRUD.update(board));
    } else {
      Messages.CANCEL.println();
    }

  }

  public void delete() throws SQLException {
    printResult(boardCRUD.delete(board));
  }

  public void list() throws SQLException {
    printBoardList(boardCRUD.selectAll());
  }
}
