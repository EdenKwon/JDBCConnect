package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import vo.ConnectionFactory;
import vo.Member;
import vo.MemberCRUD;

public class MemberDelete implements MemberCRUD {

  private String memberId;
  String query = "DELETE FROM member WHERE memberid = ?";

  Connection connection = null;
  PreparedStatement pstmt = null;
  int result = 0;

  public MemberDelete(String memberId) {
    this.memberId = memberId;
  }

  @Override
  public void execute() {
    connection = ConnectionFactory.getInstance().open();
    try {
      pstmt = connection.prepareStatement(query);
      pstmt.setString(1, memberId);

      result = pstmt.executeUpdate();
      if (result == 1) {
        System.out.println("회원 정보가 삭제되었습니다.");
      } else if (result == 0) {
        System.out.println("회원 정보 삭제가 실패하였습니다.");
      }

      pstmt.close();
      connection.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
