package NewBoardProgramming.controller;

import NewBoardProgramming.dto.Board;
import NewBoardProgramming.vo.Messages;
import java.util.List;

public class PrintBoard {

  //list 출력 하는 경우, 수행 결과 int, Board 한 개
  public void printResult(int result) {
    switch (result) {
      case 1 :
        Messages.SUCCESS.println();
        break;
      case 0 :
        Messages.TRY_AGAIN.println();
        break;
      default:
        //?
        break;
    }
  }

  public void printBoardList(List<Board> boardList) {
    for(Board board : boardList) {
      System.out.println(
          board.getBno() + "\t" + board.getBwriter() + "\t"
          +board.getDate() + " \t" + board.getBtitle()
      );
    }
  }

  public void printBoard(Board board) {
    System.out.println(Messages.INPUT_BNO.getMessage() + board.getBno());
    System.out.println(Messages.INPUT_TITLE + board.getBtitle());
    System.out.println(Messages.INPUT_CONTENT + board.getBcontent());
    System.out.println(Messages.INPUT_WRITER + board.getBwriter());
    System.out.println(Messages.INPUT_DATE + board.getDate());
  }
}
