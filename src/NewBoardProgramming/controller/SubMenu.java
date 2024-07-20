package NewBoardProgramming.controller;

import NewBoardProgramming.dao.BoardCRUDimpl;
import NewBoardProgramming.dto.Board;
import NewBoardProgramming.interfaces.BoardCRUD;
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

    System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
    System.out.print("메뉴 선택 : ");
    int num = 0;
    try {
      num = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
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
        System.out.println("잘못 입력하셨습니다.");
        break;
    }
  }

  public int subMenu_check() throws IOException {
    int num;
    while (true) {
      System.out.println("보조 메뉴 : 1.OK | 2. Cancel");

      try {
        num = Integer.parseInt(br.readLine());
        if (num == 1 || num == 2) {
          return num;
        } else {
          System.out.println("잘못 입력하셨습니다.");
        }
      } catch (NumberFormatException e) {
        System.out.println("숫자를 입력해주세요.");
      }
    }
  }

  public void update() throws IOException, SQLException {
    System.out.println("[수정 내용 입력]");
    System.out.print("제목 : ");
    board.setBtitle(br.readLine());
    System.out.print("내용 : ");
    board.setBcontent(br.readLine());
    System.out.print("작성자 : ");
    board.setBwriter(br.readLine());

    if (subMenu_check() == 1) {
      printResult(boardCRUD.update(board));
    } else {
      System.out.println("취소했습니다.");
    }

  }

  public void delete() throws SQLException {
    printResult(boardCRUD.delete(board));
  }

  public void list() throws SQLException {
    printBoardList(boardCRUD.selectAll());
  }
}
