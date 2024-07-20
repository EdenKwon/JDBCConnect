package NewBoardProgramming.controller;

import NewBoardProgramming.dto.Board;
import java.util.List;

public class PrintBoard {

  //list 출력 하는 경우, 수행 결과 int, Board 한 개
  public void printResult(int result) {
    switch (result) {
      case 1 :
        System.out.println("완료했습니다.");
        break;
      case 0 :
        System.out.println("다시 시도해주세요.");
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
    System.out.println("번호 : " + board.getBno());
    System.out.println("제목 : " + board.getBtitle());
    System.out.println("내용 : " + board.getBcontent());
    System.out.println("작성자 : " + board.getBwriter());
    System.out.println("날짜 : " + board.getDate());
  }
}
