package NewBoardProgramming.vo;

import lombok.Data;

@Data
public class Board {

  private int bno;
  private String btitle;
  private String bcontent;
  private String bwriter;
  private String date; // Date로 바꿔줘야 함
}
