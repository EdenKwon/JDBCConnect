package BoardProgramming;

import BoardProgramming.Model.BoardDelete;
import BoardProgramming.Model.BoardUpdate;
import BoardProgramming.vo.BoardCRUD;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubMenu {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  SubMenu sMenu = new SubMenu();
  BoardCRUD boardCRUD;

  public void subMenu() {
    System.out.println("보조 메뉴 : 1.Update | 2.Delete | 3.List");
    System.out.print("메뉴 선택 : ");
    int num = 0;
    try {
      num = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    switch (num) {
      case 1:
        sMenu.update();
        break;
      case 2:
        sMenu.delete();
        break;
      case 3:
        new BoardExample();
        break;
      default:
        System.out.println("잘못 입력하셨습니다.");
        subMenu();
        break;
    }
  }

  public void update() {
    boardCRUD = new BoardUpdate(); //삭제 정보 받아야함
    boardCRUD.execute();
  }

  public void delete() {
    boardCRUD = new BoardDelete(); //삭제 정보 받아야함
    boardCRUD.execute();
  }

  public static boolean doubleCheck() {
    System.out.println("보조 메뉴 : 1. OK | 2. Cancel");
    int num = 0;

    try {
      num = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    switch (num) {
      case 1 : return true;
      case 2 : return false;
      default:
        System.out.println("다시 시도해주세요.");
        doubleCheck();
    }

    return false;
  }
}
