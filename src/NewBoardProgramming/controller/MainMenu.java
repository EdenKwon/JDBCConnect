package NewBoardProgramming.controller;

import NewBoardProgramming.dao.BoardCRUDimpl;
import NewBoardProgramming.exceptions.BoardException;
import NewBoardProgramming.exceptions.BoardExceptionList;
import NewBoardProgramming.exceptions.ErrorCode;
import NewBoardProgramming.interfaces.BoardCRUD;
import NewBoardProgramming.dto.Board;
import NewBoardProgramming.vo.Messages;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class MainMenu extends PrintBoard {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BoardCRUD boardCRUD = new BoardCRUDimpl();
  Board board;
  SubMenu subMenu;

  public void list() throws SQLException, IOException {
    Messages.BOARD_LIST.println();
    Messages.BOARD_LIST_DIVIDER.println();
    Messages.BOARD_LIST_HEADER.println();
    Messages.BOARD_LIST_DIVIDER.println();
    printBoardList(boardCRUD.selectAll());
    Messages.NEXTLINE.print();
    Messages.BOARD_LIST_DIVIDER.println();

    mainMenu();
  }

  public void mainMenu() throws SQLException, IOException {
    while (true) {
      Messages.MAIN_MENU.println();
      Messages.MENU_CHOICE.print();

      int num = 0;
      try {
        num = Integer.parseInt(br.readLine());
      } catch (NumberFormatException e) {
        System.out.println(ErrorCode.NOT_A_NUMBER.getMessage());
        continue;
      }

      try {
        switch (num) {
          case 1: //create
            create();
            break;
          case 2: //read
            read();
            break;
          case 3: //clear
            clear();
            break;
          case 4: //exit
            exit();
          default:
            throw new BoardException(ErrorCode.INVALID_INPUT_VALUE);
        }
      } catch (BoardException e) {
        //
      }
    }
  }

  public void create() throws IOException, SQLException {
    board = new Board();

    Messages.INPUT_LIST.println();
    Messages.INPUT_TITLE.print();
    board.setBtitle(br.readLine());
    Messages.INPUT_CONTENT.print();
    board.setBcontent(br.readLine());
    Messages.INPUT_WRITER.print();
    board.setBwriter(br.readLine());
    board.setDate("2021-07-07");//하드 코딩 수정 예정

    //
    printResult(boardCRUD.create(board));
  }

  public void read() throws IOException, SQLException {
    System.out.print("bno : ");
    int num = 0;
    try {
      num = Integer.parseInt(br.readLine());
    } catch (NumberFormatException e) {
      System.out.println(ErrorCode.NOT_A_NUMBER.getMessage());
      return;
    }

    board = boardCRUD.selectOne(num);
    if (!BoardExceptionList.isBoardExist(board.getBno())) {
      throw new BoardException(ErrorCode.BOARD_NOT_FOUND);
    }

    printBoard(board);

    subMenu = new SubMenu();
    subMenu.subMenu_read(board);
  }

  public void clear() throws SQLException {
    boardCRUD.clear();
  }

  public void exit() {
    Messages.EXIT.println();
    System.exit(0);
  }
}
