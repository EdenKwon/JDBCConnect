package NewBoardProgramming.exceptions;

public class BoardException extends RuntimeException{

    private ErrorCode errorCode;

    public BoardException(ErrorCode codes) {
      this.errorCode = codes;
      System.out.println(errorCode.getMessage());
    }
}
