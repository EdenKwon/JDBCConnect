package BoardProgramming.vo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Board {
  private int bno;
  private String btitle;
  private String bcontent;
  private String bwriter;
  private String date; // Date로 바꿔줘야 함

  public Board(String btitle, String bcontent, String bwriter, String date) {
    this.btitle = btitle;
    this.bcontent = bcontent;
    this.bwriter = bwriter;
    this.date = date;
  }
}
