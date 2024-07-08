import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import vo.Member;

public class MemberSelect {

  String query = "SELECT * FROM member";

  private Connection con = null;
  private Statement stmt = null;
  private ResultSet rs = null;

  public void execute() {

    System.out.println("전체 멤버를 조회합니다.");

    con = ConnectionFactory.getInstance().open();
    try {
      stmt = con.createStatement();
      rs = stmt.executeQuery(query);

      while (rs.next()) {
        Member member = new Member();

        member.setmemberId(rs.getString("memberid"));
        member.setMemberName(rs.getString("membername"));
        member.setMemberAge(rs.getString("memberage"));

        System.out.println(member);
        System.out.println("전체 멤버 조회를 완료하였습니다.");

        ConnectionFactory.getInstance().close(con);
        stmt.close();
        rs.close();
      }
    } /*catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }*/
    catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
