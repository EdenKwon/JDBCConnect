package NewBoardProgramming.controller;

import NewBoardProgramming.dao.BoardCRUDimpl;
import NewBoardProgramming.interfaces.BoardCRUD;
import NewBoardProgramming.dto.Board;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu extends PrintBoard {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  BoardCRUD boardCRUD = new BoardCRUDimpl();
  Board board;
  SubMenu subMenu;

  public void list() {
    System.out.println("[게시물 목록]");
    System.out.println("--------------------------------------------");
    System.out.println("no\twriter\tdate\t\ttitle");
    System.out.println("--------------------------------------------");

    printBoardList(boardCRUD.selectAll());

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
          try {
            create();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }

          break;
        case 2: //read
          try {
            read();
          } catch (IOException e) {
            throw new RuntimeException(e);
          }
          break;
        case 3: //clear
          clear();
          break;
        case 4: //exit
          exit();
        default:
          System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
      }
    }
  }

  public void create() throws IOException {
    board = new Board();

    System.out.println("[새 게시물 입력]");
    System.out.print("제목 : ");
    board.setBtitle(br.readLine());
    System.out.println("내용 : ");
    board.setBcontent(br.readLine());
    System.out.print("작성자 : ");
    board.setBwriter(br.readLine());
    board.setDate("2021-07-07");//하드 코딩 수정 예정

    //
    printResult(boardCRUD.create(board));
  }

  public void read() throws IOException {
    System.out.print("bno : ");
    int num = Integer.parseInt(br.readLine());

    board = boardCRUD.selectOne(num);
    printBoard(board);

    subMenu = new SubMenu();
    subMenu.subMenu_read(board);
  }

  public void clear() {
    boardCRUD.clear();
  }

  public void exit() {
    System.out.println("프로그램을 종료합니다.");
    System.exit(0);
  }
}
