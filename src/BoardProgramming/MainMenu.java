package BoardProgramming;

import BoardProgramming.Model.BoardClear;
import BoardProgramming.Model.BoardCreate;
import BoardProgramming.Model.BoardSelectList;
import BoardProgramming.Model.BoardSelectOne;
import BoardProgramming.vo.Board;
import BoardProgramming.vo.BoardCRUD;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class MainMenu {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BoardCRUD boardCRUD;

  public void list() {
    System.out.println("[게시물 목록]");
    System.out.println("--------------------------------------------");
    System.out.println("no\twriter\tdate\t\ttitle");
    System.out.println("--------------------------------------------");

    boardCRUD = new BoardSelectList();
    boardCRUD.execute();

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
        case 1:
          create();
          break;
        case 2:
          read();
          break;
        case 3:
          clear();
          break;
        case 4:
          exit();
          break;
        default:
          System.out.println("잘못 입력하셨습니다.");
          mainMenu();
          break;
      }
    }
  }

  public void create() {
    System.out.println("[새 게시물 입력]");

    String bTitle;
    String bContent;
    String bWriter;

    try {
      System.out.print("제목 : ");
      bTitle = br.readLine();
      System.out.print("내용 : ");
      bContent = br.readLine();
      System.out.print("작성자 : ");
      bWriter = br.readLine();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    boardCRUD = new BoardCreate(new Board(bTitle, bContent, bWriter, "2024.07.19")); //date 하드코딩 수정
    boardCRUD.execute();
  }

  public void read() {
    System.out.println("[게시물 읽기]");
    System.out.print("bno : ");
    int bNo = 0;
    try {
      bNo = Integer.parseInt(br.readLine());
    } catch (IOException e) {
      e.printStackTrace();
    }

    BoardCRUD boardCRUD = new BoardSelectOne(bNo);
    boardCRUD.execute();

    SubMenu subMenu = new SubMenu();
    subMenu.subMenu();
  }

  public void clear() {
    System.out.println("[게시물 전체 삭제]");
    if(SubMenu.doubleCheck()) {
      boardCRUD = new BoardClear();
      boardCRUD.execute();
    }
  }

  public void exit() {
    System.out.println(" ** 게시판 종료 ** ");
    System.exit(0);
  }
}
