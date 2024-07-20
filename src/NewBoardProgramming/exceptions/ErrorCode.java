package NewBoardProgramming.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  BOARD_NOT_FOUND(404, "해당 게시물이 없습니다.", "--"),
  INVALID_INPUT_VALUE(400, "잘못 입력하셨습니다. 다시 입력해주세요.", "--"),
  NOT_A_NUMBER(400, "숫자만 입력해주세요.", "--");

  private int status;
  private String message;
  private String code;

}
