package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import vo.ConnectionFactory;
import vo.Member;
import vo.MemberCRUD;

public class MemberUpdate implements MemberCRUD {

  private Member member;
  String query = "UPDATE member SET memberpassword = ? WHERE memberid = ?";

  Connection connection = null;
  PreparedStatement pstmt = null;
  int result = 0;

  public MemberUpdate(Member member) {
    this.member = member;
  }

  @Override
  public void execute() {
    try {
      connection = ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      pstmt.setString(1, member.getMemberPassword());
      pstmt.setString(2, member.getmemberId());

      result = pstmt.executeUpdate();
      if (result == 1) {
        System.out.println("회원 정보가 수정되었습니다.");
      } else if (result == 0) {
        System.out.println("회원 정보 수정이 실패하였습니다.");
      }

      pstmt.close();
      connection.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
