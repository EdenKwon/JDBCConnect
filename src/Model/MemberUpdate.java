package Model;

import java.awt.geom.RectangularShape;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import vo.ConnectionFactory;
import vo.Member;
import vo.MemberCRUD;

public class MemberUpdate implements MemberCRUD {

  private Member member;
  String pwdQuery = "SELECT memberpassword FROM member WHERE memberid = ?"; //
  String query = "UPDATE member SET memberpassword = ? WHERE memberid = ?";

  Connection connection = null;
  PreparedStatement pstmt = null;
  ResultSet rs = null;
  int result = 0;

  public MemberUpdate(Member member) {
    this.member = member;
  }

  @Override
  public void execute() {
    try {
      connection = ConnectionFactory.getInstance().open();

      if (checkPassword()) {
        updatePassword();
      } else {
        System.out.println("비밀번호가 일치하지 않습니다. 다시 시도해주세요.");
      }

      connection.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private boolean checkPassword() {
    try {
      pstmt = connection.prepareStatement(pwdQuery);
      pstmt.setString(1, member.getmemberId());
      rs = pstmt.executeQuery();

      if (rs.next()) {
        String currentPwd = rs.getString("memberpassword");
        rs.close();
        pstmt.close();
        return currentPwd.equals(member.getMemberPassword());
      } else {
        rs.close();
        pstmt.close();
        System.out.println("해당 멤버를 찾을 수 없습니다.");
        return false;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void updatePassword() {
    try {
      pstmt = connection.prepareStatement(query);
      pstmt.setString(1, member.getNewPassword());
      pstmt.setString(2, member.getmemberId());

      int result = pstmt.executeUpdate();
      if (result == 1) {
        System.out.println("해당 멤버의 비밀번호가 변경되었습니다.");
      } else {
        System.out.println("해당 멤버의 비밀번호 변경에 실패했어요. 다시 시도해주세요.");
      }

      pstmt.close();
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
