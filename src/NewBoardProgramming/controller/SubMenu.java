package NewBoardProgramming.controller;

import BoardProgramming.BoardExample;
import NewBoardProgramming.dao.BoardCRUD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubMenu {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BoardCRUD boardCRUD;

  public static void subMenu() {
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
        PrintBoard.getInstance().printResult(boardCRUD.update());
        break;
      case 2: //delete
        PrintBoard.getInstance().printResult(boardCRUD.clear());
        break;
      case 3: //list
        PrintBoard.getInstance().printBoardList(boardCRUD.selectAll());
        break;
      default:
        System.out.println("잘못 입력하셨습니다.");
        break;
    }
  }
}
