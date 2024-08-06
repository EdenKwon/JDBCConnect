package NewBoardProgramming.exceptions;

public class BoardExceptionList {

  public static boolean isBoardExist(int bno) {
    if (bno < 1) {
      return false;
    }
    return true;
  }
}
