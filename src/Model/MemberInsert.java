package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import vo.ConnectionFactory;
import vo.Member;
import vo.MemberCRUD;

public class MemberInsert implements MemberCRUD {

  private Member member;

  String query = "INSERT INTO member VALUES(?,?,?,?)";
  Connection connection = null;
  PreparedStatement pstmt = null;
  int result = 0;

  public MemberInsert(Member member) {
    this.member = member;
  }

  @Override
  public void execute() {
    try {
      connection = ConnectionFactory.getInstance().open();
      pstmt = connection.prepareStatement(query);
      pstmt.setString(1, member.getmemberId());
      pstmt.setString(2, member.getMemberName());
      pstmt.setString(3, member.getMemberPassword());
      pstmt.setInt(4, member.getMemberAge());

      result = pstmt.executeUpdate();
      if (result == 1) {
        System.out.println("회원 정보가 입력되었습니다.");
      } else if (result == 0) {
        System.out.println("회원 정보 입력이 실패하였습니다.");
      }

      pstmt.close();
      connection.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
