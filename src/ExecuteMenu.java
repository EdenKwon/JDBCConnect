import Model.*;
import java.io.*;
import vo.Member;
import vo.MemberCRUD;

public class ExecuteMenu {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {
    MemberCRUD memberCRUD;

    while (true) {
      switch (getMenu()) {
        case 1:
          memberCRUD = new MemberSelect();
          memberCRUD.execute();
          break;
        case 2:
          memberCRUD = new MemberInsert(getInsertInfo());
          memberCRUD.execute();
          break;
        case 3:
          memberCRUD = new MemberUpdate(getUpdateInfo());
          memberCRUD.execute();
          break;
        case 4:
          memberCRUD = new MemberDelete(getDeleteInfo());
          memberCRUD.execute();
          break;
        case 5:
          exitMenu();
          break;
        default:
          System.out.println("잘못 입력하셨습니다.");
          break;
      }
    }
  }

  public static int getMenu() throws IOException {
    int num;

    System.out.println("원하시는 메뉴를 선택해주세요.");
    System.out.println("==============================");
    System.out.println("1. 전체 멤버 조회하기");
    System.out.println("2. 멤버 추가하기");
    System.out.println("3. 멤버 비밀번호 변경");
    System.out.println("4. 멤버 삭제하기");
    System.out.println("5. 종료하기");
    System.out.println("==============================");

    num = Integer.parseInt(br.readLine());

    return num;
  }

  public static void exitMenu() {
    System.out.println("bye bye :)");
    System.exit(0);
  }

  public static String getDeleteInfo() throws IOException {
    String memberId;

    System.out.println("멤버 정보를 입력해주세요.");
    System.out.print("멤버 아이디 : ");

    memberId = br.readLine();

    return memberId;
  }

  public static Member getInsertInfo() throws IOException {

    Member member = new Member();
    System.out.println("멤버 추가");
    System.out.print("멤버 아이디 : ");
    member.setmemberId(br.readLine());
    System.out.print("멤버 이름 : ");
    member.setMemberName(br.readLine());
    System.out.print("멤버 비밀번호 : ");
    member.setMemberPassword(br.readLine());
    System.out.print("멤버 나이 : ");
    member.setMemberAge(Integer.parseInt(br.readLine()));

    return member;
  }

  public static Member getUpdateInfo() throws IOException {

    Member member = new Member();
    System.out.println("비밀번호 변경");
    System.out.print("멤버 아이디 : ");
    member.setmemberId(br.readLine());
    System.out.print("현재 비밀번호 : ");
    member.setMemberPassword(br.readLine());
    System.out.print("수정할 비밀번호 : ");
    member.setNewPassword(br.readLine());

    return member;
  }
}
