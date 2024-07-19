package NewBoardProgramming.controller;

import NewBoardProgramming.dao.BoardCRUD;
import NewBoardProgramming.vo.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BoardCRUD boardCRUD;
  Board board;

  public void list() {
    System.out.println("[게시물 목록]");
    System.out.println("--------------------------------------------");
    System.out.println("no\twriter\tdate\t\ttitle");
    System.out.println("--------------------------------------------");

    PrintBoard.getInstance().printBoardList(boardCRUD.selectAll());

    System.out.println();
    System.out.println("--------------------------------------------");

    mainMenu();
  }

  public void mainMenu() {
    while (true) {
      System.out.println("메인 메뉴 : 1.Create | 2.Read | 3.Clear | 4.Exit");
      System.out.print("메뉴 선택 : ");

      int num = 0;
      try {
        num = Integer.parseInt(br.readLine());
      } catch (IOException e) {
        e.printStackTrace();
      }

      switch (num) {
        case 1: //create
          PrintBoard.getInstance().printResult(boardCRUD.create());
          break;
        case 2: //read
          readBno();
          PrintBoard.getInstance().printBoard(boardCRUD.selectOne(board));
          SubMenu.subMenu();
          break;
        case 3: //clear
          board = readBno();
          PrintBoard.getInstance().printResult(boardCRUD.clear());
          break;
        case 4: //exit
          System.exit(0);
          break;
        default:
          System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
      }
    }
  }

  public Board readBno() {
    System.out.print("bno : ");
    int num;

    try {
      num = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    board.setBno(num);
    return board;
  }


}
